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
      InputStream is = socket.getInputStream();

	    int c;
	    String responseLine = "";

	    while ((c = System.in.read()) != -1) {
	        os.write((byte)c);
			os.flush();	
			System.out.write(is.read());	
	    }

		// while((c = is.read()) != -1){
		// 	responseLine = responseLine + (char)c;
		// }

		System.out.println(responseLine);
		responseLine = "";
	    socket.close();
		
	} catch (Exception e) {
	    System.err.println("Exception:  " + e);
    }
  }
}
