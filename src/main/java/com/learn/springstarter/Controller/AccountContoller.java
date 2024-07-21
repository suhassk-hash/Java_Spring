package com.learn.springstarter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learn.springstarter.models.Account;
import com.learn.springstarter.service.AccountService;

@Controller
public class AccountContoller {

    @Autowired
    private AccountService as;
    @GetMapping("/register")
    public String register(Model model){
        Account a= new Account();
        model.addAttribute("account",a);
        return null;
    }

    @PostMapping("/register")
        public String registeruser(@ModelAttribute Account a){
            as.save(a);
            return "redirect:/";
        }
}
