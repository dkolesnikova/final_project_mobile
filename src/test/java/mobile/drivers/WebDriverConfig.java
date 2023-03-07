package mobile.drivers;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ru.hh.config/${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.00")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://spb.hh.ru/")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemoteUrl();


}
