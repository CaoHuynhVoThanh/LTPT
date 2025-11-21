package iuh.fit.se.interfaces;

import iuh.fit.se.entities.ChiTietHoaDon_SanPham;
import iuh.fit.se.entities.ChiTietHoaDon_SanPhamId;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChiTietHoaDon_SanPham_interface extends Remote {
    void create(ChiTietHoaDon_SanPham chiTiet) throws RemoteException;

    ChiTietHoaDon_SanPham read(ChiTietHoaDon_SanPhamId id) throws RemoteException;

    List<ChiTietHoaDon_SanPham> readAll() throws RemoteException;

    void update(ChiTietHoaDon_SanPham chiTiet) throws RemoteException;

    void delete(ChiTietHoaDon_SanPhamId id) throws RemoteException;
}
