package simpleTest;

import keywordTest.Keyword;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class APITest {
    private static Keyword keyword;
    private static Map<String, String> mapBodyPost;
    private static Map<String, String> mapBodyPut;
    private static Map<String, String> mapBodyPatch;

    @BeforeClass
    public void setUp(){
        keyword = new Keyword();

        mapBodyPost = new HashMap<>();
        mapBodyPost.put("name", "Riswan");
        mapBodyPost.put("job", "IT QA Automation");

        mapBodyPut = new HashMap<>();
        mapBodyPut.put("name", "Ibrahim Riswan");
        mapBodyPut.put("job", "QA Automation");

        mapBodyPatch = new HashMap<>();
        mapBodyPatch.put("name", "Riswan Ibrahim");
    }

    @Test
    public void cobaRestAssuredAPI(){
        JSONObject jsonResponseGet = keyword.get("https://reqres.in/api/users/2");
        System.out.println(jsonResponseGet);

        JSONObject jsonResponsePost = keyword.post(new JSONObject(mapBodyPost).toString(), "https://reqres.in/api/users");
        System.out.println(jsonResponsePost);

        JSONObject jsonResponsePut = keyword.put(new JSONObject(mapBodyPut).toString(), "https://reqres.in/api/users/2");
        System.out.println(jsonResponsePut);

        JSONObject jsonResponsePatch = keyword.patch(new JSONObject(mapBodyPatch).toString(), "https://reqres.in/api/users/2");
        System.out.println(jsonResponsePatch);

        int intStatusDelete = keyword.delete("https://reqres.in/api/users/2");
        System.out.println(intStatusDelete);
    }

    @AfterClass
    public void tearDown(){
        mapBodyPost.clear();
        mapBodyPut.clear();
        mapBodyPatch.clear();
        System.out.println("Tear Down");
    }
}
