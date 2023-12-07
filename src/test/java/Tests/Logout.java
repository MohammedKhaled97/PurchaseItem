package Tests;

import Pages.CartPage;
import org.testng.annotations.Test;


public class Logout extends BaseTest
{


    CartPage cartPage ;


    @Test()
    public void Logout()
    {
        cartPage = new CartPage(driver);
        cartPage.Logout();
    }



}
