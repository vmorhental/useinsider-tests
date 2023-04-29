package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private static final String MORE = "More";
    private static final String CAREERS = "Careers";
    private ElementsCollection menuItems = $$("#mega-menu-1 span");
    private ElementsCollection dropDownMenuItems = $$(".dropdown-menu h5");

    public CareerPage goToCareerPage (){
        getMenuItem(MORE).shouldBe(Condition.visible).click();
        getDropDownItem(CAREERS).shouldBe(Condition.visible).click();
        return new CareerPage();
    }
    private SelenideElement getMenuItem (String menuItem){
        for (SelenideElement item: menuItems) {
            if (item.getText().equals(menuItem)) {
                return item;
            }
        }
        throw new RuntimeException("There are no item with name " + menuItem);
    }

    private SelenideElement getDropDownItem (String dropDownMenuItem){
        for (SelenideElement item: dropDownMenuItems) {
            if (item.getText().equals(dropDownMenuItem)) {
                return item;
            }
        }
        throw new RuntimeException("There are no drop down menu item with name " + dropDownMenuItem);
    }

}


