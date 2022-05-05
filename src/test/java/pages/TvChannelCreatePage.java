package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.TvChannelCreateModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testdata.GetTvChannelCreateModel;

@Log4j

public class TvChannelCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='TV Channels']")
    private WebElement tvChannelButton;

    @FindBy(xpath = "//a[@access='createChannel']")
    private WebElement createChannelButton;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement channelNameField;

    @FindBy(xpath = "//select[@name='ageRating']")
    private WebElement ageRatingDropdown;

    @FindBy(xpath = "//input[@id='STBUrl']")
    private WebElement stbField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//a[text()='!AutoChannel']")
    private WebElement channelList;

    public TvChannelCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the TV Channel item")
    public void tvChannelCreation() {
        TvChannelCreateModel tvChannelCreateModel = GetTvChannelCreateModel.getDefaultChannelFields();
        tvChannelButton.click();
        log.debug("tvChannelButton.click");
        createChannelButton.click();
        log.debug("createChannelButton.click");
        channelNameField.sendKeys(tvChannelCreateModel.getChannelName());
        log.debug("channelNameField.sendKeys");
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='ageRating']")));
        dropdown.selectByIndex(1);
        log.debug("dropdown.selectByIndex");
        stbField.sendKeys(tvChannelCreateModel.getStbLink());
        log.debug("stbField.sendKeys");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the TV Channel creation")
    public String channelCheck() {
        log.debug("channelList.getText");
        return channelList.getText();
    }

}
