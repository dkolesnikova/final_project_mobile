package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface RemoteConfig extends Config {


    String username();

    String password();

    @Key("appUrl")
    @DefaultValue("bs://e3180730e2ec0f49dd59a92134d9603e41c477c0")
    String appUrl();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("9.0")
    String osVersion();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String baseUrl();




}
