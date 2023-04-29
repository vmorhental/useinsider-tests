package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import org.testng.annotations.Test;
import pageobjects.CareerPage;
import pageobjects.MainPage;

public class CareersTests extends BaseTest {
    @Test
    public void careersPageIsOpenedTest() {
        CareerPage careerPage = new MainPage().goToCareerPage();

        careerPage.getLocationsBlock().shouldBe(Condition.visible);
        careerPage.getLifeBlock().shouldBe(Condition.visible);
    }
}
