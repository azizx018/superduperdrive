package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import com.udacity.jwdnd.course1.cloudstorage.service.AttachmentListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    public String uploadAttachment(@RequestParam("fileUpload") MultipartFile attachment, Authentication authentication, Model model) throws IOException{
        Integer currentUserId = userService.getUser(authentication.getName()).getUserId();
        String fileName = attachment.getOriginalFilename();
        Boolean isAttachmentNameAvailable = attachmentListService.isAttachmentNameAvailable(fileName, currentUserId);

        try {
            //Give the user an error no file is selected
            if (attachment.isEmpty()) {
                model.addAttribute("empty", true);
                model.addAttribute("message", "Please choose a file to upload!");
                return "result";
            }
            // check is the fileName already exists
            if(!isAttachmentNameAvailable) {
                model.addAttribute("exists", true);
                model.addAttribute("message", "The file name " + fileName + " is already taken!");
                return "result";
            }
            Integer fileId = attachmentListService.saveUploadedFile(attachment, currentUserId);

            if(fileId > 0) {
                model.addAttribute("success",true);
                model.addAttribute("message", "You successfully uploaded" + fileName + "!");
            } else {
                model.addAttribute("error", true);
                model.addAttribute("message", "There was an error uploading your file " + fileName + "!");
            }
        } catch (IOException ioexception) {
            model.addAttribute("error", true);
            model.addAttribute("message", "There was an error uploading your file " + fileName + "!");
        }
        return "result";
    }
//    @PostMapping("/upload/attachment")
//    public String uploadAttachment(@RequestParam("fileUpload") MultipartFile attachment, Authentication authentication, Model model) throws IOException{
//        Integer currentUserId = userService.getUser(authentication.getName()).getUserId();
//        String fileName = attachment.getOriginalFilename();
//        Boolean isAttachmentNameAvailable = attachmentListService.isAttachmentNameAvailable(fileName, currentUserId);
//
//        if(isAttachmentNameAvailable == false) {
//            model.addAttribute("error", true);
//            model.addAttribute("message", "The file name " + fileName + " is already taken!");
//            return "result";
//        }
//
//        try {
//            Integer fileId = attachmentListService.saveUploadedFile(attachment, currentUserId);
//            if(fileId > 0) {
//                model.addAttribute("success",true);
//                model.addAttribute("message", "You successfully uploaded" + fileName + "!");
//            } else {
//                model.addAttribute("error", true);
//                model.addAttribute("message", "There was an error uploading your file " + fileName + "!");
//            }
//
//
//        } catch (IOException ioexception) {
//            model.addAttribute("error", true);
//            model.addAttribute("message", "There was an error uploading your file " + fileName + "!");
//        }
//
//        return "result";
//    }


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
    @GetMapping("/attachment/view/{fileId}")
    public ResponseEntity viewAttachment(@PathVariable("fileId") Integer fileId) {
        Attachment attachment = attachmentListService.getUserRequestedImage(fileId);
        String fileName = attachment.getFileName();
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" + fileName + "\"")
                .body(attachment.getFileData());
    }

}
