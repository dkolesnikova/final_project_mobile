package mobile.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class NavBarMenuTests extends TestBase {

    @BeforeEach
    void clickMoreOptionsForOpenNavBarMenu() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Open first article", () ->
                $(id("org.wikipedia.alpha:id/page_list_item_title")).click());
        step("Tap 'More options' button for open NavBar menu", () ->
                $(accessibilityId("More options")).click());
    }

    @Tag("mobile")
    @DisplayName("Check navBar menu button: Share")
    @Test
    void checkNavBarMenusShareButtonTest() {
        step("Tap NavBar menu button: Share", () ->
                $(id("org.wikipedia.alpha:id/page_share")).click());

        $$(id("android:id/text1")).shouldHave(texts("Google", "Bluetooth", "Gmail", "Messages"));
    }

    @Tag("mobile")
    @DisplayName("Check navBar menu button: Edit History")
    @Test
    void checkNavBarMenusEditHistoryElementTest() {
        step("Tap NavBar menu button: Edit History", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());

        step("Check Edit History pages Title", () ->
                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: BrowserStack")));
    }
    @Tag("mobile")
    @DisplayName("Check navBar menu button: Revision history")
    @Test
    void checkNavBarMenusRevisionHistoryTest() {
        step("Tap NavBar menu button: Revision history", () ->
                $(id("org.wikipedia.alpha:id/page_view_edit_history")).click());

        step("Check Revision history pages Title", () ->
                $(id("org.wikipedia.alpha:id/articleTitleView")).should(text("Revision history: BrowserStack")));
    }
}
