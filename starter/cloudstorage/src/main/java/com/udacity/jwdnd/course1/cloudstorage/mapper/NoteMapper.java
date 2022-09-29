package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    List<Note> getNotesByUser(Integer userId);

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    Note selectNote(Integer noteId);

    @Insert("INSERT INTO NOTES (noteId, noteTitle, noteDescription, userId) " +
            "VALUES(#{noteId}, #{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer saveNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
    int deleteNoteByNoteId(Integer noteId);

    @Update("UPDATE NOTES SET noteTitle = #{noteTitle}, #{noteDescription}, WHERE noteId = #{noteId}")
    void updateNote(Note note);


}
