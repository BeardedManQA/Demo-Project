package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SubscriberCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Subscriber creation")
@Story("Subscriber")

public class SubscriberCreateTest extends BaseTest {

    SubscriberCreatePage subscriberCreatePage;
    LoginPage loginPage;

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for Subscriber create")
    public void subscriberCreateTest() {
        subscriberCreatePage = new SubscriberCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        subscriberCreatePage.subscriberCreate();
        log.info("Subscriber creating");
        String checkCreation = subscriberCreatePage.checkCreate();
        Assert.assertEquals(checkCreation, "!AutoUser Subscriber added", "Subscriber is not created");
        log.info("The Subscriber is successfully created");
    }

}
