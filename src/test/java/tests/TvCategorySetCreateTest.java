package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TvCategorySetCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("TV Channels")

public class TvCategorySetCreateTest extends BaseTest {

    TvCategorySetCreatePage tvCategorySetCreatePage;
    LoginPage loginPage;

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for TV Channel category set create")
    public void tvCategorySetCreation() {
        tvCategorySetCreatePage = new TvCategorySetCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        tvCategorySetCreatePage.categorySetCreating();
        log.info("TV Channel category set is creating");
        String checkSet = tvCategorySetCreatePage.checkCreatedSet();
        Assert.assertEquals(checkSet, "!AutoCategorySet CategorySet added", "Category set is not created");
        log.info("The TV Channel category set is successfully created");
    }

}
