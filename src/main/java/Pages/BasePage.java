package Pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.UUID;

public class BasePage
{
    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e)
    {
        waitForVisibility(e);
        e.click();
    }

    public void sendKeys(WebElement e, String txt)
    {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    public boolean find(final WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;

                }
            });
        } catch (Exception e) {
            return false;
        }
    }

    public void takeScreenshot() {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static String Unige_String(String Name)
    {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        String RemoveChar = uuidAsString.replaceAll("[-+.^:,]", "");
        StringBuilder sb = new StringBuilder(RemoveChar);
        sb.delete(0, 25);
        return sb + Name;
    }


}
