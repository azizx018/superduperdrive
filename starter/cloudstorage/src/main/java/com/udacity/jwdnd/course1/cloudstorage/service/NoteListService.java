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

    public void updateNote(Integer noteId, String noteTitle, String noteDescription, Integer userId) {
        Note note = new Note(noteId, noteTitle, noteDescription, userId);
        note.setNoteId(note.getNoteId());
        note.setNoteDescription(note.getNoteDescription());
        note.setNoteTitle(note.getNoteTitle());
        noteMapper.updateNote(note);
    }

    public Integer saveNote(Integer noteId, String noteTitle, String noteDescription, Integer userId) {
        Note note = new Note(null, noteTitle, noteDescription, userId);
        return noteMapper.saveNote(note);
    }
    public Note getSelectedNote(Integer noteId) {
        return noteMapper.selectNote(noteId);
    }

    public List<Note> getNotesByUser(Integer userId) {
        return noteMapper.getNotesByUser(userId);
    }

    public int deleteNote(Integer noteId) {
        return noteMapper.deleteNoteByNoteId(noteId);
    }
}
