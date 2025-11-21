package iuh.fit.se.entities;

import iuh.fit.se.utils.SerializationUtils;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ChiTietSanPham_PhieuNhaps")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class ChiTietSanPham_PhieuNhap implements Serializable {
    private static final long serialVersionUID = SerializationUtils.CHITIETSANPHAM_PHIEUNHAP_SERIAL_VERSION_UID;
    @EmbeddedId
    private ChiTietSanPham_PhieuNhapId id;

    @Column(name = "SoLuongSP")
    private int soLuongSP;
    @Column(name ="DonGia")
    private double donGia;

    public ChiTietSanPham_PhieuNhap(ChiTietSanPham_PhieuNhapId id, int soLuongSP, double donGia) {
        this.id = id;
        this.soLuongSP = soLuongSP;
        this.donGia = donGia;
    }

    //check
    @ManyToOne
    @MapsId("maPNH")
    @JoinColumn(name = "MaPNH", nullable = false)
    @ToString.Exclude
    private PhieuNhapHang phieuNhapHang;
    //check
    @ManyToOne
    @MapsId("maSP")
    @JoinColumn(name = "MaSP", nullable = false)
    private SanPham sanPham;
}
