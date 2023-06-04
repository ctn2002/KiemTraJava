package hutech.java.chautrongnhan2080601309.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "NHANVIEN")
public class NhanVien {

    @Id
    @Column(name = "MA_NV")
    private String id;

    @NotNull(message = "Tên nhân viên không được để trống")
    @Column(name = "TEN_NV")
    private String ten;

    @Column(name = "Phai")
    private  String phai;

    @Column(name = "Noi_Sinh")
    private String noiSinh;

    @NotNull(message = "Mã phòng ban không được để trống")
//    @Column(name = "Ma_Phong")
    private String maPhong;

    @Column(name = "Luong")
    private int luong;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "maPhong")
//    private PhongBan phongBan;
    @ManyToOne
    @JoinColumn(name="maPhong", nullable=false, insertable = false, updatable = false)
    private PhongBan phongBan;
}
