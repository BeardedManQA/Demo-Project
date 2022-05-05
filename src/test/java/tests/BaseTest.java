package tests;

import driverfactory.DriverFactory;
import driverfactory.DriverManager;
import driverfactory.DriverType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.TestListeners;

import java.net.MalformedURLException;

@Log4j

@Listeners(TestListeners.class)
public class BaseTest {

    WebDriver driver;
    DriverManager driverManager;
    DriverType driverType;

    @BeforeMethod
    @Parameters({"browser"})
    public void run(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        driverType = null;
        if(browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        } else if (browser.equals("firefox")) {
            driverType = DriverType.FIREFOX;
        } else if (browser.equals("edge")) {
            driverType = DriverType.EDGE;
        } else if (browser.equals("remote")) {
            driverType = DriverType.REMOTE;
        }
        log.debug("driver type is defined");
        driverManager = factory.getManager(driverType);
        log.debug(driverType + " driver received");
        driverManager.createDriver();
        log.debug("driver created");
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
    }

    @AfterMethod
    public void quit() {
        driverManager.quitDriver();
        log.debug("driver closed");
    }

    public WebDriver getDriver() {
        return driver;
    }

}
