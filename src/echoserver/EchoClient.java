package echoserver;
import java.net.*;
import java.io.*;

public class EchoClient { 
	 public static final int portNumber = 6013;

  public static void main(String[] args) throws IOException {
    String server;
    // Use "127.0.0.1", i.e., localhost, if no server is specified.
    if (args.length == 0) {
      server = "127.0.0.1";
    } else {
      server = args[0];
    }

    try {
      // Connect to the server
      Socket socket = new Socket(server, portNumber);
      OutputStream os = socket.getOutputStream();
      DataInputStream is = new DataInputStream(socket.getInputStream());

	    int c;
	    String responseLine;

	    while ((c = System.in.read()) != -1) {
	        os.write((byte)c);
		if (c == '\n') {
	            os.flush();
	            responseLine = is.readFully();
		    System.out.println("echo: " + responseLine);
	        }
	    }

	    os.close();
	    is.close();
	    socket.close();
	} catch (Exception e) {
	    System.err.println("Exception:  " + e);
    }
  }
}
