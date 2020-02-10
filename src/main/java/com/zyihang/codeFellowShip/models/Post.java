package com.zyihang.codeFellowShip.models;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;



    @ManyToOne
    ApplicationUser applicationUser;

    String body;
    public String createdAt;
    boolean kidsAppropriate;


    public Post(ApplicationUser applicationUser, String body, String createdAt, boolean kidsAppropriate) {
        this.applicationUser = applicationUser;
        this.body = body;
        this.createdAt = createdAt;
        this.kidsAppropriate = kidsAppropriate;
    }
    public Post(){

    }

    public long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public String getBody() {
        return body;
    }

    public boolean isKidsAppropriate() {
        return kidsAppropriate;
    }


}
