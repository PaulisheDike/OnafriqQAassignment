package TestCases;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LandingPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Exercise1 extends BaseTest {

    public static String view_fancy_green_top_loc = "(//a[contains(text(),'View Product')])[5]";
    public static String view_summer_white_top_loc = "(//a[contains(text(),'View Product')])[3]";

    SoftAssert softassert = new SoftAssert();

    @Test
    public void getLabelAndPrice() throws InterruptedException {
        HomePage.clickSignup_Login_MenuItem();
        LoginPage.enterValidCredentials();
        LandingPage.getFeaturedItems();
    }

    @Test
    public void placeOrder() throws InterruptedException {
        HomePage.clickSignup_Login_MenuItem();
        LoginPage.enterValidCredentials();
//        WebElement ele1 = driver.findElement(By.xpath(LandingPage.view_fancy_green_top_loc));
        LandingPage.addProductToCart(driver.findElement(By.xpath(view_fancy_green_top_loc)));
        LandingPage.clickContinueShoppingButton();
//        WebElement ele2 = driver.findElement(By.xpath(LandingPage.view_summer_white_top_loc));
        LandingPage.addProductToCart(driver.findElement(By.xpath(view_summer_white_top_loc)));
        LandingPage.viewCart();
        LandingPage.clickCheckOutButton();
        LandingPage.addComment();
        LandingPage.clickPlaceOrderButton();
        LandingPage.enterPaymentDetails();

        String expected_confirmation_msg = "Congratulations! Your order has been confirmed!";
        softassert.assertEquals(LandingPage.isOrderSuccessful(), expected_confirmation_msg);
        softassert.assertAll();

    }

}
