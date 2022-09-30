package Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;



public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

    //Scenario 1

    @Given("Get list user with parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.setGetListUsers(page);
    }


    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);

    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    //Scenario 2

    @Given("Post create new user")
    public void postCreateNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewUser.json");
        reqresAPI.postcreateNewUser(json);
    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_NEW_USER);
    }

    @Then("Should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    //Scenario 3

    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidIdId(int id) {
        reqresAPI.setGetSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBeId(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }

    //Scenario 4

    @Given("Post create new invalid user")
    public void postCreateNewInvalidUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateNewUserInvalid.json");
        reqresAPI.postcreateNewInvalidUser(json);
    }

    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    //Scenario 5

    @Given("Post register new user")
    public void postRegisterNewUserEmailPassword() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegister.json");
        reqresAPI.setPostRegister(json);

    }

    @When("Send request post register new user")
    public void sendRequestPostRegisterNewUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER);
    }

    @Given("Put update user with id {int}")
    public void putUpdateUserWithIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUser.json");
        reqresAPI.setPutUpdateUser(id, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.setDeleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Should return {int} no content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Get single user with invalid id {int}")
    public void getSingleUserWithInvalidIdId(int id) {
        reqresAPI.setGetSingleInvalidId(id);

    }
    @Given("Post register invalid new user")
    public void postRegisterInvalidNewUser() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterInvalid.json");
        reqresAPI.setPostRegister(json);
    }

    @Then("Should return {int} bad request")
    public void shouldReturnBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    @Given("Post login with valid body")
    public void postLoginWithValidBody() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLogin.json");
        reqresAPI.setPostLogin(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN);
    }

    @Given("Post login with invalid body")
    public void postLoginWithInvalidBody() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginInvalid.json");
        reqresAPI.setPostLogin(json);
    }

    @Given("Post login with unregistered body")
    public void postLoginWithUnregisteredBody() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnregistered.json");
        reqresAPI.setPostLogin(json);
    }

    @Given("Put update user with invalid id {int}")
    public void putUpdateUserWithInvalidIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUserInvalid.json");
        reqresAPI.setPutUpdateUser(id, json);
    }

    @And("Response body should contain name {string}")
    public void responseBodyShouldContainName(String name) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name));
    }

    @When("Send request post login user with invalid parameter")
    public void sendRequestPostLoginUserWithInvalidParameter() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_INVALID);
    }

    @When("Send request post register new user with invalid parameter")
    public void sendRequestPostRegisterNewUserWithInvalidParameter() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_INVALID);
    }

    @Given("Get list user with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPagePage(String page) {
        reqresAPI.setGetListUsers(page);
    }

    @And("Response body page should be invalid {string}")
    public void responseBodyPageShouldBeInvalidPage(String page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @Given("Delete user with invalid parameter id {string}")
    public void deleteUserWithInvalidParameterId(String id) {
        reqresAPI.setDeleteUser(id);
    }

    @Given("Delete user with non existing id {int}")
    public void deleteUserWithNonExistingId(int id) {
        reqresAPI.setDeleteUser(id);
    }

    @Given("Put update user with unregistered id {int}")
    public void putUpdateUserWithUnregisteredIdId(int id) {
        File json = new File(ReqresAPI.JSON_FILE+"/PutUpdateUserUnregistered.json");
        reqresAPI.setPutUpdateUser(id, json);
    }

    @And("Get list user json schema validator")
    public void getListUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/GetListUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post create new user json schema validator")
    public void postCreateNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Get single new user json schema validator")
    public void getSingleNewUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/GetSingleUserValidSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post create invalid user json schema validator")
    public void postCreateInvalidUserJsonSchemaValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostCreateUserInvalidJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post register new user json validator")
    public void postRegisterNewUserJsonValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post register invalid new user json validator")
    public void postRegisterInvalidNewUserJsonValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostRegisterInvalidNewUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post login new user json validator")
    public void postLoginNewUserJsonValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginSuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post login invalid body new json validator")
    public void postLoginInvalidBodyNewJsonValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnsuccessfulJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Post login with unregistered body json validator")
    public void postLoginWithUnregisteredBodyJsonValidator() {
        File json = new File(ReqresAPI.JSON_FILE+"/PostLoginUnregisteredUserJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
