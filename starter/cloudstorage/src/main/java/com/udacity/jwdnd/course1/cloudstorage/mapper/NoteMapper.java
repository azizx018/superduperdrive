package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId} AND userId = #{userId}")
    Note getNoteInfoByNoteId(Integer noteId, Integer userId);

    @Select("SELECT * FROM NOTES WHERE notetile = #{noteTitle} AND userId = #{userId}")
    Attachment getNoteInfoByNoteTitle(String noteTitle, Integer userId);


    @Insert("INSERT INTO NOTES (noteId, notetitle, notedescription, userid) " +
            "VALUES(#{noteId}, #{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer saveNote(Note note);

    @Select("SELECT * FROM NOTES WHERE userId = ${userId}")
    List<Note> getNoteByUserId(Integer userId);

    @Delete("DELETE FROM NOTES WHERE noteId = ${noteId}")
    int deleteNoteByNoteId(Integer noteId);
}
