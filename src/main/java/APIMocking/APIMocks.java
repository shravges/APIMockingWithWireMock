package APIMocking;

import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;


public class APIMocks {

	//create mock/stub for get call  -- get single user
	public static void getDummyUser()
	{
		//http://localhost:8089/api/users
		WireMock.stubFor(get(urlEqualTo("/api/users/555"))
					.willReturn(aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody("{\r\n"
									+ "    \"name\": \"Shilpa\",\r\n"
									+ "    \"role\": \"Test Manager\",\r\n"
									+ "    \"id\": \"555\"\r\n"
									+ "}")));
	}
	
	//create mock/stub for get call  -- get multiple users
	public static void getDummyUsers()
	{
		//http://localhost:8089/api/users   -- getting the data from json file
		WireMock.stubFor(get(urlEqualTo("/api/users"))
					.willReturn(aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBodyFile("users.json")));
	}
	
	
	//get single user with query parameter
	public static void getDummyUserWithQueryParameter()
	{
		//http://localhost:8089/api/users?name=Shilpa   -- getting the data from json file by passing query parameter
		WireMock.stubFor(get(urlPathEqualTo("/api/users"))
					.withQueryParam("name", equalTo("Shilpa"))
					.willReturn(aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBodyFile("user.json")));
	}
	
	
}
