package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import mobile.config.RemoteConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());


    @Override
    public WebDriver createDriver (Capabilities capabilities) {
        RemoteConfig config = ConfigFactory.create(RemoteConfig.class, System.getProperties());
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("appUrl",config.appUrl());
        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("osVersion", config.osVersion());

        mutableCapabilities.setCapability("browserstack.user", config.username());
        mutableCapabilities.setCapability("browserstack.key", config.password());

        mutableCapabilities.setCapability("project", "Mobile-tests");
        mutableCapabilities.setCapability("build", "mobile-tests-build-1");
        mutableCapabilities.setCapability("browserstack.networkLogs", "true");
        mutableCapabilities.setCapability("name", "mobile_tests");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
    public static URL getBrowserstackUrl() {
        try{
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
