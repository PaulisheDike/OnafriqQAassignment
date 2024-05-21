package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseTest {
    public static String email_loc = "//input[@data-qa='login-email']";
    public static String password_loc = "//input[@placeholder='Password']";
    public static String login_btn = "//button[normalize-space()='Login']";
    public static String email_address = "qat@mailinator.com";
    public static String password = "123456";

    public static void enterEmailAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_loc)));
        driver.findElement(By.xpath(email_loc)).sendKeys(email_address);
    }
    public static void enterPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(password_loc)));
        driver.findElement(By.xpath(password_loc)).sendKeys(password);
    }
    public static void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_btn)));
        driver.findElement(By.xpath(login_btn)).click();
    }

    public static void enterValidCredentials(){
        enterEmailAddress();
        enterPassword();
        clickLoginButton();
    }

}
