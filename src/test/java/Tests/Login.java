package Tests;

import Pages.MainPage;
import org.testng.annotations.Test;


public class Login extends BaseTest
{
    MainPage mainPage ;


    @Test(priority = 1)
    public void LoginTC()
    {
        mainPage = new MainPage(driver);
        mainPage.Login();
    }



}
