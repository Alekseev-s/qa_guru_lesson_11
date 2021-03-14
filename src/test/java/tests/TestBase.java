package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static config.ConfigHelper.isVideo;
import static helpers.AttachmentsHelper.*;
import static helpers.DriverHelper.configureDriver;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console log", getConsoleLog());
        if(isVideo()) {
            attachVideo(getSessionId());
        }
        closeWebDriver();
    }
}
