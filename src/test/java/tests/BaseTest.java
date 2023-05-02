package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.$;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://useinsider.com/");
        $("#wt-cli-accept-all-btn").scrollIntoView(true).shouldBe(Condition.visible).click();
    }

    @AfterMethod
    public void shutDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}
