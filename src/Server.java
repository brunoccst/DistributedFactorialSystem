import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Server {

	private static double fat(int n)
	{
		double res = 1.0;
		while (n >= 2)
			res *= n--;
	
		return res;
	}

	private static int fromByteArray(byte[] bytes) {
	     return ByteBuffer.wrap(bytes).getInt();
	}

	public static void main(String[] args) throws IOException {
		DatagramSocket socket	= new DatagramSocket(0x8003);
		byte[] response		= new byte[8];
		byte[] nRecv		= new byte[4];
		while	(true) {
			try {
				// Receive the packet and parse the value.
				DatagramPacket pacIn = new DatagramPacket(nRecv, nRecv.length);
				socket.receive(pacIn);
				int n = fromByteArray(pacIn.getData());

				// Generate the requested factorial.
				double fact = fat(n);

				// Put the generated factorial in the response.
				ByteBuffer.wrap(response).putDouble(fact);

				// Get the client info.
				InetAddress endIP = pacIn.getAddress();
				int port = pacIn.getPort();

				// Configure the response and send it back to the client.
				DatagramPacket pacOut = new DatagramPacket(response, response.length, endIP, port);
				socket.send(pacOut);

			} catch	(IOException e) {
				e.printStackTrace();
				break;
			}
		}
		socket.close();
	}

}

