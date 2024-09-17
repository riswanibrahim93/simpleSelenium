package simpleTest;

import factory.DriverFactory;
import keywordTest.Keyword;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private static WebDriver driver;
    private static Keyword keyword;

    @BeforeClass
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getWinChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        keyword = new Keyword(driver);
        System.out.println("Set Up Chromedriver");
    }
    @Test
    public void cobaBukaBrowser(){
        keyword.go_to_url("https://www.google.com/");
        keyword.set_text("Riswan Ibrahim", "//textarea[@title='Search']");
        keyword.click("(//input[@value='Google Search'])[2]");
        keyword.click("(//div[@id='search']//h3[contains(text(),'Riswan Ibrahim')])[1]");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("Tear Down");
    }
}
