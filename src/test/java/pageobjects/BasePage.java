package pageobjects;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Configuration.pageLoadTimeout;

public abstract class BasePage {

    public BasePage() {
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofMillis(10000)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
