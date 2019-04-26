package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchTracksPage {
    private WebDriver driver;

    private By searchField = By.xpath("//*[@id=\"site-search\"]");

    public SearchTracksPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isFindedTrack(String text){
        return driver.findElement(searchField).getAttribute("value").equals(text);
    }
}
