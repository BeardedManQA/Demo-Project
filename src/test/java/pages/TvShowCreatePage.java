package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.TvShowCreateModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testdata.GetTvShowCreateModel;

@Log4j

public class TvShowCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='VOD Series']")
    private WebElement vodSeriesButton;

    @FindBy(xpath = "//a[@access='createVodSeries']")
    private WebElement createVodSeriesButton;

    @FindBy(xpath = "//div[@data-text='Vertical Poster 540x800']//input[@class='file']")
    private WebElement verticalPoster;

    @FindBy(xpath = "//button[text()='Cut']")
    private WebElement cutButton;

    @FindBy(xpath = "//div[@data-text='Background Image 1280x720']//input[@class='file']")
    private WebElement backgroundPoster;

    @FindBy(xpath = "//img[contains(@ng-src,'background.jpeg')]")
    private WebElement loadedBackgroundPoster;

    @FindBy(xpath = "//div[@data-text='Horizontal Image 800x542']//input[@class='file']")
    private WebElement horizontalPoster;

    @FindBy(xpath = "//img[contains(@ng-src,'landscape.jpeg')]")
    private WebElement loadedHorizontalPoster;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement titleField;

    @FindBy(xpath = "//textarea[@placeholder='Description']")
    private WebElement descriptionField;

    @FindBy(xpath = "//input[@placeholder='Directors']")
    private WebElement directorsField;

    @FindBy(xpath = "//input[@name='stars']")
    private WebElement starsField;

    @FindBy(xpath = "//select[@name='ageRating']")
    private WebElement ageRatingDropdown;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public TvShowCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the TV Series item")
    public void tvShowCreation() {
        TvShowCreateModel tvShowCreateModel = GetTvShowCreateModel.getDefaultTvShowFields();
        vodSeriesButton.click();
        log.debug("vodSeriesButton.click");
        createVodSeriesButton.click();
        log.debug("createVodSeriesButton.click");
        verticalPoster.sendKeys(tvShowCreateModel.getFilePath());
        log.debug("verticalPoster.sendKeys");
        cutButton.click();
        log.debug("cutButton.click");
        WebElement dynamicElementVertical = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-class,'portraitImageUrl')]/../div/img[contains(@ng-src,'https://regress.norago.tv')]")));
        dynamicElementVertical.isDisplayed();
        log.debug("dynamicElementVertical.isDisplayed");
        backgroundPoster.sendKeys(tvShowCreateModel.getFilePath());
        log.debug("backgroundPoster.sendKeys");
        cutButton.click();
        log.debug("cutButton.click");
        WebElement dynamicElementBackground = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-class,'backgroundImageUrl')]/../div/img[contains(@ng-src,'https://regress.norago.tv')]")));
        dynamicElementBackground.isDisplayed();
        log.debug("dynamicElementBackground.isDisplayed");
        horizontalPoster.sendKeys(tvShowCreateModel.getFilePath());
        log.debug("horizontalPoster.sendKeys");
        cutButton.click();
        log.debug("cutButton.click");
        WebElement dynamicElementHorizontal = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@ng-class,'landscapeImageUrl')]/../div/img[contains(@ng-src,'https://regress.norago.tv')]")));
        dynamicElementHorizontal.isDisplayed();
        log.debug("dynamicElementHorizontal.isDisplayed");
        titleField.sendKeys(tvShowCreateModel.getTvShowTitle());
        log.debug("titleField.sendKeys");
        descriptionField.sendKeys(tvShowCreateModel.getDescription());
        log.debug("descriptionField.sendKeys");
        directorsField.sendKeys(tvShowCreateModel.getDirectors());
        log.debug("directorsField.sendKeys");
        starsField.sendKeys(tvShowCreateModel.getStars());
        log.debug("starsField.sendKeys");
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='ageRating']")));
        dropdown.selectByIndex(1);
        log.debug("dropdown.selectByIndex");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the TV Series creation")
    public boolean checkTvShowCreation() {
        log.debug("createVodSeriesButton.isDisplayed");
        return createVodSeriesButton.isDisplayed();
    }

}