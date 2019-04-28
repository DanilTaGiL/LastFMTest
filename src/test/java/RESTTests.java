import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lastfm.REST.API;
import ru.lastfm.REST.models.search.Album;
import ru.lastfm.REST.models.search.Track;

import java.util.List;


public class RESTTests {
    public static String apiToken = API.getToken();

    private final String DRIVER = "webdriver.gecko.driver";
    private final String DRIVER_PATH = "C:\\projects\\Selenium\\Firefox\\geckodriver\\geckodriver.exe";


    private UITests UI = new UITests();
    private String sessionKey = "6VqWqnTUKk1DYkTHsOM3b1VNQzkp1AMf";



    @Before
    public void beforeTest(){
        Assert.assertTrue(apiToken.length() != 0);
    }


    @Test
    public void loginAndLogoutTest(){
        tokenAuthorizationStep(); //now we have session_key(sk)
        System.out.println("Token: " + apiToken);
        sessionKey = API.getSession(apiToken).getKey();
        System.out.println(sessionKey);

    }

    @Test
    public void searchAnySong(){
//        List<Track> list = API.findTracks("Noize MC", 4);
//        for(Track t:list) System.out.println(t);
//        Assert.assertTrue(list.get(0).getName().equals("Вселенная бесконечна?"));

//        tokenAuthorizationStep();
//        sessionKey = API.getSession(apiToken).getKey();

        Track track = new Track();
        track.setName("Вселенная бесконечна?");
        track.setArtist("Noize MC");
        loveTrackStep(track);
    }

    @Test
    public void searchAnyAlbum(){
        List<Album> album = API.findAlbum("Noize MC", 4);
        for(Album a:album) System.out.println(a);
    }

    @Test
    public void lastFMAPI(){


    }

    @Step
    public void loveTrackStep(Track track){
        API.loveTrack(track, sessionKey);
    }

    @Step
    public void tokenAuthorizationStep(){
        UI.startTest();
        UI.tokenAuthorize();
        UI.quit();
    }


}
