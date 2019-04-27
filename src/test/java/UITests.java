import io.qameta.allure.Step;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.lastfm.UI.Actions.HeaderLogInActions;
import ru.lastfm.UI.Actions.HeaderLogOutActions;

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
    public void endTest(){
        //logoutStep();//добавить шаг с логаутом? вроде и сам выходит..
        driver.quit();
    }

    @Test
    public void loginAndLogoutTest(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        logoutStep();
    }

    @Test
    public void searchAnySong(){
//        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        searchTracksStep("Noize MC");
    }

    @Test
    public void searchAnyAlbums(){
//        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        searchAlbumStep("Noize MC");
    }

    @Step
    public void loginStep(String username, String password){
        headerLogOut.clickLoginButton().typeUsername(username).typePassword(password).clickSubmitForm();
        Assert.assertTrue(headerLogIn.isLogIn());
    }

    @Step
    public void logoutStep(){
        //По факту, если мы залогинены, то у нас почти на всех страницах этого сайта всегда одинаковый хеддер.
        //И поэтому мы можем в любой момент выполнить этот шаг, так как с такими условиями всегда имеем
        //доступ к элементам, которые необходимы для выполнения этого шага.
        //Поэтому решил сделать отдельный класс с методами, которые будут взаимодействовать с хеддером.

        headerLogIn.clickLogoutButtonAction();
        Assert.assertTrue(headerLogOut.isLogOut()); //проверить, вышли ли мы
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
