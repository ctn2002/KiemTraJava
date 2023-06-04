package hutech.java.chautrongnhan2080601309.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
