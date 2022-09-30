package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private NoteListService noteListService;
    @Autowired
    private AttachmentListService attachmentListService;
    @Autowired
    private UserService userService;




    public HomeController(AttachmentListService attachmentListService, NoteListService noteListService, UserService userService) {
        this.attachmentListService = attachmentListService;
        this.userService = userService;
        this.noteListService = noteListService;

    }


    @GetMapping()
    public String getHomePage(Authentication authentication, Model model) {
        User user = userService.getUser(authentication.getPrincipal().toString());
        int userId = user.getUserId();
        model.addAttribute("notes", noteListService.getNotesByUser(userId));
        model.addAttribute("attachments", attachmentListService.getAttachmentsByUser(userId));
        return "home";
    }

//    @PostMapping("/logout")
//    public String backLogin(Model model) {
//        model.addAttribute("loutOutStatus", true);
//        return "login";
//    }


}
