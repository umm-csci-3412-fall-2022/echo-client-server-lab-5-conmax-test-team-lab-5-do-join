package echoserver;
import java.net.*;
import java.io.*;


public class EchoServer{
public static final int portNumber = 6013;

  public static void main(String[] args) {
    try {
      // Start listening on the specified port
      ServerSocket sock = new ServerSocket(portNumber);

      // Run forever, which is common for server style services
      while (true) {
        // Wait until someone connects, thereby requesting a date
        Socket client = sock.accept();
        System.out.println("Got a request!");
        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();

	int c;
      // echos what the client sends back to the client
      while ((c = is.read()) != -1) {
          os.write((byte)c);
          os.flush();
      }
      //Disconnect from the client
      client.close();
      System.out.println("Client Disconnected");

	} 
    } catch (Exception e) {
	    System.err.println("Exception:  " + e);
      }
    }
}


