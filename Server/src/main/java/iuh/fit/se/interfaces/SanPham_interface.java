package iuh.fit.se.interfaces;

import iuh.fit.se.entities.SanPham;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface SanPham_interface extends Remote {
    void create(SanPham sanPham) throws RemoteException;

    SanPham read(String maSP) throws RemoteException;

    List<SanPham> readAll() throws RemoteException;

    void update(SanPham sanPham) throws RemoteException;

    void delete(String maSP) throws RemoteException;
}
