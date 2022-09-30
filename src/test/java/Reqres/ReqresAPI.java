package Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String URL ="https://reqres.in";

    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String GET_LIST_USERS = URL+"/api/users?page={page}";
    public static String POST_CREATE_NEW_USER = URL+"/api/users";
    public static String GET_SINGLE_USER = URL+"/api/users/{data.id}";
    public static String PUT_UPDATE_USER = URL+"/api/users/{id}";
    public static String DELETE_USER = URL+"/api/users/{id}";
    public static String POST_REGISTER = URL+"/api/register";
    public static String POST_LOGIN = URL+"/api/login";
    public static String POST_LOGIN_INVALID = URL+"/api/login=/=/=";
    public static String POST_REGISTER_INVALID = URL+"/api/register=/=/=";

    @Step("Get list users")
    public void setGetListUsers(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Get list users")
    public void setGetListUsers(String page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postcreateNewUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user")
    public void setGetSingleUser(int id){
        SerenityRest.given().pathParam("data.id", id);
    }

    @Step("Post create new invalid user")
    public void postcreateNewInvalidUser(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void setPutUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void setDeleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Delete user")
    public void setDeleteUser(String id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single invalid id")
    public void setGetSingleInvalidId(int id) {
        SerenityRest.given().pathParam("data.id", id);
    }

    @Step("Post register")
    public void setPostRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login")
    public void setPostLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
}