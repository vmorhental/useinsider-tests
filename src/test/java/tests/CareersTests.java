package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;
import pageobjects.CareerPage;
import pageobjects.MainPage;
import pageobjects.SearchPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CareersTests extends BaseTest {
    private final static String LOCATION = "Istanbul, Turkey";
    private final static String DEPARTMENT = "Quality Assurance";

    @Test
    public void careersPageIsOpenedTest() {
        CareerPage careerPage = new MainPage().goToCareerPage();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        careerPage.getLocationsBlock().shouldBe(Condition.visible);
        careerPage.getLifeBlock().shouldBe(Condition.visible);

        assertEquals(currentUrl, "https://useinsider.com/careers/", "The current page is not correct");
    }

    @Test
    public void searchQAJobsTest() {
        SearchPage searchPage = new MainPage()
                .goToCareerPage()
                .openTeamPage(DEPARTMENT)
                .goToSearchPage()
                .search(LOCATION, DEPARTMENT);

        for (SelenideElement positionItemsApplyNow : searchPage.getPositionItemsLocations()) {
            positionItemsApplyNow.hover().shouldBe(Condition.visible);
        }

        for (SelenideElement positionItemLocation : searchPage.getPositionItemsLocations()) {
            positionItemLocation.shouldHave(Condition.text(LOCATION));
        }

        for (SelenideElement positionItemDepartment : searchPage.getPositionItemsDepartments()) {
            positionItemDepartment.shouldHave(Condition.text(DEPARTMENT));
        }
    }

    @Test
    public void applyToJobTest() {
        new MainPage()
                .goToCareerPage()
                .openTeamPage(DEPARTMENT)
                .goToSearchPage()
                .search(LOCATION, DEPARTMENT)
                .applyToJob(0);

        List<String> windowHandles = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());

        String currentUrl = WebDriverRunner.getWebDriver().switchTo().window(windowHandles.get(1)).getCurrentUrl();
        String expectedUrl = "https://jobs.lever.co/useinsider/";

        assertTrue(currentUrl.contains(expectedUrl),
                String.format("The current page is not correct. Current URL is [%s], Expected URL is [%s]", currentUrl, expectedUrl));
    }
}
