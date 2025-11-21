package iuh.fit.se;

import iuh.fit.se.services.TaiKhoan_dao;
import iuh.fit.se.entities.TaiKhoan;

import java.rmi.RemoteException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws RemoteException {
        List<TaiKhoan> taiKhoans = new TaiKhoan_dao().readAll();
        System.out.println(taiKhoans);
    }
}
