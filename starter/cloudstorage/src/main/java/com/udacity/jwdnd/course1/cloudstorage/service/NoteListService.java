package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteListService {
    private final NoteMapper noteMapper;

    public NoteListService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }
    public boolean isNoteNameAvailable(String noteTitle, Integer userId) {
        return noteMapper.getNoteInfoByNoteTitle(noteTitle, userId) == null;
    }

    public Integer saveNewNote(String noteTitle, String noteDescription, Integer userId) {
        Note note = new Note(null, noteTitle, noteDescription, userId);
        return noteMapper.saveNote(note);
    }
    public List<Note> getNotesByUser(Integer userId) {
        return noteMapper.getNoteByUserId(userId);
    }
    public int deleteNote(Integer noteId) {
        return noteMapper.deleteNoteByNoteId(noteId);
    }

    public void editSelectedNote(Integer noteId, Integer userId) {
        Note selectedNote = noteMapper.getNoteInfoByNoteId(noteId, userId);

    }
}
