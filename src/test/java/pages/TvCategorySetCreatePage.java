package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.TvCategorySetCreateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.GetTvCategorySetCreateModel;

@Log4j

public class TvCategorySetCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Categories']")
    private WebElement categoriesButton;

    @FindBy(xpath = "//li[@access='viewTvChannelCategory']")
    private WebElement tvCategoriesButton;

    @FindBy(xpath = "//button[@access='createTvChannelCategory']")
    private WebElement addTvCategorySetButton;

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

    public TvCategorySetCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the TV Channels Category Set")
    public void categorySetCreating() {
        TvCategorySetCreateModel tvCategorySetCreateModel = GetTvCategorySetCreateModel.getDefaultCategorySetFields();
        categoriesButton.click();
        log.debug("categoriesButton.click");
        tvCategoriesButton.click();
        log.debug("tvCategoriesButton.click");
        addTvCategorySetButton.click();
        log.debug("addTvCategorySetButton.click");
        setNameField.sendKeys(tvCategorySetCreateModel.getSetName());
        log.debug("setNameField.sendKeys");
        packageSelectDropdown.click();
        log.debug("packageSelectDropdown.click");
        packageSelect.click();
        log.debug("packageSelect.click");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the TV Channels Category Set creation")
    public String checkCreatedSet() {
        log.debug("creationAlert.getText");
        return creationAlert.getText();
    }

}
