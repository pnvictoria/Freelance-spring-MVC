package ua.edu.sumdu.ponomarenko.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMainController {

    @GetMapping("/main")
    public String mainPage(){
        return "pages/admin-panel/adminMain";
    }

}
