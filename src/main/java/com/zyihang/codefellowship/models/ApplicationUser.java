package com.zyihang.codefellowship.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            long id;

    String username;
    String password;
    String firstName;
    String lastName;
    String dataOfBirth;
    String bio;


    public ApplicationUser() {
    };

    public ApplicationUser(String username,String password, String firstName,String lastName,String dataOfBirth,String bio){
        this.username=username;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dataOfBirth=dataOfBirth;
        this.bio=bio;
    }
}




