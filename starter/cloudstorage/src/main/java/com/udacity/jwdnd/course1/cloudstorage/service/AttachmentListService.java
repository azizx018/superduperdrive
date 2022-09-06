package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.AttachmentMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentListService {

    private final AttachmentMapper attachmentMapper;
    private List<String> attachment;

    public AttachmentListService(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
        this.attachment = new ArrayList<>();
    }

    public boolean isFileNameAvailable(String fileName, Integer userId) {
        return attachmentMapper.getFileByFileName(fileName, userId) == null;
    }

    //I still think this would be needed as you are inserting a row into the database
//    public int createFile(File file) {
//        return fileMapper.insert(new File(file.getUserId(), file.getFileName(), file.getFileSize(), file.getContentType(), file.getFileId(),file.getFileData()));
//    }
    public Attachment getFileByUser(Integer userId) {
        return attachmentMapper.getFileByUserId(userId);
    }

}
