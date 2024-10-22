package API;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static API.Constant.EndpointConstant.CREATE_USER;
import static API.Constant.EndpointConstant.DELETE_PATCH_USER;
import static io.restassured.RestAssured.given;

public class UserClient {
        @Step("Create user")
        public static Response createUser(User user) {
            return given().log().all()
                    .header("Content-type", "application/json")
                    .body(user)
                    .when()
                    .post(CREATE_USER);
        }
        @Step("Delete user")
        public static Response deleteUser( String accessToken){
            return given().log().all()
                    .header("Authorization", accessToken)
                    .delete(DELETE_PATCH_USER);
        }
    @Step("Get access token")
    public String getAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }
}
