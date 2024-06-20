package keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keyword {
    private static WebDriver driver;

    public Keyword(WebDriver driver){
        this.driver = driver;
    }
    public void go_to_url(String value){
        driver.get(value);
    }
    public void set_text(String value, String strXpath){
        WebElement webElement = driver.findElement(By.xpath(strXpath));
        webElement.sendKeys(value);
    }
    public void click(String strXpath){
        WebElement webElement = driver.findElement(By.xpath(strXpath));
        webElement.click();
    }
}
