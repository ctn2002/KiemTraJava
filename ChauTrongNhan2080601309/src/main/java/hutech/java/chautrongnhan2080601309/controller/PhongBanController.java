package hutech.java.chautrongnhan2080601309.controller;

import hutech.java.chautrongnhan2080601309.model.NhanVien;
import hutech.java.chautrongnhan2080601309.model.PhongBan;
import hutech.java.chautrongnhan2080601309.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phongban")
public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listPhongBan", phongBanService.GetAll());
        return "PhongBan/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("phongBan", new PhongBan());
        return "PhongBan/create";
    }

    @PostMapping("/create")
    public String create(@Valid PhongBan newPhongBan, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product", newPhongBan);
            return "PhongBan/create";
        }
        phongBanService.Add(newPhongBan);
        return "redirect:/phongban";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") String id, Model model) {
        PhongBan phongBan = phongBanService.get(id);
        model.addAttribute("phongban", phongBan);
        return "PhongBan/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("product") PhongBan phongBan, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("phongban", phongBan);
            return "PhongBan/edit";
        }
        phongBanService.save(phongBan);
        return "redirect:/phongban";
    }
}
