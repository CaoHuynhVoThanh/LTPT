package iuh.fit.se.entities;

import iuh.fit.se.utils.SerializationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode

public class ChiTietSanPham_PhieuNhapId implements Serializable {
    private static final long serialVersionUID = SerializationUtils.CHITIETSANPHAM_PHIEUNHAPID_SERIAL_VERSION_UID;
    private String maPNH;
    private String maSP;

    public ChiTietSanPham_PhieuNhapId() {

    }

    public ChiTietSanPham_PhieuNhapId(String maPNH, String maSP) {
        this.maPNH = maPNH;
        this.maSP = maSP;
    }
}
