package in.reqres.usersinfo;

import in.reqres.model.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {
    @Test
    public void createUser(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Ramesh");
        userPojo.setJob("Tester");

        Response response = given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void createLoginSuccessful(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka");
        Response response = given()
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }




}

