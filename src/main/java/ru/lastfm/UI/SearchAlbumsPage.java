package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAlbumsPage {
    private WebDriver driver;

    private By searchField = By.xpath("//*[@id=\"site-search\"]");

    public SearchAlbumsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isFindedAlbum(String text){
        return driver.findElement(searchField).getAttribute("value").equals(text);
    }
}
