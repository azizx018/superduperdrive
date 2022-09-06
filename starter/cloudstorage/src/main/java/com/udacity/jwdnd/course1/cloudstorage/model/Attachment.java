package com.udacity.jwdnd.course1.cloudstorage.model;

public class Attachment {
    private Integer fileId;

    private String fileName;
    private String contentType;
    private String fileSize;
    private Integer userId;
    private Byte[] fileData;



    public Attachment(Integer fileId, String fileName, String contentType, String fileSize, Integer userId, Byte[] fileData) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userId = userId;
        this.fileData = fileData;
    }
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setFileData(Byte[] fileData) {
        this.fileData = fileData;
    }

    public String getContentType() {
        return contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public Byte[] getFileData() {
        return fileData;
    }

    public Integer getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}