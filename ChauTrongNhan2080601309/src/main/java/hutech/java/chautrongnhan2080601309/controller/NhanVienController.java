package hutech.java.chautrongnhan2080601309.controller;

import hutech.java.chautrongnhan2080601309.model.NhanVien;
import hutech.java.chautrongnhan2080601309.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listnhanvien", nhanVienService.GetAll());
        return "NhanVien/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        return "NhanVien/create";
    }

    @PostMapping("/create")
    public String create(@Valid NhanVien newNhanVien,BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("nhanvien", newNhanVien);
            return "nhanvien/create";
        }
        nhanVienService.Add(newNhanVien);
        return "redirect:/nhanvien";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") String id, Model model) {
        NhanVien nhanVien = nhanVienService.get(id);
        model.addAttribute("nhanvien", nhanVien);
        return "NhanVien/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") NhanVien nhanVien, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("nhanvien", nhanVien);
            return "NhanVien/edit";
        }
        nhanVienService.save(nhanVien);
        return "redirect:/nhanvien";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        nhanVienService.delete(id);
        return "redirect:/nhanvien";
    }

}
