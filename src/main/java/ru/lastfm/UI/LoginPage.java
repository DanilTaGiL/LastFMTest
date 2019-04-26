package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By usernameField = By.xpath("//*[@id=\"id_username\"]");
    private By passwordField = By.xpath("//*[@id=\"id_password\"]");

    private By submitButton = By.xpath("//*[@id=\"login\"]/div[3]/div/button");

    public LoginPage typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomePage clickSubmitForm(){
        driver.findElement(submitButton).click();
        return new HomePage(driver);
    }
}
