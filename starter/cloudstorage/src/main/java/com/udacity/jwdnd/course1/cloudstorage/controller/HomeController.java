package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private AttachmentListService attachmentListService;

    public HomeController (AttachmentListService attachmentListService) {
        this.attachmentListService = attachmentListService;
    }

    @GetMapping()
    public String getHomePage(AttachmentListService attachmentListService, Model model, String fileName, Integer userId) {
        model.addAttribute(this.attachmentListService.getFile(fileName, userId));
        return "home";
    }


}
