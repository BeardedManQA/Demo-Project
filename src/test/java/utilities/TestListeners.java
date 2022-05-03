package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import lombok.extern.log4j.Log4j;

@Log4j

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test ".concat(result.getName()).concat(" is started"));

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test ".concat(result.getName()).concat(" is successful"));
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(webDriver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test ".concat(result.getName()).concat(" is failed"));
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(webDriver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info("Test ".concat(result.getName()).concat(" is failed by timeout"));
        Object currentClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.takeScreenshot(webDriver);
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
