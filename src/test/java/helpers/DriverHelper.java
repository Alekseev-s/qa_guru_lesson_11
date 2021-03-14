package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.ConfigHelper.getRemoteDriver;
import static config.ConfigHelper.isRemoteDriver;

public class DriverHelper {
    public static void configureDriver() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browserSize = "1920x1080";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.baseUrl = "https://www.sodislab.com/ru/";

        if (isRemoteDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = getRemoteDriver();
        }
    }
}
