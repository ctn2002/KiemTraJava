package hutech.java.chautrongnhan2080601309.repository;

import hutech.java.chautrongnhan2080601309.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
}
