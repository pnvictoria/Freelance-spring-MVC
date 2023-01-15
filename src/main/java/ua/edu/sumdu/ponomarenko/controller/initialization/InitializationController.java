package ua.edu.sumdu.ponomarenko.controller.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.Country;
import ua.edu.sumdu.ponomarenko.models.Role;
import ua.edu.sumdu.ponomarenko.service.MainService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class InitializationController {

    @Autowired
    private MainService<Account> accountService;

    @Autowired
    private MainService<Country> countryService;

    @GetMapping("/login")
    public String login(){
        return "pages/initialization/login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        Account account = new Account();
        model.addAttribute("account", account);
        List<String> roles = Arrays.asList("Customer", "Executor");
        model.addAttribute("roles", roles);
        List<Country> countries = countryService.getObjects();
        model.addAttribute("countries", countries);
        return "pages/initialization/registration";
    }

    @PostMapping("/registration")
    public ModelAndView registrationPost(@ModelAttribute("account") Account account){
        if (accountService.addObject(account)) {
            return new ModelAndView("pages/initialization/login", "message", "Hi!");
        } else {
            return new ModelAndView("pages/initialization/registration", "message", "Wrong email!");
        }
    }
}
