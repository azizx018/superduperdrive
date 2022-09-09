package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@Controller

public class AttachmentController {
    private AttachmentListService attachmentListService;
    private UserService userService;

    public AttachmentController (AttachmentListService attachmentListService, UserService userService) {
        this.attachmentListService = attachmentListService;
        this.userService = userService;
    }
    @PostMapping("/upload/attachment")
    public String uploadAttachment(@RequestParam("fileUpload") MultipartFile attachment, Authentication authentication, Model model) {
        Integer currentUserId = userService.getUser(authentication.getName()).getUserId();

        try {
            Integer fileId = attachmentListService.saveUploadedFile(attachment, currentUserId);

            if(fileId > 0) {
                model.addAttribute("success",true);
                model.addAttribute("message", "You successfully uploaded" + attachment.getOriginalFilename() + "!");
            } else {
                model.addAttribute("error", true);
                model.addAttribute("message", "There was an error uploading your file " + attachment.getOriginalFilename() + "!");
            }
        } catch (IOException ioException) {
            model.addAttribute("error", true);
            model.addAttribute("message", "There was an error uploading your file " + attachment.getOriginalFilename() + "!");
        }
        return "result";
    }
//    @PostMapping("/upload")
//    public String uploadAttachment(@RequestParam("/upload") @ModelAttribute Attachment attachment, Model model) {
//        String attachmentUploadError = null;
//
//        if (!attachmentListService.isAttachmentNameAvailable(attachment)) {
//            attachmentUploadError = "That file name already exists.";
//            model.addAttribute("error", true);
//            model.addAttribute("message",attachmentUploadError);
//
//        }
//
//        if (attachmentUploadError == null) {
//            int rowsAdded = attachmentListService.saveUploadedFile(attachment);
//            if (rowsAdded < 0) {
//                attachmentUploadError = "There was an error adding your file." + attachment.getFileName() +  "Please try again.";
//                model.addAttribute("error", true);
//                model.addAttribute("message",attachmentUploadError);
//            }
//        }
//
//        if (attachmentUploadError != null) {
//            model.addAttribute("success", true);
//            return "result";
//        }
//        return "redirect:/home?message=File Upload Was Successful!&status=true";
//    }

}
