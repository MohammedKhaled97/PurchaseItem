package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainPage extends BasePage
{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String MainPageURL = "https://www.demoblaze.com/";
    public static String InitialUserName = "Khaled1";
    public String Password = "Khaled1";
    public final static String FinalUsername =Unige_String(InitialUserName);


    @FindBy(id = "signin2")
    WebElement SignUpBTN;
//////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[1]")
    WebElement CredentialsPopUp;

    @FindBy(id = "sign-username")
    WebElement SignUpUserNameField;

    @FindBy(id = "sign-password")
    WebElement SignupPasswordField;

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    WebElement PopSignUpBTN;
////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(id = "login2")
    WebElement LoginBTN;

    @FindBy(id = "loginusername")
    WebElement LoginUpUserNameField;

    @FindBy(id = "loginpassword")
    WebElement LoginPasswordField;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement PopupLoginBTN;

    @FindBy(id = "nameofuser")
    WebElement WelcomeMsg;


    public void PressSignUP()
    {
       find(SignUpBTN,10);
       click(SignUpBTN);
       takeScreenshot();
       Assert.assertTrue(CredentialsPopUp.isDisplayed(),"Sign Up Popup is not Displayed");
    }

    public void SignUpFunction(String Password)
    {
        SignUpUserNameField.clear();
        sendKeys(SignUpUserNameField,FinalUsername);

        SignupPasswordField.clear();
        sendKeys(SignupPasswordField,Password);
        takeScreenshot();

        find(PopSignUpBTN,10);
        click(PopSignUpBTN);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        takeScreenshot();
    }

    public void Login()
    {
        click(LoginBTN);

        LoginUpUserNameField.clear();
        sendKeys(LoginUpUserNameField,FinalUsername);

        LoginPasswordField.clear();
        sendKeys(LoginPasswordField,Password);
        takeScreenshot();

        click(PopupLoginBTN);


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        find(WelcomeMsg,10);
        Assert.assertTrue(WelcomeMsg.getText().contains(FinalUsername),"User Did not Login");
    }

}
