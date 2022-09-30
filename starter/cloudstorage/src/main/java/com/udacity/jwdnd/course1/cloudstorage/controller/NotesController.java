package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class NotesController {

    private UserService userService;
    private NoteListService noteListService;


    public NotesController(UserService userService, NoteListService noteListService) {
        this.noteListService = noteListService;
        this.userService = userService;
    }

    @PostMapping("/note/upload")
    public String addOrUpdateNote(Authentication authentication, Note note)  {
        Integer currentUser = userService.getUser(authentication.getName()).getUserId();
        note.setUserId(currentUser);

        if (note.getNoteId() != null) {
            noteListService.updateNote(note);

        } else {
            noteListService.saveNote(note, currentUser);

        }
        return "redirect:/home";
    }



}
