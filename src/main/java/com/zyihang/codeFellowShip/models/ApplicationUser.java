package com.zyihang.codeFellowShip.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            public long id;

    @ManyToMany
    @JoinTable(
            name="feed",
            joinColumns = {@JoinColumn(name="followingId")},
            inverseJoinColumns = {@JoinColumn(name="followedId")}

    )

    public Set<ApplicationUser> usersFollowingMe;
    public long getId() {
        return id;
    }
    @ManyToMany(mappedBy = "usersFollowingMe")
    public Set<ApplicationUser> usersIAmFollowing;

    @OneToMany(mappedBy = "applicationUser")
            List<Post> posts ;



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

    public List<Post> getPosts(){
        return this.posts;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}




