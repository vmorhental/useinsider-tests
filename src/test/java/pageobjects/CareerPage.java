package pageobjects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class CareerPage extends BasePage{
    private final SelenideElement locationsBlock = $("#career-our-location");
    private final SelenideElement lifeBlock = $x("//h2[contains(text(), 'Life at Insider')]/ancestor::section");
    private final SelenideElement seeAllTeamsButton = $x("//a[contains(text(), 'See all teams')]");
    private final ElementsCollection teamsLabels = $$("#career-find-our-calling h3");

    public CareerPage showAllTeams() {
        getSeeAllTeamsButton().scrollIntoView(true).shouldBe(Condition.visible).click();
        return this;
    }

    public TeamPage openTeamPage(String title) {
        int previewTeamsAmount = getTeamsLabels().size();
        showAllTeams();
        getTeamsLabels().shouldHave(CollectionCondition.sizeGreaterThan(previewTeamsAmount));
        getTeamTitleElement(title).scrollIntoView(true).shouldBe(Condition.visible).click();
        return new TeamPage();
    }

    public SelenideElement getLocationsBlock() {
        return locationsBlock;
    }

    public SelenideElement getLifeBlock() {
        return lifeBlock;
    }

    public SelenideElement getSeeAllTeamsButton() {
        return seeAllTeamsButton;
    }

    public ElementsCollection getTeamsLabels() {
        return teamsLabels;
    }

    private SelenideElement getTeamTitleElement(String title) {
        for (SelenideElement item : getTeamsLabels()) {
            if (item.getText().equals(title)) {
                return item;
            }
        }
        throw new RuntimeException("There are no team label with name " + title);
    }
}
