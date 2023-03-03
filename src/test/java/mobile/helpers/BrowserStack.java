package mobile.helpers;

import mobile.config.RemoteConfig;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;


import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserStack {
    static RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());
    public static String getVideoUrl(String sessionId) {
        Config config = ConfigFactory.create(Config.class);
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .log().all()
                .auth().basic("asdasdqwdffsfdwe_FJixVj", "Lstx5wXmrYFxG5o5G46S")
                .when()
                .get(url)
                .then()
                .statusCode(200)
                .log().all()
                .extract().path("automation_session.video_url");
    }
}
