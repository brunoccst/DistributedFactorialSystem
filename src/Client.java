import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Client {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("Usage: java Client <machine addr> <integer>");
			System.exit(1);
		}
		// Create the packet datagram
		DatagramSocket socket = new DatagramSocket();

		// Configure the packet.
		int n = Integer.parseInt(args[1]);
		byte[] nBytes= ByteBuffer.allocate(4).putInt(n).array();
		System.out.print(nBytes.length);
		InetAddress servIP = InetAddress.getByName(args[0]);
		DatagramPacket pacEnv = new DatagramPacket(nBytes, nBytes.length, servIP, 0x8003);

		// Send the packet.
		socket.send(pacEnv);

		// Get the response back.
		byte[] fact = new byte[8];
		DatagramPacket pacRec = new DatagramPacket(fact, fact.length);
		socket.receive(pacRec);

		// Display the response.
		System.out.println("Generated factorial for '"+args[1]+"' = " + ByteBuffer.wrap(fact).getDouble());

		// Close the socket
		socket.close();
	}

}
