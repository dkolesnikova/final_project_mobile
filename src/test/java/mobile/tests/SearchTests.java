package mobile.tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {
    @Tag("mobile")
    @Story("NavBar menu")
    @DisplayName("Check navBar menu button: Share")
    @Test
    void checkNavBarMenusShareButtonTest() {
        step("Tap NavBar menu button: Share", () ->
                $(id("org.wikipedia.alpha:id/page_share")).click());

        $$(id("android:id/text1")).shouldHave(texts("Nearby Share", "Android Beam",
                "Bluetooth", "Copy to clipboard", "Gmail", "Messages",
                "News Feed", "Save to Drive", "Your groups", "Your groups"));
    }
}
