package ua.edu.sumdu.ponomarenko.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.edu.sumdu.ponomarenko.models.Country;
import ua.edu.sumdu.ponomarenko.service.MainService;

@Controller
@RequestMapping("/admin/country")
public class AdminCountryController {

    @Autowired
    private MainService<Country> countryService;

    @GetMapping("/")
    public String getAllCountry(Model model){
        model.addAttribute("countries", countryService.getObjects());
        return "pages/admin-panel/country/adminAllCountry";
    }

    @GetMapping("/new")
    public String newCountry(@ModelAttribute("country") Country country) {
        return "pages/admin-panel/country/adminNewCountry";
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public String create(@ModelAttribute("country") Country country) {
        countryService.addObject(country);
        return "redirect:./";
    }

    @GetMapping("/edit/{id}")
    public String updateCountry(Model model, @PathVariable("id") int id) {
        model.addAttribute("country", countryService.getObjectById(id));
        return "pages/admin-panel/country/adminUpdateCountry";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
    public String updateCountry(@ModelAttribute("country") Country country) {
        countryService.updateObject(country);
        return "redirect:../";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    public String deleteCountry(@PathVariable("id") int id) {
        countryService.removeObject(id);
        return "redirect:../";
    }
}
