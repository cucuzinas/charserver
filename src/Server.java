import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Paulo Pereira on 13/03/2016.
 */
public class Server {

	private ServerSocket serverSocket;
	private Socket socket;
	private DataOutputStream out;
	private DataInputStream in;

	public Server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void AcceptClient() throws IOException {

		try {
			socket = serverSocket.accept();
			System.out.println("Connection from: " + socket.getInetAddress());
			System.out.println("Connection port: " + socket.getLocalPort());
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Hello");

		}catch(IOException e){
			e.printStackTrace();
		}

		while (true) {

			in = new DataInputStream(socket.getInputStream());
			String echosever = in.readUTF();
			System.out.println("Receiving from cliente > " + echosever);

		}

	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}
}
