package ru.lastfm.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;

    private By artistsButton = By.xpath("//*[@id=\"mantle_skin\"]/div[3]/div/div[3]/nav/ul/li[2]/a");
    private By albumsButton = By.xpath("//*[@id=\"mantle_skin\"]/div[3]/div/div[3]/nav/ul/li[3]/a");
    private By tracksButton = By.xpath("//*[@id=\"mantle_skin\"]/div[3]/div/div[3]/nav/ul/li[4]/a");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public SearchTracksPage getTracksPage(){
        driver.findElement(tracksButton).click();
        return new SearchTracksPage(driver);
    }

    public SearchAlbumsPage getAlbumsPage(){
        driver.findElement(albumsButton).click();
        return new SearchAlbumsPage(driver);
    }
}
