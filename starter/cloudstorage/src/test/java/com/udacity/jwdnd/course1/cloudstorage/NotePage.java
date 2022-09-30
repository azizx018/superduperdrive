package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotePage {

    @FindBy(id = "note-title")
    private WebElement noteTitle;

    @FindBy(id = "note-description")
    private WebElement noteDescription;

    @FindBy(id = "noteSubmit")
    private WebElement noteSubmit;

    @FindBy(id = "note-title-view")
    private WebElement noteTitleView;

    @FindBy(id = "note-description-view")
    private WebElement noteDescriptionView;

    public NotePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public String getDisplayTitle() {
        return String.valueOf(noteTitleView.getText());
    }
    public String getDisplayDescription() {
        return String.valueOf(noteDescriptionView.getText());
    }
    public void addTitle(){
        noteTitle.sendKeys("hello");
    }
    public void addDescription() {
        noteDescription.sendKeys("Today");
    }

    public void addNote() {
        noteSubmit.click();
    }
}
