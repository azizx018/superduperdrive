package com.udacity.jwdnd.course1.cloudstorage.config;

import com.udacity.jwdnd.course1.cloudstorage.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(this.authenticationService);
//    }


}
