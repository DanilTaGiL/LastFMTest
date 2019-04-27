import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.lastfm.REST.API;


public class RESTTests {
    private final String DRIVER = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\projects\\Selenium\\Firefox\\geckodriver\\geckodriver.exe";

    public static String apiToken = API.getToken();
    private WebDriver driver;
    private UITests UI;



    @Before
    public void beforeTest(){

        UI = new UITests();
    }


    @Test
    public void loginAndLogoutTest(){
        authorizationStep();
        System.out.println(API.getSessionKey(apiToken));
    }

    @Step
    public void loginStep(){

    }


    @Step
    public void authorizationStep(){
        UI.startTest();
        UI.tokenAuthorize();
        UI.quit();
    }


}
