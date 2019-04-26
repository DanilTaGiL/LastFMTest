import io.qameta.allure.Step;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.lastfm.UI.Actions.HeaderLogInActions;
import ru.lastfm.UI.MainPage;

import java.util.concurrent.TimeUnit;

public class UITests {
    private WebDriver driver;
    private MainPage mainPage;
    private HeaderLogInActions header;
    private final String MAIN_URL = "https://www.last.fm/";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\projects\\Selenium\\Firefox\\geckodriver\\geckodriver.exe");
    }

    @Before
    public void startTest(){
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        header = new HeaderLogInActions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(MAIN_URL);
    }

    @After
    public void endTest(){


        //logoutStep();//добавить шаг с логаутом
        driver.quit();
    }

    @Test
    public void loginAndLogoutTest(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        logoutStep();
    }

    @Test
    public void searchAnySong(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        searchTracksStep("Noize MC");
    }

    @Test
    public void searchAnyAlbums(){
        loginStep("DanilTaGiL","hS83.qdYkw8K_me");
        searchAlbumStep("Noize MC");
    }


    @Step
    public void loginStep(String username, String password){
        mainPage.clickLoginButton().typeUsername(username).typePassword(password).clickSubmitForm();
        Assert.assertTrue(header.isLogIn());
    }

    @Step
    public void logoutStep(){
        //По факту, если мы залогинены, то у нас почти на всех страницах этого сайта всегда одинаковый хеддер.
        //И поэтому мы можем в любой момент выполнить этот шаг, так как с такими условиями всегда имеем
        //доступ к элементам, которые необходимы для выполнения этого шага.
        //Поэтому решил сделать отдельный класс с методами, которые будут взаимодействовать с хеддером.

        header.clickLogoutButtonAction();
        //проверить, вышли ли мы
    }


    @Step
    public void searchTracksStep(String text){
        header.searchSmth(text).getTracksPage();
        //проверить поле с текстом на наличие там текста запроса
    }

    @Step
    public void searchAlbumStep(String text){
        header.searchSmth(text).getAlbumsPage();
    }
}
