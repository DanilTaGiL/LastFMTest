import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Test;
import ru.lastfm.REST.API;
import ru.lastfm.REST.models.search.Album;
import ru.lastfm.REST.models.search.Track;

import java.util.List;


public class RESTTests {
    public static String apiToken = API.getToken();

    private UITests UI = new UITests();
    private String sessionKey;


    @Test
    public void loginAndLogoutTest(){
        Assert.assertTrue(apiToken.length() != 0);
        tokenAuthorizationStep();
        getSessionKeyStep();
    }

    @Test
    public void searchAnySong(){
        List<Track> tracks = API.findTracks("Noize MC", 4);
        for(Track t:tracks) System.out.println(t);

        Track compare = new Track("Вселенная бесконечна?","Noize MC",
                "https://www.last.fm/music/Noize+MC/_/%D0%92%D1%81%D0%B5%D0%BB%D0%B5%D0%BD%D0%BD%D0%B0%D1%8F+%D0%B1%D0%B5%D1%81%D0%BA%D0%BE%D0%BD%D0%B5%D1%87%D0%BD%D0%B0%3F",
                "FIXME", 34049, null ,"17dc7806-1ac0-4a3a-af91-5bd1416f53d4");

        Assert.assertEquals(compare, tracks.get(0));
    }

    @Test
    public void searchAnyAlbum(){
        List<Album> albums = API.findAlbum("Noize MC", 4);
        for(Album a:albums) System.out.println(a);

        Album compare = new Album("Новый альбом", "Noize MC",
                "https://www.last.fm/music/Noize+MC/%D0%9D%D0%BE%D0%B2%D1%8B%D0%B9+%D0%B0%D0%BB%D1%8C%D0%B1%D0%BE%D0%BC",
                "0", null, "8faa0140-377f-453d-9e47-b08244ef48ba");

        Assert.assertEquals(compare, albums.get(0));
    }

    @Step
    public void getSessionKeyStep(){
        sessionKey = API.getSession(apiToken).getKey();
        Assert.assertTrue(sessionKey.length() != 0);
    }

    @Step
    public void tokenAuthorizationStep(){
        UI.startTest();
        UI.tokenAuthorize();
        UI.quit();
    }
}
