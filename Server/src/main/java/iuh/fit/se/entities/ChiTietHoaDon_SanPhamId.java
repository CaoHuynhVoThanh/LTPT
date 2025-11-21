package iuh.fit.se.entities;

import iuh.fit.se.utils.SerializationUtils;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDon_SanPhamId implements Serializable {
    private static final long serialVersionUID = SerializationUtils.CHITIETHOADON_SANPHAMID_SERIAL_VERSION_UID;
    private String maHD;
    private String maSP;

}
