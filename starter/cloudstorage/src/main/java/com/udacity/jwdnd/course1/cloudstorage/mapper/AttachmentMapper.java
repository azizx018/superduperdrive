package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachmentMapper {
    @Select("SELECT * FROM FILES WHERE fileName = #{fileName} AND userId = ${userId}")
    Attachment getFileByFileName(String fileName, Integer userId);

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    Attachment getFileByFileId(Integer fileId);

    @Insert("INSERT INTO FILES (fileId, filename, contenttype, filesize, userid, filedata) " +
            "VALUES(#{fileId}, #{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    Integer saveAttachment(Attachment attachment);

    @Select("SELECT * FROM FILES WHERE userId = ${userId}")
    Attachment getFileByUserId(Integer userId);

    @Delete("DELETE FROM FILES WHERE fileId = ${fileId}")
    void deleteFileByFileId(Integer fileId);
}
