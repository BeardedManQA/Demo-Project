package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PackageCreatePage;
import utilities.RetryAnalyzer;

@Log4j

@Epic("Nora UI")
@Feature("Package creation")
@Story("Package")

public class PackageCreateTest extends BaseTest {

    PackageCreatePage packageCreatePage;
    LoginPage loginPage;

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Check for content Package create")
    public void packageCreateTest() {
        packageCreatePage = new PackageCreatePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        log.info("User authorized");
        packageCreatePage.packageCreating();
        log.info("Package creating");
        String check = packageCreatePage.checkPackageCreation();
        Assert.assertEquals(check, "!AutoPackage", "Package not created");
        log.info("The package is successfully created");
    }

}
