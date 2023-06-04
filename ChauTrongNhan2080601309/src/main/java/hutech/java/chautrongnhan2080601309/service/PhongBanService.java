package hutech.java.chautrongnhan2080601309.service;

import hutech.java.chautrongnhan2080601309.model.NhanVien;
import hutech.java.chautrongnhan2080601309.model.PhongBan;
import hutech.java.chautrongnhan2080601309.repository.NhanVienRepository;
import hutech.java.chautrongnhan2080601309.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> GetAll(){
        return (List<PhongBan>) phongBanRepository.findAll();
    }

    public void Add(PhongBan newPhongBan){
        phongBanRepository.save(newPhongBan);
    }

    public PhongBan get(String id) {
        return phongBanRepository.findById(id).get();
    }

    public void save(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }


    public void delete(String id) {
        phongBanRepository.deleteById(id);
    }
}
