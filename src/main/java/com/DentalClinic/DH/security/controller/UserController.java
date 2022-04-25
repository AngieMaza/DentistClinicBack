package com.DentalClinic.DH.security.controller;



import com.DentalClinic.DH.security.entity.AppUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

@GetMapping("/register")
    public ResponseEntity<AppUser> getUser(){
        return null;
    }
}

