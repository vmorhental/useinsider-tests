package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TeamPage extends BasePage{
    private final SelenideElement seeAllJobs = $x("//a[contains(text(), 'See all')]");

    public SearchPage goToSearchPage() {
        getSeeAllJobs().shouldBe(Condition.visible).click();
        return new SearchPage();
    }

    public SelenideElement getSeeAllJobs() {
        return seeAllJobs;
    }
}
