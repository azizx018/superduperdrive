package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.service.NoteListService;
import com.udacity.jwdnd.course1.cloudstorage.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class NoteController {
    private NoteListService noteListService;
    private UserService userService;

    public NoteController(NoteListService noteListService, UserService userService) {
        this.noteListService = noteListService;
        this.userService = userService;
    }

    @PostMapping("/add/note")
    public String addNewNote(@RequestParam("noteUpload") Note note, Authentication authentication, Model model) throws IOException {
        Integer currentUserId = userService.getUser(authentication.getName()).getUserId();
        String noteTitle = note.getNoteTitle();
        String noteDescription = note.getNoteDescription();
        Boolean isNoteNameAvailable = noteListService.isNoteNameAvailable(noteTitle, currentUserId);

        //Give the user an error if they add a blank note
        if (note.getNoteTitle().isEmpty() || note.getNoteDescription().isEmpty()) {
            model.addAttribute("empty", true);
            model.addAttribute("message", "Please add a note title or note description");
            return "result";
        }
        //Make sure the note title is note a duplicate
        if (!isNoteNameAvailable) {
            model.addAttribute("exists", true);
            model.addAttribute("message", "The note title " + noteTitle + " has already taken.");
            return "result";
        }
        Integer noteId = noteListService.saveNewNote(noteTitle, noteDescription, currentUserId);

        if(noteId > 0) {
            model.addAttribute("success", true);
            model.addAttribute("message", "You successfully added " + noteTitle + " to yor note collection ");
        } else {
            model.addAttribute("error", true);
            model.addAttribute("message", "There was an error adding " + noteTitle);
        }
        return "result";
    }
}
