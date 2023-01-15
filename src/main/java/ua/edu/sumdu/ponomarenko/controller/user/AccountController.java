package ua.edu.sumdu.ponomarenko.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.edu.sumdu.ponomarenko.models.Account;
import ua.edu.sumdu.ponomarenko.models.Orders;
import ua.edu.sumdu.ponomarenko.models.Request;
import ua.edu.sumdu.ponomarenko.service.MainService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class AccountController {

    @Value(value = "${CUSTOMER_ID}")
    private int CUSTOMER_ID;
    @Value(value = "${EXECUTOR_ID}")
    private int EXECUTOR_ID;

    @Autowired
    private MainService<Orders> orderService;

    @Autowired
    private MainService<Account> accountService;

    @Autowired
    private MainService<Request> requestService;

    @GetMapping("/account")
    public String getAccount(Model model, Authentication authentication) {
        Account account = accountService.getObjectById(accountService.getByItem(new Account(authentication.getName())).get(0).getId());
        model.addAttribute("account", account);

        List<Orders> personOrders = new ArrayList<>();
        for (Orders order : orderService.getObjects()) {
            if (order.getAccount() == account.getId()) {
                personOrders.add(order);
            }
        }
        model.addAttribute("personOrders", personOrders);
        model.addAttribute("requests", requestService.getByItem(new Request(account.getId())));
        return "pages/user-panel/user";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderService.getObjects());
        model.addAttribute("order", new Orders());
        return "pages/user-panel/orders";
    }

    @GetMapping("/orders/{id}")
    public String getNewsById(Model model, @PathVariable("id") int id) {
        model.addAttribute("order", orderService.getObjectById(id));
        List<Request> requests = new ArrayList<>();
        for (Request request : requestService.getObjects()) {
            if (request.getOrder().getOrderId() == id) {
                requests.add(request);
            }
        }
        model.addAttribute("request",new Request());
        model.addAttribute("requests", requests);
        return "pages/user-panel/single/singleOrder";
    }

    @PostMapping("/orders/{id}")
    public ModelAndView registrationRequest( @PathVariable("id") int id, @ModelAttribute("request") Request request,
                                             Model model, Authentication authentication) {

        model.addAttribute("order", orderService.getObjectById(id));

        request.setOrder(orderService.getObjectById(id));
        request.setAccount(accountService.getByItem(new Account(authentication.getName())).get(0).getId());

        if (requestService.addObject(request)) {
            return new ModelAndView("pages/user-panel/single/singleOrder", "message", "New request created");
        } else {
            return new ModelAndView("pages/user-panel/single/singleOrder", "message", "Error with creation");
        }
    }

    @PostMapping("/orders")
    public ModelAndView registrationPost(@ModelAttribute("order") Orders order, Model model, Authentication authentication) {
        model.addAttribute("orders", orderService.getObjects());
        order.setAccount(accountService.getByItem(new Account(authentication.getName())).get(0).getId());
        if (orderService.addObject(order)) {
            return new ModelAndView("pages/user-panel/orders", "message", "New order created");
        } else {
            return new ModelAndView("pages/user-panel/orders", "message", "Error with creation");
        }
    }

    @GetMapping("/executors")
    public String getExecutors(Model model) {
        List<Account> executors = new ArrayList<>();
        for (Account account : accountService.getObjects()) {
            if (account.getRole().getId() == EXECUTOR_ID) {
                executors.add(account);
            }
        }
        model.addAttribute("executors", executors);
        return "pages/user-panel/executors";
    }

    @GetMapping("/executors/{id}")
    public String getExecutorsById(Model model, @PathVariable("id") int id) {
        Account account = accountService.getObjectById(id);
        model.addAttribute("account", account);
        model.addAttribute("requests", requestService.getByItem(new Request(account.getId())));
        return "pages/user-panel/single/singleUser";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "pages/user-panel/contact";
    }

    @GetMapping("/customers")
    public String getCustomers(Model model) {
        List<Account> customers = new ArrayList<>();
        for (Account account : accountService.getObjects()) {
            if (account.getRole().getId() == CUSTOMER_ID) {
                customers.add(account);
            }
        }
        model.addAttribute("customers", customers);
        return "pages/user-panel/customers";
    }

    @GetMapping("/customers/{id}")
    public String getCustomersById(Model model, @PathVariable("id") int id) {
        Account account = accountService.getObjectById(id);
        model.addAttribute("account", account);
        model.addAttribute("personOrders", orderService.getByItem(new Orders(account.getId())));
        return "pages/user-panel/single/singleUser";
    }
}
