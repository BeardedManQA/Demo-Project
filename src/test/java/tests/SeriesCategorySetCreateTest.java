package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SeriesCategorySetCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("TV Series")

public class SeriesCategorySetCreateTest extends BaseTest {

    SeriesCategorySetCreatePage seriesCategorySetCreatePage;
    LoginPage loginPage;

    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for TV Series category set create")
    public void seriesSetCreation() {
        seriesCategorySetCreatePage = new SeriesCategorySetCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        seriesCategorySetCreatePage.categorySetCreating();
        log.info("TV Series category set is creating");
        String checkSet = seriesCategorySetCreatePage.checkSeriesCreatedSet();
        Assert.assertEquals(checkSet, "!AutoCategorySet CategorySet added", "Series category set is not created");
        log.info("The TV Series category set is successfully created");
    }

}
