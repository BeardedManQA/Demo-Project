package pages;

import model.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import staticdata.WebUrl;
import testdata.GetLoginModel;

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

    public void openLoginPage() {
        driver.get(WebUrl.BASE_URL);
    }

    public void login() {
        LoginModel loginModel = GetLoginModel.getLoginWithAllFields();
        emailField.sendKeys(loginModel.getUsername());
        passwordField.sendKeys(loginModel.getPassword());
        signInButton.click();
    }

    public String checkWelcomeText() {
        return welcomeText.getText();
    }

}
