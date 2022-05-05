package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MovieCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("Movies")

public class MovieCreateTest extends BaseTest {

    MovieCreatePage movieCreatePage;
    LoginPage loginPage;

    @Test(priority = 8, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for Movie content create")
    public void movieCreationTest() {
        movieCreatePage = new MovieCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        movieCreatePage.movieCreation();
        log.info("Movie creating");
        boolean checkMovie = movieCreatePage.movieCheck();
        Assert.assertTrue(checkMovie, "Movie is not created");
        log.info("The Movie is successfully created");
    }

}
