package com.zyihang.codeFellowShip.Controllers;

import com.zyihang.codeFellowShip.models.ApplicationUser;
import com.zyihang.codeFellowShip.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.GeneratedValue;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signUp")
    public RedirectView createNewApplicationUser(String username, String password, String firstName, String lastName, String dataOfBirth, String bio) {

        ApplicationUser newUser = new ApplicationUser(username, passwordEncoder.encode(password), firstName, lastName, dataOfBirth, bio);

        applicationUserRepository.save(newUser);


        return new RedirectView("/");
    }

    @GetMapping ("/login")
    public String showLoginForm(){
        return "login";
    }
}
