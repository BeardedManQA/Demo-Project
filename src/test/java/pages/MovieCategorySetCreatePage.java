package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.MoviesSetCreateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.GetMoviesSetCreateModel;

@Log4j

public class MovieCategorySetCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Categories']")
    private WebElement categoriesButton;

    @FindBy(xpath = "//li[@access='viewVodCategory']")
    private WebElement vodCategoriesButton;

    @FindBy(xpath = "//button[@access='createVodCategory']")
    private WebElement addVodCategorySetButton;

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

    public MovieCategorySetCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the Movies Category Set")
    public void categorySetCreating() {
        MoviesSetCreateModel moviesSetCreateModel = GetMoviesSetCreateModel.getDefaultCategorySetFields();
        categoriesButton.click();
        log.debug("categoriesButton.click");
        vodCategoriesButton.click();
        log.debug("vodCategoriesButton.click");
        addVodCategorySetButton.click();
        log.debug("addVodCategorySetButton.click");
        setNameField.sendKeys(moviesSetCreateModel.getSetName());
        log.debug("setNameField.sendKeys");
        packageSelectDropdown.click();
        log.debug("packageSelectDropdown.click");
        packageSelect.click();
        log.debug("packageSelect.click");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the Movies Category Set creation")
    public String checkCreatedSet() {
        log.debug("creationAlert.getText");
        return creationAlert.getText();
    }

}
