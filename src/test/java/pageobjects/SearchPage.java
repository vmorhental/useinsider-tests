package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage extends BasePage{
    private final SelenideElement searchByLocationInput = $("#select2-filter-by-location-container");
    private final ElementsCollection locationsItems = $$("#select2-filter-by-location-results li");
    private final SelenideElement searchByDepartmentInput = $("#select2-filter-by-department-container");
    private final ElementsCollection departmentsItems = $$("#select2-filter-by-department-results li");
    private final ElementsCollection positionItemsLocations = $$(".position-list-item-wrapper .position-location");
    private final ElementsCollection positionItemsDepartments = $$(".position-list-item-wrapper .position-department");
    private final ElementsCollection positionItemsApplyNow = $$(".position-list-item-wrapper a");

    public SearchPage search(String location, String department) {
        getSearchByLocationInput().shouldBe(Condition.visible).click();
        getLocationElement(location).scrollIntoView(true).shouldBe(Condition.visible).click();
        getSearchByDepartmentInput().shouldBe(Condition.visible).click();
        getDepartmentElement(department).scrollIntoView(true).shouldBe(Condition.visible).click();
        return this;
    }

    public LeverPage applyToJob(int jobIndex) {
        getPositionItemsApplyNow().get(jobIndex).hover().click();
        return new LeverPage();
    }

    public SelenideElement getSearchByLocationInput() {
        return searchByLocationInput;
    }

    public SelenideElement getSearchByDepartmentInput() {
        return searchByDepartmentInput;
    }

    public ElementsCollection getLocationsItems() {
        return locationsItems;
    }

    public ElementsCollection getDepartmentsItems() {
        return departmentsItems;
    }

    public ElementsCollection getPositionItemsLocations() {
        return positionItemsLocations;
    }

    public ElementsCollection getPositionItemsDepartments() {
        return positionItemsDepartments;
    }

    public ElementsCollection getPositionItemsApplyNow() {
        return positionItemsApplyNow;
    }

    private SelenideElement getLocationElement(String location) {
        for (SelenideElement item : getLocationsItems()) {
            if (item.getText().equals(location)) {
                return item;
            }
        }
        throw new RuntimeException("There are no location with name " + location);
    }

    private SelenideElement getDepartmentElement(String department) {
        for (SelenideElement item : getDepartmentsItems()) {
            if (item.getText().equals(department)) {
                return item;
            }
        }
        throw new RuntimeException("There are no department with name " + department);
    }
}
