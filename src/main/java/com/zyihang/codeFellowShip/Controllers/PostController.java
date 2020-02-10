package com.zyihang.codeFellowShip.Controllers;

import com.zyihang.codeFellowShip.models.ApplicationUser;
import com.zyihang.codeFellowShip.models.ApplicationUserRepository;
import com.zyihang.codeFellowShip.models.Post;
import com.zyihang.codeFellowShip.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;



    @PostMapping("/postDetails")
    public RedirectView makeAPost(long id, String body, String createdAt, boolean kidsAppropriate){
        ApplicationUser postInitiator = applicationUserRepository.findById(id).get();
        Post post = new Post(postInitiator, body, createdAt, kidsAppropriate);
        postRepository.save(post);
        return new RedirectView("/users/" + id);
    }
    @PostMapping("/post/feed")
    public RedirectView generateMingling(long id, long followingId, long followedId ){

        ApplicationUser bh = applicationUserRepository.findById(followingId).get();
        ApplicationUser dis = applicationUserRepository.findById(followedId).get();
        applicationUserRepository.save(bh);



        return new RedirectView("/users/" + id);
    }
}