package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeletingContentPage;
import pages.LoginPage;

@Log4j

@Epic("Nora UI")
@Feature("Content creation")
@Story("Delete content")

public class DeletingContentTest extends BaseTest {

    DeletingContentPage deletingContentPage;
    LoginPage loginPage;

    @Test(priority = 10)
    @Description("Checking to removing the all created content")
    public void contentDeleteTest() {
        deletingContentPage = new DeletingContentPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorizing");
        String subCheck = deletingContentPage.subscriberDelete();
        Assert.assertEquals(subCheck, "!AutoUser Subscriber deleted");
        log.info("Subscriber is removed");
        String packCheck = deletingContentPage.packageDelete();
        Assert.assertEquals(packCheck, "!AutoPackage Package deleted");
        log.info("Package is removed");
        String channelCheck = deletingContentPage.tvChannelDelete();
        Assert.assertEquals(channelCheck, "!AutoChannel Channel deleted");
        log.info("Tv channel is removed");
        String movieCheck = deletingContentPage.movieDelete();
        Assert.assertEquals(movieCheck, "!AutoMovie VOD deleted");
        log.info("Movie is removed");
        String seriesCheck = deletingContentPage.seriesDelete();
        Assert.assertEquals(seriesCheck, "!AutoTvShow Show deleted");
        log.info("TV Series is removed");
        String tvSetCheck = deletingContentPage.tvSetDelete();
        Assert.assertEquals(tvSetCheck, "!AutoCategorySet CategorySet deleted");
        log.info("TV category set is removed");
        String movieSetCheck = deletingContentPage.movieSetDelete();
        Assert.assertEquals(movieSetCheck, "!AutoCategorySet CategorySet deleted");
        log.info("Movie category set is removed");
        String seriesSetCheck = deletingContentPage.seriesSetDelete();
        Assert.assertEquals(seriesSetCheck, "!AutoCategorySet CategorySet deleted");
        log.info("TV Series category set is removed");
    }

}
