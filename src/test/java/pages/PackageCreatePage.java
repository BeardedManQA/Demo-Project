package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.PackageCreateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.GetPackageCreateModel;

@Log4j

public class PackageCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Packages']")
    private WebElement packageButton;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
    private WebElement addPackageButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[text()='!AutoPackage']")
    private WebElement creationTextCheck;

    public PackageCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the Package item")
    public void packageCreating() {
        PackageCreateModel packageCreateModel = GetPackageCreateModel.getDefaultPackageField();
        packageButton.click();
        log.debug("packageButton.click");
        addPackageButton.click();
        log.debug("addPackageButton.click");
        nameField.sendKeys(packageCreateModel.getPackageName());
        log.debug("nameField.sendKeys");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the Package creation")
    public String checkPackageCreation() {
        log.debug("creationTextCheck.getText");
        return creationTextCheck.getText();
    }

}
