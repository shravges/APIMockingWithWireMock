package testMockAPIs;

import org.testng.annotations.Test;

import APIMocking.APIMocks;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class testGetMockAPI extends BaseTest {

	@Test(enabled=false)
	public void getUserWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a get call
		APIMocks.getDummyUser();
		
		RestAssured.given()
	    			.when()
	    			.get("/api/users/555")
	    			.then()
	    			.log().all()
	    			.statusCode(200)
	    			.body("name", equalTo("Shilpa"))
	    			.and()
	    			.body("role", equalTo("Test Manager"))
	    			.and()
	    			.body("id", equalTo("555"));
									
	}
	
	@Test(enabled=false)
	public void getUsersWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a get call
		APIMocks.getDummyUsers();
		
		Response response = RestAssured.given()
									.when()
									.get("/api/users");
		
		response.prettyPrint();
		response.then().log().all().assertThat().statusCode(200);
									
	}
	
	
	@Test(enabled=true)
	public void getUserWithQueryParameter()
	{
		RestAssured.baseURI = "http://localhost:8089";
		
		//call the method to create a get call
		APIMocks.getDummyUserWithQueryParameter();
		
		Response response = RestAssured.given()
							.queryParam("name", "Shilpa")
							.when()
							.get("/api/users");
//							.then()
//							.log().all()
//							.and()
//							.statusCode(200);
		
		response.prettyPrint();
		
		
		
		
	}
	
	
	
}
