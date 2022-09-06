package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class AttachmentController {
    private AttachmentListService attachmentListService;

    public AttachmentController (AttachmentListService attachmentListService) {
        this.attachmentListService = attachmentListService;
    }
}
