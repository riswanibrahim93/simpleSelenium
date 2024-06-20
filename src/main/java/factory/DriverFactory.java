package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.setProperty;

public class DriverFactory {

    public WebDriver getWinChromeDriver() {
        setProperty("webdriver.chrome.driver",
                "src/main/resources/chromeDriver/chromedriver126.exe");
        WebDriver driver = new ChromeDriver();
        // maximize
        driver.manage().window().maximize();
        return driver;
    }
}
