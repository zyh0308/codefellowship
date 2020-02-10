package com.zyihang.codeFellowShip.Controllers;

import com.zyihang.codeFellowShip.models.ApplicationUser;
import com.zyihang.codeFellowShip.models.ApplicationUserRepository;
import com.zyihang.codeFellowShip.models.Post;
import com.zyihang.codeFellowShip.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import sun.security.krb5.internal.ccache.CredentialsCache;

import javax.persistence.GeneratedValue;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;
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

    @GetMapping("/users/{id}")
    public String showUserDetails(@PathVariable long id, Principal p, Model m){
        ApplicationUser theUser = applicationUserRepository.findById(id).get();
        m.addAttribute("userWeAreVisiting", theUser);
        return "userDetails";

    }
    @GetMapping("/myProfile")
    public String showMyProfile(Principal p, Model m){
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("loggedInUser", user);
        return "myProfile";
    }

    @PostMapping("/myProfile")
    public RedirectView createPost(Principal p, Model m, String body, boolean appropriate){
        String now = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        Post newPost = new Post(user, body, now, appropriate);
        postRepository.save(newPost);
        return new RedirectView("myProfile");

    }



    @PostMapping("/followMe/{id}")
    public RedirectView follow(@PathVariable long id, Principal p){
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser toBeFollowed = applicationUserRepository.findById(id).get();
        loggedInUser.usersFollowingMe.add(toBeFollowed);
        applicationUserRepository.save(toBeFollowed);
        return new RedirectView("/users/" + toBeFollowed.getId());
    }
}


