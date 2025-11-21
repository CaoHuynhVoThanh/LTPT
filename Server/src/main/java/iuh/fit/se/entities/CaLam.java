package iuh.fit.se.entities;

import iuh.fit.se.utils.SerializationUtils;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "CaLams")
public class CaLam implements Serializable {
    private static final long serialVersionUID = SerializationUtils.CALAM_SERIAL_VERSION_UID;
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "MaCa", nullable = false)
    private String maCa;

    @Column(name = "GioBatDau")
    private LocalDateTime gioBatDau;

    @Column(name = "GioKetThuc")
    private LocalDateTime gioKetThuc;

    @Column(name = "TrangThai")
    private boolean trangThai;

    public CaLam(String maCa, LocalDateTime gioBatDau, LocalDateTime gioKetThuc, boolean trangThai) {
        this.maCa = maCa;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.trangThai = trangThai;
    }

    //check
    @OneToMany(mappedBy = "caLam", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<HoaDon> hoaDons = new HashSet<>();

    //check
    @ManyToOne
    @JoinColumn(name = "maTaiKhoan", nullable = false)
    private TaiKhoan taiKhoan;
}