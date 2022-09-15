package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Attachment;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.web.multipart.MultipartFile;

public class HomePage {
    @FindBy(id = "nav-files")
    private WebElement navFiles;

//    @FindBy(id = "nav-notes-tab")
//    private WebElement navNotesTab;
//
//    @FindBy(id = "nav-credentials-tab")
//    private WebElement navCredentialsTab;

    @FindBy(id = "fileUpload")
    private WebElement fileUpload;

    @FindBy(id = "uploadButton")
    private WebElement uploadButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void uploadAnAttachment() {
        this.fileUpload.isEnabled();
        this.uploadButton.click();
    }


}
