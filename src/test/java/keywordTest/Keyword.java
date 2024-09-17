package keywordTest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Keyword {
    private static WebDriver driver;

    public Keyword(WebDriver driver){
        this.driver = driver;
    }
    public Keyword(){}
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
    public JSONObject get(String StrUrl){
        Response response = RestAssured.
            given().
                contentType(ContentType.JSON).
            when().
                get(StrUrl).
            then().
                log().
                all().
                extract().
                response();

        return jsonObjectResponse(response);
    }
    public JSONObject post(String strBody, String StrUrl){
        Response response = RestAssured.
            given().
                contentType(ContentType.JSON).
                body(strBody).
            when().
                post(StrUrl).
            then().
                log().
                all().
                extract().
                response();

        return jsonObjectResponse(response);
    }

    public JSONObject put(String strBody,String StrUrl){
        Response response = RestAssured.
            given().
                contentType(ContentType.JSON).
                body(strBody).
            when().
                put(StrUrl).
            then().
                log().
                all().
                extract().
                response();

        return jsonObjectResponse(response);
    }
    public JSONObject patch(String strBody,String StrUrl){
        Response response = RestAssured.
            given().
                contentType(ContentType.JSON).
            body(strBody).
                when().
                patch(StrUrl).
            then().
                log().
                all().
                extract().
                response();

        return jsonObjectResponse(response);
    }
    public int delete(String StrUrl){
        Response response = RestAssured.
            given().
                contentType(ContentType.JSON).
            when().
                delete(StrUrl).
            then().
                log().
                all().
                extract().
                response();
        return response.statusCode();
    }
    private JSONObject jsonObjectResponse(Response response){
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObjectResponse = null;
        try {
            jsonObjectResponse = (JSONObject) jsonParser.parse(response.asString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonObjectResponse;
    }
}
