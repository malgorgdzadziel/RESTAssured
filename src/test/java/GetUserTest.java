import io.restassured.RestAssured.*;
import  io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import         org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;


public class GetUserTest {

    String uri = "https://reqres.in/api/users/{i}";

    @Test
    public void getStatusCodeTest(){

        Response response = get(uri,2).andReturn();

        Assert.assertEquals("Request processed with success", response.statusCode(), 200);

        }

    @Test
    public void getFirstNameTest(){

       when().
               get(uri,2).
        then().
               body("data.first_name", Matchers.equalTo("Janet")).log().all();
    }

    @Test
    public void getBodyAsClass(){

       User user = get(uri,2).getBody().as(User.class);

       Assert.assertEquals("User data not correct", prepareExpectedUserData(), user.data);

    }

    private  User.Data prepareExpectedUserData(){


       User.Data  data = new User.Data("2","janet.weaver@reqres.in","Janet",
               "Weaver", "https://reqres.in/img/faces/2-image.jpg" );

       return data;
    }

}
