package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {
    private static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    public static String getRemoteDriver() {
        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().remoteDriverUser(),
                getWebConfig().remoteDriverPassword());
    }

    public static boolean isRemoteDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideo() {
        return getVideoStorage() != null;
    }
}
