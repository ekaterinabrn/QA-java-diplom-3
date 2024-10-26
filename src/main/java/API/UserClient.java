package API;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static API.Constant.EndpointConstant.*;
import static io.qameta.allure.model.Parameter.Mode.HIDDEN;
import static io.restassured.RestAssured.given;

public class UserClient {
        @Step("Create user")
        public static Response createUser(User user) {
            return given().log().all()
                    .spec(getSpec())
                   // .header("Content-type", "application/json")
                    .body(user)
                    .when()
                    .post(CREATE_USER);
        }
        @Step("Delete user")
        public static Response deleteUser(@Param(mode = HIDDEN) String accessToken){
            return given().log().all()
                    .header("Authorization", accessToken)
                    .spec(getSpec())
                    .when()
                    .delete(DELETE_PATCH_USER);
        }
    @Step("Get access token")
    public static String getAccessToken(Response response) {
        return response.then().extract().path("accessToken");
    }
    protected  static RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(URL)
                .build();
    }
}
