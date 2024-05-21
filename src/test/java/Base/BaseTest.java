package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    String baseUrl = "https://www.automationexercise.com/";

    @BeforeMethod
    public void setUp(){
        initializeDriver();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }

    private void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    private void closeDriver() {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Teardown successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
