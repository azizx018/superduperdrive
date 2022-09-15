package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {
    @FindBy(id = "nav-notes-tab")
    private WebElement notesTab;

    @FindBy(id = "addNoteButton")
    private WebElement addNoteButton;

    @FindBy(id  = "editNote")
    private WebElement editNote;

    @FindBy(id  = "deleteNote")
    private WebElement deleteNote;

    @FindBy(id  = "note-title")
    private WebElement noteTitle;
    @FindBy(id  = "note-description")
    private WebElement noteDescription;
    @FindBy(id  = "saveNote")
    private WebElement saveNote;




    public NotePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void getNotes() {
        notesTab.click();
    }
    public void addNote(String title, String description) {
        addNoteButton.click();
        this.noteTitle.sendKeys(title);
        this.noteDescription.sendKeys(description);
        saveNote.click();
    }
}
