import io.qameta.allure.Step;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.lastfm.REST.API;
import ru.lastfm.UI.actions.HeaderLogInActions;
import ru.lastfm.UI.actions.HeaderLogOutActions;
import ru.lastfm.UI.ConnectApplicationPage;

import java.util.concurrent.TimeUnit;

public class UITests {
    private final String MAIN_URL = "https://www.last.fm/";
    private final String DRIVER = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\projects\\Selenium\\Firefox\\geckodriver\\geckodriver.exe";

    private WebDriver driver;
    private HeaderLogOutActions headerLogOut;
    private HeaderLogInActions headerLogIn;


    @Before
    public void startTest(){
        System.setProperty(DRIVER, DRIVER_PATH);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        headerLogIn = new HeaderLogInActions(driver);
        headerLogOut = new HeaderLogOutActions(driver);
        driver.get(MAIN_URL);
    }

    @After
    public void quit(){
        driver.quit();
    }

    @Test
    public void loginAndLogoutTest(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        logoutStep();
    }

    @Test
    public void searchAnySong(){
        searchTracksStep("Noize MC");
    }

    @Test
    public void searchAnyAlbums(){
        searchAlbumStep("Noize MC");
    }

    @Ignore
    @Test
    public void tokenAuthorize(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        driver.get(API.API_URL + "/auth/?api_key=" + API.API_KEY + "&token=" + RESTTests.apiToken);
        ConnectApplicationPage yes = new ConnectApplicationPage(driver);
        yes.clickYesButton();
    }

    @Step
    public void loginStep(String username, String password){
        headerLogOut.clickLoginButton().typeUsername(username).typePassword(password).clickSubmitForm();
        Assert.assertTrue(headerLogIn.isLogIn());
    }

    @Step
    public void logoutStep(){
        headerLogIn.clickLogoutButtonAction();
        Assert.assertTrue(headerLogOut.isLogOut());
    }

    @Step
    public void searchTracksStep(String text){
        Assert.assertTrue(headerLogIn.searchSmth(text).getTracksPage().isFindedTrack(text));
    }

    @Step
    public void searchAlbumStep(String text){
        Assert.assertTrue(headerLogIn.searchSmth(text).getAlbumsPage().isFindedAlbum(text));
    }
}
