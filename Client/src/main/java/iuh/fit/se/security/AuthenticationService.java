package iuh.fit.se.security;

import iuh.fit.se.entities.TaiKhoan;
import iuh.fit.se.enums.ChucVu;
import iuh.fit.se.interfaces.TaiKhoan_interface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Service for handling authentication
 */
public class AuthenticationService {
    private final TaiKhoan_interface taiKhoanDAO;

    public AuthenticationService(TaiKhoan_interface taiKhoanDAO) throws NotBoundException, RemoteException {
        System.setProperty("java.security.policy", "rmi.policy");
        System.setProperty("java.rmi.server.hostname", "localhost");
        java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry("localhost", 9090);
        this.taiKhoanDAO = (TaiKhoan_interface) registry.lookup("taiKhoanDAO");

    }

    /**
     * Authenticate a user with username and password
     *
     * @param username The username
     * @param password The password
     * @return true if authentication successful, false otherwise
     * @throws RemoteException if there's an RMI error
     */
    public boolean authenticate(String username, String password) throws RemoteException {
        TaiKhoan taiKhoan = taiKhoanDAO.findByUsernameandPassword(username, password);

        if (taiKhoan == null) {
            return false;
        }

        // Password is already checked in the findByUsernameandPassword method

        // Determine role based on the user's position (chucVu)
        Role role;
        try {
            if (taiKhoan.getNhanVien() != null && taiKhoan.getNhanVien().getChucVu() == ChucVu.Nguoi_Quan_Ly) {
                role = Role.QUAN_LY;
                System.out.println("User assigned QUAN_LY role");
            } else {
                role = Role.NHAN_VIEN;
                System.out.println("User assigned NHAN_VIEN role");
            }
        } catch (Exception e) {
            // If there's any error determining the role, default to NHAN_VIEN
            System.out.println("Error determining role: " + e.getMessage());
            role = Role.NHAN_VIEN;
        }

        // Set the authenticated user in the security context
        SecurityContext.getInstance().setCurrentUser(taiKhoan, role);
        return true;
    }

    /**
     * Log out the current user
     */
    public void logout() {
        SecurityContext.getInstance().clearContext();
    }
}
