package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.setProperty;

public class DriverFactory {

    public WebDriver getWinChromeDriver() {
        setProperty("webdriver.chrome.driver",
                "src/main/resources/chromeDriver/chromedriver128.exe");
        WebDriver driver = new ChromeDriver();
        // maximize
        driver.manage().window().maximize();
        return driver;
    }
    public AppiumDriver getAppiumDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        AppiumDriver driver;
        try {
            driver=  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }
}
