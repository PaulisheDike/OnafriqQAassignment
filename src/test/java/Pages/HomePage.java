package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BaseTest {

    public static String Signup_Login_Menu = "//a[normalize-space()='Signup / Login']";

    public static void clickSignup_Login_MenuItem(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Signup_Login_Menu)));
        driver.findElement(By.xpath(Signup_Login_Menu)).click();
    }


}
