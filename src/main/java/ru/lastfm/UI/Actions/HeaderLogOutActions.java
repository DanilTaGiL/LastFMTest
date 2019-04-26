package ru.lastfm.UI.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.lastfm.UI.LoginPage;

public class HeaderLogOutActions {
    private WebDriver driver;

    public HeaderLogOutActions(WebDriver driver){
        this.driver = driver;
    }

    private By loginButton = By.xpath("//*[@id=\"content\"]/div[2]/nav/div/ul/li[2]/a");

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public boolean isLogOut(){
        return driver.findElement(loginButton).isDisplayed();
    }
}
