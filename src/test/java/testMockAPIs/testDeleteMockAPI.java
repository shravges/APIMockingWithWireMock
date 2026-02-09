package testMockAPIs;

import org.testng.annotations.Test;

import APIMocking.APIMocks;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class testDeleteMockAPI extends BaseTest {

	@Test(enabled=true)
	public void getUserWithAPIMOck()
	{
		RestAssured.baseURI = "http://localhost:8089";

		//call the method to create a post call
		APIMocks.deleteDummyUser();
		
		Response response = RestAssured.given()
					.pathParam("id", 1)
	    			.delete("/users/{id}");
	    			    				
		response.then().log().all().assertThat().statusCode(204);
									
	}
	
}
