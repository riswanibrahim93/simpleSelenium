package simpleTest;

import factory.DriverFactory;
import keywordTest.Keyword;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AppiumTest {
    private static WebDriver driver;
    private static Keyword keyword;
    @BeforeClass
    public void setUp(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getAppiumDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        keyword = new Keyword(driver);
        System.out.println("Set Up Appium Driver");
    }
    @Test
    public void cobaTestAppium(){
        keyword.click("//android.widget.TextView[@resource-id='com.google.android.youtube:id/search_only_voice']");
        keyword.set_text("Denny Caknan","//android.widget.EditText[@resource-id='com.google.android.youtube:id/search_edit_text']");
        keyword.click("//android.widget.ListView[@resource-id='com.google.android.youtube:id/results']/android.view.ViewGroup[1]/android.widget.TextView");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        System.out.println("Tear Down");
    }
}
