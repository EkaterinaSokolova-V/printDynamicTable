package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriver driver;
    protected WebDriver getDriver() {
        return driver;
    }

    protected void navigateWeb() {
        driver.get("https://demoqa.com/webtables");
//        driver.get("https://www.google.com/finance/?hl=en");
    }

    @BeforeMethod
    protected void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateWeb();
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected void afterTest() {
        getDriver().quit();
    }

}
