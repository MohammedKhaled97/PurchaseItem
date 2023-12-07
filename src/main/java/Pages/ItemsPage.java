package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ItemsPage extends BasePage
{
    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add to cart")
    WebElement AddToCardBTN;

    @FindBy(id = "cartur")
    WebElement CartBTN;

    public void AddToCard()
    {
        find(AddToCardBTN,10);
        click(AddToCardBTN);
        takeScreenshot();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        takeScreenshot();
    }

    public void CartNavigation()
    {
        click(CartBTN);
        takeScreenshot();
    }


}
