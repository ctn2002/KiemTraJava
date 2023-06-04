package hutech.java.chautrongnhan2080601309.repository;

import hutech.java.chautrongnhan2080601309.model.PhongBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<PhongBan, String> {
}
