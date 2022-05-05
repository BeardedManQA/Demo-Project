package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.MovieCreateModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import testdata.GetMovieCreateModel;

@Log4j

public class MovieCreatePage extends BasePage {

    @FindBy(xpath = "//span[text()='Video on Demand']")
    private WebElement videoOnDemandButton;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-add']")
    private WebElement addMovieButton;

    @FindBy(xpath = "//input[@placeholder='Title']")
    private WebElement movieTitleField;

    @FindBy(xpath = "//select[@name='ageRating']")
    private WebElement ageRatingDropdown;

    @FindBy(xpath = "//input[@id='STBUrl']")
    private WebElement stbField;

    @FindBy(xpath = "//button[text()='Save ']")
    private WebElement saveButton;

    public MovieCreatePage(WebDriver driver) {
        super(driver);
    }

    @Step("Create the Movie item")
    public void movieCreation() {
        MovieCreateModel movieCreateModel = GetMovieCreateModel.getDefaultMovieFields();
        videoOnDemandButton.click();
        log.debug("videoOnDemandButton.click");
        addMovieButton.click();
        log.debug("addMovieButton.click");
        movieTitleField.sendKeys(movieCreateModel.getMovieTitle());
        log.debug("movieTitleField.sendKeys");
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='ageRating']")));
        dropdown.selectByIndex(1);
        log.debug("dropdown.selectByIndex");
        stbField.sendKeys(movieCreateModel.getStbLink());
        log.debug("stbField.sendKeys");
        saveButton.click();
        log.debug("saveButton.click");
    }

    @Step("Check for the Movie creation")
    public boolean movieCheck() {
        log.debug("addMovieButton.isDisplayed");
        return addMovieButton.isDisplayed();
    }

}
