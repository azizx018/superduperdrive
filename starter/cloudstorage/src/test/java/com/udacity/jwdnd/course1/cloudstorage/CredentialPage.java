package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CredentialPage {
    @FindBy(id = "add-new-credential-button")
    private WebElement addCredentialButton;

    @FindBy(id = "editCredential")
    private WebElement editCredentialButton;

    @FindBy(id = "deleteCredential")
    private WebElement deleteCredentialButton;

    @FindBy(id = "cred-url-display-value")
    private WebElement credUrlDisplayValue;

    @FindBy(id = "cred-username-display-value")
    private WebElement credUsernameDisplayValue;

    @FindBy(id = "cred-password-display-value")
    private WebElement credPasswordDisplayValue;

    @FindBy(id = "credential-url")
    private WebElement credUrlInput;

    @FindBy(id = "credential-username")
    private WebElement credUsernameInput;

    @FindBy(id = "credential-password")
    private WebElement credPasswordInput;

    @FindBy(id = "save-cred-button")
    private WebElement saveCredentialsButton;

    public CredentialPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void fetchCredPage(WebDriver driver) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-credentials-tab")));
        WebElement credentialViewButton = driver.findElement(By.id("nav-credentials-tab"));
        credentialViewButton.click();
    }
    public void addCredButton(WebDriverWait webDriverWait, WebDriver driver) {
        //wait until element loads
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addCredentialButton)).click();
    }
    public void addUrl() {
        credUrlInput.sendKeys("www.helloWorld.com");
    }
    public void addUsername() {
        credUsernameInput.sendKeys("RocketMan");
    }
    public void addPassword() {
        credPasswordInput.sendKeys("Rocket");
    }
    public void saveCred() {
        saveCredentialsButton.click();
    }
    public String getUrlDisplayValue() {
        return String.valueOf(credUrlDisplayValue.getText());
    }
    public String getUsernameDisplayValue() {
        return String.valueOf(credUsernameDisplayValue.getText());
    }
    public String getPasswordDisplayValue() {
        return String.valueOf(credPasswordDisplayValue.getText());
    }
}
