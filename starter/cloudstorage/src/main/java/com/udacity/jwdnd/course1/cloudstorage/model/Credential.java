package com.udacity.jwdnd.course1.cloudstorage.model;

public class Credential {

    private String url;
    private String credUsername;

    private String credPassword;

    public Credential(String url, String credUsername, String credPassword) {
        this.url = url;
        this.credUsername = credUsername;
        this.credPassword = credPassword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCredUsername() {
        return credUsername;
    }

    public void setCredUsername(String username) {
        this.credUsername = username;
    }

    public String getCredPassword() {
        return credPassword;
    }

    public void setCredPassword(String credPassword) {
        this.credPassword = credPassword;
    }



}
