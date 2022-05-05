package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.SubscriberCreateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testdata.GetSubscriberCreateModel;

@Log4j

public class SubscriberCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Subscribers']")
    private WebElement subscribersButton;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
    private WebElement subscriberCreateButton;

    @FindBy(xpath = "//div[@id='pnetwork']/a[@aria-label='Select box select']")
    private WebElement dropdownPackage;

    @FindBy(xpath = "//span[text()='!AutoPackage']")
    private WebElement firstPackage;

    @FindBy(xpath = "//input[@id='pusername']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='pfirstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='plastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='pemail']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='pphone']")
    private WebElement numberField;

    @FindBy(xpath = "//textarea[@id='paddress']")
    private WebElement addressField;

    @FindBy(xpath = "//input[@id='pcity']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='pzipcode']")
    private WebElement zipcodeField;

    @FindBy(xpath = "//div[@id='pcountry']/a[@aria-label='Select box select']")
    private WebElement dropdownCity;

    @FindBy(xpath = "//span[text()='United States']")
    private WebElement firstCity;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']/div//span[2]")
    private WebElement alertMessage;

    public SubscriberCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the Subscriber")
    public void subscriberCreate() {
        SubscriberCreateModel subscriberCreateModel = GetSubscriberCreateModel.getDefaultSubscriberFields();
        subscribersButton.click();
        log.debug("subscribersButton.click");
        subscriberCreateButton.click();
        log.debug("subscriberCreateButton.click");
        dropdownPackage.click();
        log.debug("dropdownPackage.click");
        firstPackage.click();
        log.debug("firstPackage.click");
        userNameField.sendKeys(subscriberCreateModel.getUserName());
        log.debug("userNameField.sendKeys");
        firstNameField.sendKeys(subscriberCreateModel.getFirstName());
        log.debug("firstNameField.sendKeys");
        lastNameField.sendKeys(subscriberCreateModel.getLastName());
        log.debug("lastNameField.sendKeys");
        emailField.sendKeys(subscriberCreateModel.getEmail());
        log.debug("emailField.sendKeys");
        numberField.sendKeys(subscriberCreateModel.getNumber());
        log.debug("numberField.sendKeys");
        addressField.sendKeys(subscriberCreateModel.getAddress());
        log.debug("addressField.sendKeys");
        cityField.sendKeys(subscriberCreateModel.getCity());
        log.debug("cityField.sendKeys");
        zipcodeField.sendKeys(subscriberCreateModel.getZipcode());
        log.debug("zipcodeField.sendKeys");
        dropdownCity.click();
        log.debug("dropdownCity.click");
        firstCity.click();
        log.debug("firstCity.click");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the Subscriber creation")
    public String checkCreate() {
        log.debug("alertMessage.getText");
        return alertMessage.getText();
    }

}