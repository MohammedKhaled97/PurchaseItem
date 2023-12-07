package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class DashboardPage extends BasePage
{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "hrefch")
    List<WebElement> Items;

    public void ClickItem()
    {
        click(Items.get(0));
        takeScreenshot();
    }


}
