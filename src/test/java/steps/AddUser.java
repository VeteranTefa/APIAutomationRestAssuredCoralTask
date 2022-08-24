package steps;






import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.asserts.Assertion;

//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class AddUser {
	
	@Given("user can access to url")
	public void user_can_access_to_url() {
//	    Response response = RestAssured.get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users");
//	    System.out.println(response.getStatusCode());
//	    System.out.println(response.getBody().asString());
		
		given().get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users").
		then().
		assertThat().
		statusCode(200);
		
	
	}
	
	@When("send post request to create user and status code is {int}")
	public void send_post_request_to_create_user_and_status_code_is(Integer statusCode) {
		RestAssured.baseURI="https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users";
		RestAssured.given().body("[\r\n"
				+ "    {\r\n"
				+ "        \"name\": \"Mostafa\",\r\n"
				+ "        \"username\": \"Veteran\",\r\n"
				+ "        \"profile\": {\r\n"
				+ "            \"firstName\": \"Mostafa\",\r\n"
				+ "            \"lastName\": \"Mohamed\",\r\n"
				+ "            \"orders\": [1,2,3]\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "] \r\n"
				+ "").post().then().log().all().assertThat().statusCode(statusCode);
				
		given().get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users").then().assertThat().body("id[0]",equalTo("1"));

	}
	
	@When("print id")
	public void print_id() {
//		given().get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users/"+).then().assertThat();
//		Response response =given().contentType(ContentType.JSON).log().all().
//				get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users");
//		System.out.println(response);

	}
	@When("send get request to get the created user by id")
	public void send_get_request_to_get_the_created_user_by_id() {
		   Response response = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users/"+1)
	                .then()
	                .extract().response();
		  Assert.assertEquals(200, response.getStatusCode());
		   	
	}
	@Then("Assert on First Name the same as sent in the post request")
	public void assert_on_first_name_the_same_as_sent_in_the_post_request() {
	    given().get("https://620e3da1585fbc3359db4edf.mockapi.io/api/v1/users").
	    then().assertThat().body("profile[0].'firstName'",equalTo("Estelle"));
	}

}
