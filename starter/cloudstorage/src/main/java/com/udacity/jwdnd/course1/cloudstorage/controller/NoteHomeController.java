//package com.udacity.jwdnd.course1.cloudstorage.controller;
//
//import com.udacity.jwdnd.course1.cloudstorage.model.User;
//import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
//import com.udacity.jwdnd.course1.cloudstorage.service.NoteListService;
//import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/notes")
//public class NoteHomeController {
//
//    private NoteListService noteListService;
//    @Autowired
//    private UserService userService;
//
//    public NoteHomeController(NoteListService noteListService, UserService userService) {
//        this.noteListService = noteListService;
//        this.userService = userService;
//
//    }
//
//    @GetMapping()
//    public String getNoteView(Authentication authentication, Model model) {
//        User user = userService.getUser(authentication.getPrincipal().toString());
//        int userId = user.getUserId();
//        model.addAttribute("notes", noteListService.getNotesByUser(userId));
//        return "home";
//    }
//}
