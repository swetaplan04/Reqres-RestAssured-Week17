package in.reqres.usersinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {
    @Test
    public void getAllUserInfo(){
//        given()
//                .when()
//                .get("https://reqres.in/api/users?page=2")
//                .then()
//                .statusCode(200);

        Response response = given()
                .queryParam("page",2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleUserInfo(){
        Response response = given()
                .pathParam("id",2)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

