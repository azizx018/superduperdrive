package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

@Service
public class FileListService {

    private final FileMapper fileMapper;

    public FileListService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public boolean isFileNameAvailable(String fileName, Integer userId) {
        return fileMapper.getFileByFileName(fileName, userId) == null;
    }

    //I still think this would be needed as you are inserting a row into the database
//    public int createFile(File file) {
//        return fileMapper.insert(new File(file.getUserId(), file.getFileName(), file.getFileSize(), file.getContentType(), file.getFileId(),file.getFileData()));
//    }
    public File getFile(String fileName, Integer userId) {
        return fileMapper.getFileByFileName(fileName, userId);
    }

}
