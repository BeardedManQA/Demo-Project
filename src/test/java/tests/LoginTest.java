package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Authorization")
@Story("Login")

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for user login")
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        log.info("Main page opened");
        loginPage.login();
        log.info("User authorizing");
        String checkWelcome = loginPage.checkWelcomeText();
        Assert.assertEquals(checkWelcome, "Welcome to Nora Middleware", "User not authorized!");
        log.info("Authorization is successful");
    }

}
