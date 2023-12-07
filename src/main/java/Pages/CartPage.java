package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CartPage extends BasePage
{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    MainPage mainPage ;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement PlaceOrderButton;
    //////////////////////////////////////////////////////////////////

    @FindBy(id = "name")
    WebElement NameFiled;

    @FindBy(id = "country")
    WebElement CountryField;

    @FindBy(id = "city")
    WebElement CityField;

    @FindBy(id = "card")
    WebElement CreditCardField;

    @FindBy(id = "month")
    WebElement MonthField;

    @FindBy(id = "year")
    WebElement YearField;

    @FindBy(xpath = "//button[normalize-space()='Purchase']")
    WebElement PurchaseBTN;

    @FindBy(xpath = "//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']")
    WebElement CancelBTN;

    //////////////////////////////////////////////////////////////////

    String Name = "Mohammed" ;
    String Country = "Egypt" ;
    String City = "Cairo" ;
    String CreditCard = "1234567891234567" ;
    String Month = "5" ;
    String Year = "2024" ;


    //////////////////////////////////////////////////////////////////
     @FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
     WebElement SuccessMSG;

     @FindBy(xpath = "//button[normalize-space()='OK']")
     WebElement OkButton;


    //////////////////////////////////////////////////////////////////
    @FindBy(id = "logout2")
    WebElement LogoutBTN;

    //////////////////////////////////////////////////////////////////

    public void PlaceOrder()
    {
        find(PlaceOrderButton,10);
        click(PlaceOrderButton);
        takeScreenshot();

        sendKeys(NameFiled,Name);
        sendKeys(CountryField,Country);
        sendKeys(CityField,City);
        sendKeys(CreditCardField,CreditCard);
        sendKeys(MonthField,Month);
        sendKeys(YearField,Year);
        takeScreenshot();

        click(PurchaseBTN);
        takeScreenshot();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(SuccessMSG));
        System.err.println("Success Text Is :"+SuccessMSG.getText());
        Assert.assertTrue(SuccessMSG.getText().contains("Thank you for your purchase!"),"Order Purchase Process is not Completed");

        click(OkButton);
        takeScreenshot();

        find(CancelBTN,10);
        click(CancelBTN);
    }

    public void Logout()
    {
        mainPage = new MainPage(driver);


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOf(LogoutBTN));

        find(LogoutBTN,10);
        click(LogoutBTN);

        Assert.assertTrue(mainPage.SignUpBTN.isDisplayed(),"User Did not Logout");
    }



}
