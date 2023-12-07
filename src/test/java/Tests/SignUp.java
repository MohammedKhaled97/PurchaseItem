package Tests;

import Pages.MainPage;
import org.testng.annotations.Test;


public class SignUp extends BaseTest
{
    MainPage mainPage ;

    @Test(priority = 0)
    public void PressSignUp()
    {
        mainPage = new MainPage(driver);
        mainPage.PressSignUP();
    }

    @Test(priority = 1)
    public void signUp()
    {
        mainPage = new MainPage(driver);
        mainPage.SignUpFunction(mainPage.Password);
    }



}
