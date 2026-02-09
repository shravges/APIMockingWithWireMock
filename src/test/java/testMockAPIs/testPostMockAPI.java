package testMockAPIs;

import org.testng.annotations.Test;

import APIMocking.APIMocks;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class testPostMockAPI extends BaseTest {

	@Test(enabled=true)
	public void getUserWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a post call
		APIMocks.createDummyUser();
		
		Response response = RestAssured.given()
					.header("Content-Type", "application/json")
					.body("{\r\n"
							+ "        \"name\": \"Naisha Sharma\",\r\n"
							+ "        \"role\": \"Director\"\r\n"
							+ "}")
	    			.when()
	    			.post("/api/users");
	    			    				
		response.then().log().all().assertThat().statusCode(201);
									
	}
	
	
	
	
	
}
