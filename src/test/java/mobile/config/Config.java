package mobile.config;

@org.aeonbits.owner.Config.LoadPolicy(org.aeonbits.owner.Config.LoadType.MERGE)
@org.aeonbits.owner.Config.Sources({
        "classpath:browserstack.properties"
})

public interface Config extends org.aeonbits.owner.Config {


    @Key("username")
    @DefaultValue("asdasdqwdffsfdwe_FJixVj")
    String userName();

    @Key("password")
    @DefaultValue("Lstx5wXmrYFxG5o5G46S")
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

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();

    @Key("deviceHost")
    @DefaultValue("d15b38392255")
    String deviceHost();




}
