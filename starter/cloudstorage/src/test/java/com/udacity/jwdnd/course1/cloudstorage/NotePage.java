package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotePage {

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "save-note")
    private WebElement saveNote;

    @FindBy(id = "note-title-view")
    private WebElement noteTitleView;

    @FindBy(id = "note-description-view")
    private WebElement noteDescriptionView;

    @FindBy(id = "editButton")
    private WebElement editButton;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    public NotePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void fetchNotePage(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-notes-tab")));
        WebElement notesViewButton = driver.findElement(By.id("nav-notes-tab"));
        notesViewButton.click();
    }
    public void addNoteButton(WebDriverWait webDriverWait, WebDriver driver) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addNote")));
        WebElement addNoteButton = driver.findElement(By.id("addNote"));
        //wait until element loads
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addNoteButton)).click();
    }
    public void deleteNote(WebDriverWait webDriverWait, WebDriver driver) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("deleteButton")));
        WebElement deleteNoteButton = driver.findElement(By.id("deleteButton"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(deleteNoteButton)).click();
        //deleteButton.click();
    }
    public String getDisplayTitle() {
        return String.valueOf(noteTitleView.getText());
    }
    public String getDisplayDescription() {
        return String.valueOf(noteDescriptionView.getText());
    }
    public void addTitle(){
        noteTitle.sendKeys("Hello");
    }
    public void addDescription() {
        noteDescription.sendKeys("Great Day!");
    }

    public void addNote() {
        saveNote.click();
    }
    public void editNote() {
        //addTitle();
        //addDescription();
        //editButton.click();
        noteTitle.clear();
        noteDescription.clear();
        noteTitle.sendKeys("New note title");
        noteDescription.sendKeys("New note description");
        saveNote.click();


    }
}
