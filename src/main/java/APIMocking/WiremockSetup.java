package APIMocking;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WiremockSetup {

	private static WireMockServer server;

	public static void startMockServer()
	{
		server = new WireMockServer(8089);
		WireMock.configureFor("localhost", 8089);
		server.start();
	}
	
	public static void stopMockServer()
	{
		server.stop();
	}

}
