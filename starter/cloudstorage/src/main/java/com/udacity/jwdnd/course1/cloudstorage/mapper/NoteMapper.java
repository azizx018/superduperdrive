package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE notetitle = #{notetitle} AND userId = #{userId}")
    Note getNoteInfoByNoteTitle(String noteTile, Integer userId);

    @Insert("INSERT INTO NOTES (noteId, notetitle, notedescription, userid) " +
            "VALUES(#{noteId}, #{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer saveNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
    int deleteNoteByNoteId(Integer noteId);


}
