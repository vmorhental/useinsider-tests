package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CareerPage {
    private SelenideElement locationsBlock = $("#career-our-location");
    private SelenideElement lifeBlock = $x("//h2[contains(text(), 'Life at Insider')]/ancestor::section");

    public SelenideElement getLocationsBlock() {
        return locationsBlock;
    }

    public SelenideElement getLifeBlock() {
        return lifeBlock;
    }
}
