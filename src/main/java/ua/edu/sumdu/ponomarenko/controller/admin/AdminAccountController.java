package ua.edu.sumdu.ponomarenko.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.Country;
import ua.edu.sumdu.ponomarenko.service.MainService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/accounts")
public class AdminAccountController {

    @Autowired
    private MainService<Account> accountService;

    @Autowired
    private MainService<Country> countryService;

    @GetMapping("/")
    public String getAllAccounts(Model model){
        model.addAttribute("accounts", accountService.getObjects());
        return "pages/admin-panel/users/adminAllUsers";
    }

    @GetMapping("/new")
    public String newAccount(@ModelAttribute("account") Account account, Model model) {
        List<String> roles = Arrays.asList("Customer", "Executor");
        model.addAttribute("roles", roles);
        model.addAttribute("countries", countryService.getObjects());
        return "pages/admin-panel/users/adminNewUser";
    }

    @PostMapping("/new")
    public String createAccount(@ModelAttribute("account") Account account) {
        accountService.addObject(account);
        return "redirect:./";
    }

    @GetMapping("/edit/{id}")
    public String updateAccount(Model model, @PathVariable("id") int id) {
        model.addAttribute("account", accountService.getObjectById(id));
        List<String> roles = Arrays.asList("Customer", "Executor");
        model.addAttribute("roles", roles);
        model.addAttribute("countries", countryService.getObjects());
        return "pages/admin-panel/users/adminUpdateUser";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") Account account) {
        accountService.updateObject(account);
        return "redirect:../";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String deleteAccount(@PathVariable("id") int id) {
        accountService.removeObject(id);
        return "redirect:../";
    }
}
