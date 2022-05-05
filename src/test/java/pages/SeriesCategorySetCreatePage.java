package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.SeriesSetCreateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.GetSeriesSetCreateModel;

@Log4j

public class SeriesCategorySetCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Categories']")
    private WebElement categoriesButton;

    @FindBy(xpath = "//li[@access='viewTvShowCategory']")
    private WebElement seriesCategoriesButton;

    @FindBy(xpath = "//button[@access='createTvShowCategory']")
    private WebElement addSeriesCategorySetButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement setNameField;

    @FindBy(xpath = "//a[@aria-label='Select box select']")
    private WebElement packageSelectDropdown;

    @FindBy(xpath = "//span[text()='!AutoPackage']")
    private WebElement packageSelect;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']/div//span[2]")
    private WebElement creationAlert;

    public SeriesCategorySetCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the TV Series Category Set")
    public void categorySetCreating() {
        SeriesSetCreateModel seriesSetCreateModel = GetSeriesSetCreateModel.getDefaultCategorySetFields();
        categoriesButton.click();
        log.debug("categoriesButton.click");
        seriesCategoriesButton.click();
        log.debug("seriesCategoriesButton.click");
        addSeriesCategorySetButton.click();
        log.debug("addSeriesCategorySetButton.click");
        setNameField.sendKeys(seriesSetCreateModel.getSetName());
        log.debug("setNameField.sendKeys");
        packageSelectDropdown.click();
        log.debug("packageSelectDropdown.click");
        packageSelect.click();
        log.debug("packageSelect.click");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the TV Series Category Set creation")
    public String checkSeriesCreatedSet() {
        log.debug("creationAlert.getText");
        return creationAlert.getText();
    }

}
