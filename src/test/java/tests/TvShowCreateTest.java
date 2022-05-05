package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TvShowCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("TV Series")

public class TvShowCreateTest extends BaseTest {

    TvShowCreatePage tvShowCreatePage;
    LoginPage loginPage;

    @Test(priority = 9, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for TV Series content create")
    public void tvShowCreationTest() {
        tvShowCreatePage = new TvShowCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        tvShowCreatePage.tvShowCreation();
        log.info("TV Series creating");
        boolean checkCreation = tvShowCreatePage.checkTvShowCreation();
        Assert.assertTrue(checkCreation, "Tv Show is not created");
        log.info("The TV Series is successfully created");
    }

}
