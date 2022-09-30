package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.service.CredentialListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialController {
    private UserService userService;

    private CredentialListService credentialListService;

    public CredentialController(UserService userService, CredentialListService credentialListService) {
        this.userService = userService;
        this.credentialListService = credentialListService;
    }

    @PostMapping("/cred/upload")
    public String addOrUpdateCredential(Authentication authentication, Credential credential) {
        Integer currentUser = userService.getUser(authentication.getName()).getUserId();

        if (credential.getCredentialId() != null) {
            credentialListService.updateCred(credential);
        } else {
            credentialListService.saveCred(credential, currentUser);
        }
        return "redirect:/home";
    }
}
