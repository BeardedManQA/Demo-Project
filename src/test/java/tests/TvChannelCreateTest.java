package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TvChannelCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("TV Channels")

public class TvChannelCreateTest extends BaseTest {

    TvChannelCreatePage tvChannelCreatePage;
    LoginPage loginPage;

    @Test(priority = 7, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for TV Channel content create")
    public void tvChannelCreateTest() {
        tvChannelCreatePage = new TvChannelCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        tvChannelCreatePage.tvChannelCreation();
        log.info("TV Channel creating");
        String checkTvChannel = tvChannelCreatePage.channelCheck();
        Assert.assertEquals(checkTvChannel, "!AutoChannel", "Channel is not created");
        log.info("The TV Channel is successfully created");
    }

}
