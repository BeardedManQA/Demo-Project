package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MovieCategorySetCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("Movies")

public class MovieCategorySetCreateTest extends BaseTest {

    MovieCategorySetCreatePage movieCategorySetCreatePage;
    LoginPage loginPage;

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for Movie category set create")
    public void movieSetCreation() {
        movieCategorySetCreatePage = new MovieCategorySetCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        movieCategorySetCreatePage.categorySetCreating();
        log.info("Movie category set is creating");
        String checkSet = movieCategorySetCreatePage.checkCreatedSet();
        Assert.assertEquals(checkSet, "!AutoCategorySet CategorySet added", "Movies category set is not created");
        log.info("The Movie category set is successfully created");
    }

}
