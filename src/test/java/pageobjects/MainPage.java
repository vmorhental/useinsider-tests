package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage{
    private static final String MORE = "More";
    private static final String CAREERS = "Careers";
    private final ElementsCollection menuItems = $$("#mega-menu-1 span");
    private final ElementsCollection dropDownMenuItems = $$(".dropdown-menu h5");

    public CareerPage goToCareerPage() {
        getMenuItem().shouldBe(Condition.visible).click();
        getDropDownItem().shouldBe(Condition.visible).click();
        return new CareerPage();
    }

    public ElementsCollection getMenuItems() {
        return menuItems;
    }

    public ElementsCollection getDropDownMenuItems() {
        return dropDownMenuItems;
    }

    private SelenideElement getMenuItem() {
        for (SelenideElement item : getMenuItems()) {
            if (item.getText().equals(MainPage.MORE)) {
                return item;
            }
        }
        throw new RuntimeException("There are no item with name " + MainPage.MORE);
    }

    private SelenideElement getDropDownItem() {
        for (SelenideElement item : getDropDownMenuItems()) {
            if (item.getText().equals(MainPage.CAREERS)) {
                return item;
            }
        }
        throw new RuntimeException("There are no drop down menu item with name " + MainPage.CAREERS);
    }

}


