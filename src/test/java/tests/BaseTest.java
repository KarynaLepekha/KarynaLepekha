package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void initBrowser(){
        WebDriverManager.chromedriver().arch64().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable_notifications", "start-maximized", "incognito");
        chromeOptions.addArguments("excludeSwitches", "enable-automation");
        driver = new ChromeDriver(chromeOptions);
    }
    @BeforeClass(dependsOnMethods = {"initBrowser"})
    public void openRztk(){
        driver.get("https://rozetka.com.ua/ua/");
        mainPage = new MainPage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
