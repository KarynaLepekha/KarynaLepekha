package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void initBrowser(){
        WebDriverManager.chromedriver().arch64().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable_notifications", "start-maximized", "incognito");
        chromeOptions.addArguments("excludeSwitches", "enable-automation");
        driver = new ChromeDriver(chromeOptions);
    }
    @BeforeMethod(dependsOnMethods = {"initBrowser"}, alwaysRun = true)
    public void openRztk(){
        driver.get("https://rozetka.com.ua/ua/");
        mainPage = new MainPage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
