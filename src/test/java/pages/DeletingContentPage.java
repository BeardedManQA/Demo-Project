package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j

public class DeletingContentPage extends BasePage {

    @FindBy(xpath = "//span[text()='Subscribers']")
    private WebElement subscribersButton;

    @FindBy(xpath = "//a[text()='!AutoUser']")
    private WebElement subscriber;

    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath = "//div[@role='alert']/div//span[2]")
    private WebElement alertMessage;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeAlertButton;

    //Package

    @FindBy(xpath = "//span[text()='Packages']")
    private WebElement packageButton;

    @FindBy(xpath = "//b[text()='!AutoPackage']/../../..//div/a[@title='STB Settings']")
    private WebElement packageStbSettingsButton;

    @FindBy(xpath = "//div[@class='row subLinks']/a[1]")
    private WebElement generalInformationButton;

    //Channel

    @FindBy(xpath = "//span[text()='TV Channels']")
    private WebElement tvChannelButton;

    @FindBy(xpath = "//a[text()='!AutoChannel']/../../td[last()]/div/button[@access='deleteChannel']")
    private WebElement deleteChannelButton;

    //Movie

    @FindBy(xpath = "//span[text()='Video on Demand']")
    private WebElement videoOnDemandButton;

    @FindBy(xpath = "//a[text()='!AutoMovie']/../../td[last()]/div/button[@access='deleteVod']")
    private WebElement deleteMovieButton;

    //Series

    @FindBy(xpath = "//span[text()='VOD Series']")
    private WebElement vodSeriesButton;

    @FindBy(xpath = "//a[text()='!AutoTvShow']/../../td[last()]/div/button[@access='deleteVodSeries']")
    private WebElement seriesDeleteButton;

    //TV set

    @FindBy(xpath = "//span[text()='Categories']")
    private WebElement categoriesButton;

    @FindBy(xpath = "//li[@access='viewTvChannelCategory']")
    private WebElement tvCategoriesButton;

    @FindBy(xpath = "//p[text()='!AutoCategorySet']/../../../div[last()]/div/a[@access='deleteTvChannelCategory']")
    private WebElement tvSetDeleteButton;

    //Movie set

    @FindBy(xpath = "//li[@access='viewVodCategory']/a")
    private WebElement vodCategoriesButton;

    @FindBy(xpath = "//p[text()='!AutoCategorySet']/../../../div[last()]/div/a[@access='deleteVodCategory']")
    private WebElement vodSetDeleteButton;

    //Series set

    @FindBy(xpath = "//li[@access='viewTvShowCategory']")
    private WebElement seriesCategoriesButton;

    @FindBy(xpath = "//p[text()='!AutoCategorySet']/../../../div[last()]/div/a[@access='deleteTvShowCategory']")
    private WebElement seriesSetDeleteButton;

    public DeletingContentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Removing the Subscriber")
    public String subscriberDelete() {
        subscribersButton.click();
        log.debug("subscribersButton.click");
        subscriber.click();
        log.debug("subscriber.click");
        removeButton.click();
        log.debug("removeButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the Package")
    public String packageDelete() {
        WebElement closeAlertSub = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        closeAlertSub.isDisplayed();
        closeAlertSub.click();
        log.debug("closeAlertSub.click");
        packageButton.click();
        log.debug("packageButton.click");
        packageStbSettingsButton.click();
        log.debug("packageStbSettingsButton.click");
        generalInformationButton.click();
        log.debug("generalInformationButton.click");
        removeButton.click();
        log.debug("removeButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the TV Channel")
    public String tvChannelDelete() {
        WebElement closeAlertPack = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        closeAlertPack.isDisplayed();
        closeAlertPack.click();
        log.debug("closeAlertPack.click");
        tvChannelButton.click();
        log.debug("tvChannelButton.click");
        deleteChannelButton.click();
        log.debug("deleteChannelButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the Movie")
    public String movieDelete() {
        WebElement closeAlertChan = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        closeAlertChan.isDisplayed();
        closeAlertChan.click();
        log.debug("closeAlertChan.click");
        videoOnDemandButton.click();
        log.debug("videoOnDemandButton.click");
        deleteMovieButton.click();
        log.debug("deleteMovieButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the TV Series")
    public String seriesDelete() {
        WebElement closeAlertMovie = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        closeAlertMovie.isDisplayed();
        closeAlertMovie.click();
        log.debug("closeAlertMovie.click");
        vodSeriesButton.click();
        log.debug("vodSeriesButton.click");
        seriesDeleteButton.click();
        log.debug("seriesDeleteButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the TV Channel set")
    public String tvSetDelete() {
        WebElement closeAlertSeries = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        closeAlertSeries.isDisplayed();
        closeAlertSeries.click();
        log.debug("closeAlertSeries.click");
        categoriesButton.click();
        log.debug("categoriesButton.click");
        tvCategoriesButton.click();
        log.debug("tvCategoriesButton.click");
        tvSetDeleteButton.click();
        log.debug("tvSetDeleteButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the Movie set")
    public String movieSetDelete() {
        vodCategoriesButton.click();
        log.debug("vodCategoriesButton.click");
        vodSetDeleteButton.click();
        log.debug("vodSetDeleteButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

    @Step("Removing the TV Series set")
    public String seriesSetDelete() {
        seriesCategoriesButton.click();
        log.debug("seriesCategoriesButton.click");
        seriesSetDeleteButton.click();
        log.debug("seriesSetDeleteButton.click");
        yesButton.click();
        log.debug("yesButton.click");
        return alertMessage.getText();
    }

}
