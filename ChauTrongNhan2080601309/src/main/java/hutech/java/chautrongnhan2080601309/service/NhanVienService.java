package hutech.java.chautrongnhan2080601309.service;

import hutech.java.chautrongnhan2080601309.model.NhanVien;
import hutech.java.chautrongnhan2080601309.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> GetAll(){
        return (List<NhanVien>) nhanVienRepository.findAll();
    }

    public void Add(NhanVien newNhanVien){
        nhanVienRepository.save(newNhanVien);
    }

    public NhanVien get(String id) {
        return nhanVienRepository.findById(id).get();
    }

    public void save(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }


    public void delete(String id) {
        nhanVienRepository.deleteById(id);
    }

}
