package com.DentalClinic.DH.security.config;


import com.DentalClinic.DH.security.entity.AppUser;
import com.DentalClinic.DH.security.entity.UserRoles;
import com.DentalClinic.DH.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;


    @Autowired
    public DataLoader(UserRepository userRepository ) {
        this.userRepository = userRepository;

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("password");
        String password2 = encoder.encode("password2");

        userRepository.save(new AppUser("user", password, UserRoles.ROLE_USER));
        userRepository.save(new AppUser("admin", password2, UserRoles.ROLE_ADMIN));

    }
}