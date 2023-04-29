package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public abstract class BaseTest {
    @BeforeTest
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://useinsider.com/");
    }

    @AfterTest
    public void shutDown() {
        Selenide.closeWebDriver();
    }
}
