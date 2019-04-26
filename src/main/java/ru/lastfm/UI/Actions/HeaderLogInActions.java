package ru.lastfm.UI.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.lastfm.UI.SearchPage;

public class HeaderLogInActions {
    private WebDriver driver;

    private By dropdownMenuButton = By.xpath("/html/body/div[4]/div[2]/nav/div/div[4]/a");
    private By logoutButton = By.xpath("/html/body/div[4]/div[2]/nav/div/div[4]/div/ul/li[6]/form/a");
    private By profileArea = By.xpath("//*[@id=\"content\"]/div[2]/nav/div/div[4]");
    private By searchButton = By.xpath("/html/body/div[4]/div[2]/nav/div/a[1]");
    private By searchField = By.xpath("//*[@id=\"masthead-search-field\"]");
    private By submitSearch = By.xpath("/html/body/div[4]/div[2]/nav/div/form/div/button");


    public HeaderLogInActions(WebDriver driver){
        this.driver = driver;
    }

    public HeaderLogInActions openDropdownMenuAction(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(dropdownMenuButton)).build().perform();
        return this;
    }

    public HeaderLogInActions clickLogoutButtonAction(){
        openDropdownMenuAction();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        return this;
    }

    public HeaderLogInActions clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public SearchPage searchSmth(String text){
        clickSearchButton();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(text);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(searchField),"value")); //иначе просто происходит переход на страницу поиска
        driver.findElement(submitSearch).click();
        return new SearchPage(driver);
    }

    public boolean isLogIn(){
        return driver.findElement(profileArea).isDisplayed();
    }

}
