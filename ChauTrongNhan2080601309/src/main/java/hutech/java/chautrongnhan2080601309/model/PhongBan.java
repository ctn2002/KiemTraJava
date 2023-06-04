package hutech.java.chautrongnhan2080601309.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PHONGBAN")
public class PhongBan {
    @Id
//    @Column(name = "Ma_Phong")
    private String maPhong;

    @NotNull(message = "Tên phòng ban không được để trống")
    @Column(name = "Ten_Phong")
    private String tenPhong;

//    @OneToMany(mappedBy = "phongBan", fetch = FetchType.LAZY)
//    private List<NhanVien> listNhanVien;
    @OneToMany(mappedBy="phongBan")
    private Set<NhanVien> nhanViens;
}
