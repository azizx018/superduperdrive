package com.udacity.jwdnd.course1.cloudstorage.model;

public class File {

    private String fileName;

    public File (String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
