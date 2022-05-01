package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        String checkWelcome = loginPage.checkWelcomeText();
        Assert.assertEquals(checkWelcome, "Welcome to Nora Middleware", "User not authorized!");
    }

}
