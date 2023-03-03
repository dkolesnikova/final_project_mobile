package mobile.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface RemoteConfig extends Config {


    String username();

    String password();

    @Key("appUrl")
    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String appUrl();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String device();

    @Key("osVersion")
    @DefaultValue("11.0")
    String osVersion();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String baseUrl();




}
