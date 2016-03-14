import java.io.IOException;

/**
 * Created by Paulo Pereira on 13/03/2016.
 */
public class StartServer {

	private static int port = 8080;

	public static void main(String[] args) {

		try {
			Server server = new Server(port);
			server.AcceptClient();
		} catch (IOException e) {
			System.out.println("Cant connect to server...");
			//e.printStackTrace();
		}

	}
}
