package APIMocking;

import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;


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
	
	//create mock/stub for get call  -- get single user
	public static void getDummyUsers()
	{
		//http://localhost:8089/api/users
		WireMock.stubFor(get(urlEqualTo("/api/users"))
					.willReturn(aResponse()
							.withStatus(200)
							.withHeader("Content-Type", "application/json")
							.withBody("{\r\n"
									+ "    \"Users\": [\r\n"
									+ "        {\r\n"
									+ "        \"name\": \"Shilpa Shravge\",\r\n"
									+ "        \"role\": \"Test Manager\",\r\n"
									+ "        \"id\": \"555\"\r\n"
									+ "        },\r\n"
									+ "        {\r\n"
									+ "        \"name\": \"Shilpa Sharma\",\r\n"
									+ "        \"role\": \"Test Lead\",\r\n"
									+ "        \"id\": \"333\"\r\n"
									+ "        }\r\n"
									+ "    ]\r\n"
									+ "}")));
	}
	
}
