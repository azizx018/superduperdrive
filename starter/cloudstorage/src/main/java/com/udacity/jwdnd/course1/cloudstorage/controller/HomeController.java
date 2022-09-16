package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private AttachmentListService attachmentListService;
    @Autowired
    private UserService userService;
    private NoteListService noteListService;



    public HomeController(AttachmentListService attachmentListService, UserService userService, NoteListService noteListService) {
        this.attachmentListService = attachmentListService;
        this.userService = userService;
        this.noteListService = noteListService;
    }


    @GetMapping()
    public String getHomePage(Authentication authentication, Model model) {
        User user = userService.getUser(authentication.getPrincipal().toString());
        int userId = user.getUserId();
        model.addAttribute("notes", this.noteListService.getNotesByUser(userId));
        model.addAttribute("attachments", this.attachmentListService.getAttachmentsByUser(userId));
        return "home";
    }


}
