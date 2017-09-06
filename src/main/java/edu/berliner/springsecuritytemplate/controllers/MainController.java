package edu.berliner.springsecuritytemplate.controllers;

import edu.berliner.springsecuritytemplate.repositories.SecurityRoleRepository;
import edu.berliner.springsecuritytemplate.repositories.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController
{
    @Autowired
    SecurityRoleRepository roleRepo;

    @Autowired
    SecurityUserRepository userRepo;


    @RequestMapping({"/", "/index"})
    public String firstPage()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping("/signup")
    public String signupPage()
    {
        return "signup";
    }

    //For testing
    @RequestMapping("welcome")
    public String welcomePage()
    {
        return "welcome";
    }
}
