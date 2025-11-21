package iuh.fit.se.rmi;

import iuh.fit.se.entities.CaLam;
import iuh.fit.se.interfaces.CaLam_interface;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {

    public static void main(String[] args) throws Exception {
        Context context = new InitialContext();
        Registry registry = LocateRegistry.getRegistry("localhost", 9090);
        CaLam_interface caLamDAO = (CaLam_interface) registry.lookup("caLamDAO");

        List<CaLam> caLams = caLamDAO.readAll();

        System.out.println("Retrieved " + caLams.size() + " CaLam records:");
        for (CaLam caLam : caLams) {
            System.out.println(caLam);
        }
    }
}
