import java.io.*;
import java.net.*;


public class cli {
	public static void main(String[] args) throws Exception {
		 Socket sock = new Socket("127.0.0.1", 2002);
		 BufferedReader keyRead = new BufferedReader(new
		InputStreamReader(System.in));
		 OutputStream ostream = sock.getOutputStream();
		 PrintWriter pwrite = new PrintWriter(ostream, true);
		 InputStream istream = sock.getInputStream();
		 BufferedReader receiveRead = new BufferedReader(new
		InputStreamReader(istream));
		 System.out.println("Client ready, type and press Enter key");
		 String receiveMessage, sendMessage, temp;
		 while (true) {
		 System.out.println("\nEnter operation to perform(age,date, exit)....");
		 temp = keyRead.readLine();
		 sendMessage = temp.toLowerCase();
		 pwrite.println(sendMessage);
		 if (temp.compareTo("age")== 0 ){
		 System.out.println("Enter the year you are born :");
		 sendMessage = keyRead.readLine();
		 pwrite.println(sendMessage);
		 }
		 System.out.flush();
		 if ((receiveMessage = receiveRead.readLine()) != null) {
		 System.out.println(receiveMessage);
		 }
		 }
		 }
}
