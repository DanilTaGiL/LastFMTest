package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.xpath("//*[@id=\"content\"]/div[2]/nav/div/ul/li[2]/a");

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
}
