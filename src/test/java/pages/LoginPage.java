package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import model.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrl;
import testdata.GetLoginModel;

@Log4j

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='inputUsername']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='inputPassword']")
    private  WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//h2[text()=' Welcome to Nora Middleware']")
    private WebElement welcomeText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening main login page of the Nora")
    public void openLoginPage() {
        driver.get(WebUrl.BASE_URL);
        log.debug("Opening URL");
    }

    @Step("Introduction credentials for the Username and Password fields")
    public void login() {
        LoginModel loginModel = GetLoginModel.getLoginWithAllFields();
        emailField.sendKeys(loginModel.getUsername());
        log.debug("input username: " + loginModel.getUsername());
        passwordField.sendKeys(loginModel.getPassword());
        log.debug("input password: " + loginModel.getPassword());
        signInButton.click();
    }

    @Step("Verifying a successful login")
    public String checkWelcomeText() {
        return welcomeText.getText();
    }

}
//log.debug("");
