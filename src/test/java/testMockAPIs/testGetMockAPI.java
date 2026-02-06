package testMockAPIs;

import org.testng.annotations.Test;

import APIMocking.APIMocks;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class testGetMockAPI extends BaseTest {

	@Test(enabled=true)
	public void getUserWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a get call
		APIMocks.getDummyUser();
		
		Response response = RestAssured.given()
				    .when()
					.get("/api/users/555");
					
		response.prettyPrint();
									
	}
	
	@Test
	public void getUsersWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a get call
		APIMocks.getDummyUsers();
		
		Response response = RestAssured.given()
									.when()
									.get("/api/users");
		
		response.prettyPrint();
									
	}
	
	
	
}
