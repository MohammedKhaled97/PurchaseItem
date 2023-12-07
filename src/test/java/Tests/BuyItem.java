package Tests;

import Pages.CartPage;
import Pages.DashboardPage;
import Pages.ItemsPage;
import Pages.MainPage;
import org.testng.annotations.Test;


public class BuyItem extends BaseTest
{
    DashboardPage  dashboardPage ;

    CartPage cartPage ;
    ItemsPage itemsPage;


    @Test(priority = 1)
    public void ItemNavigate()
    {
        dashboardPage = new DashboardPage(driver);
        dashboardPage.ClickItem();
    }

    @Test(priority = 2)
    public void AddItemToCard()
    {
        itemsPage = new ItemsPage(driver);
        itemsPage.AddToCard();
    }

    @Test(priority = 3)
    public void NavigateCard()
    {
        itemsPage = new ItemsPage(driver);
        itemsPage.CartNavigation();
    }

    @Test(priority = 4)
    public void PurchaseItem()
    {
        cartPage = new CartPage(driver);
        cartPage.PlaceOrder();
    }



}
