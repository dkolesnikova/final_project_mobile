package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.LocalMobileDriver;
import mobile.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static mobile.helpers.Attach.getSessionId;


public class TestBase {
    public static String testType = System.getProperty("testType");

    @BeforeAll
    public static void beforeAll() {
        if (testType == null) {
            testType = "local";
        }

        switch (testType) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "local":
                Configuration.browser = LocalMobileDriver.class.getName();
                break;
        }
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void tearDown() {
        String sessionId = getSessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();

        switch (testType) {
            case "browserstack":
                Attach.video(sessionId);
                break;
        }
    }
}
