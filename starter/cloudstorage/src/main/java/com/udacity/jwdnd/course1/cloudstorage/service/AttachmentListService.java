package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.AttachmentMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttachmentListService {

    private final AttachmentMapper attachmentMapper;

    public AttachmentListService(AttachmentMapper attachmentMapper) {
        this.attachmentMapper = attachmentMapper;
    }

    public boolean isAttachmentNameAvailable(String fileName, Integer userId) {
        return attachmentMapper.getAttachmentInfoByFileName(fileName, userId) == null;
    }

    public List<Attachment>  getAttachmentsByUser(Integer userId) {
        return attachmentMapper.getAttachmentsByUserId(userId);
    }

}
