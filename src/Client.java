import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Paulo Pereira on 13/03/2016.
 */
public class Client {

	private static Socket socket;
	private static DataInputStream in;
	private static DataOutputStream out;

	public static void main(String[] args) throws IOException {

		try {
			socket = new Socket("localhost", 8080);
			in = new DataInputStream(socket.getInputStream());
			String result = in.readUTF();
			System.out.println(result);
			out = new DataOutputStream(socket.getOutputStream());
		}
		catch (IOException e) {
			System.out.println("Cant connect to server...");
		}

		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				String str = input.next();
				String echo = "ECHO";
				out.writeUTF(str);
			}
			catch (IOException e) {
				System.out.println("Connection lost");
			}

		}
	}

}
