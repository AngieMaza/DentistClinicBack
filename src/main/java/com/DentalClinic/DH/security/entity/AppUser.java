package com.DentalClinic.DH.security.entity;


import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Entity
public class AppUser implements UserDetails {
    @Id
    @SequenceGenerator( name = "user_seq", sequenceName = "user_seq" )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "user_seq" )
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRoles role;

    public AppUser() {
    }

    public AppUser(String username, String password, UserRoles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        System.out.println(authority);
        return Collections.singletonList(authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
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
