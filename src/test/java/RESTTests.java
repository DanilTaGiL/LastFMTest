import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.lastfm.REST.API;
import ru.lastfm.REST.APIMethods;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;



public class RESTTests {
    private final String API_URL = "http://www.last.fm/api";
    private final String DRIVER = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\projects\\Selenium\\Firefox\\geckodriver\\geckodriver.exe";

    private String apiToken;
    private WebDriver driver;


    @Before
    public void beforeTest(){
//        System.setProperty(DRIVER, DRIVER_PATH);
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
    }


    @Test
    public void loginAndLogoutTest(){
        API.getToken();
    }

    @Step
    public void loginStep(){

    }

    @Step
    public void getTokenStep(){
        Assert.assertTrue(apiToken.length() != 0);
    }


}
