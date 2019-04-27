package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConnectApplicationPage {
    WebDriver driver;

    public ConnectApplicationPage(WebDriver driver){
        this.driver = driver;
    }

    private By yesButtion = By.xpath("/html/body/div[4]/div[2]/div[3]/div[3]/div/div/section/form/div/div/button");

    public void clickYesButton(){
        driver.findElement(yesButtion).click();
    }
}
