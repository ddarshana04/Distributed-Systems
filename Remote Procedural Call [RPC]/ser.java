import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class ser {
	 public static void main(String[] args) throws Exception {
		 ServerSocket sersock = new ServerSocket(2002);
		 System.out.println("Server ready");
		 Socket sock = sersock.accept();
		 BufferedReader keyRead = new BufferedReader(new
		InputStreamReader(System.in));
		 OutputStream ostream = sock.getOutputStream();
		 PrintWriter pwrite = new PrintWriter(ostream, true);
		 InputStream istream = sock.getInputStream();
		 BufferedReader receiveRead = new BufferedReader(new
		InputStreamReader(istream));
		 String receiveMessage, sendMessage, fun;
		 int a, b;
		 while (true) {
		 fun = receiveRead.readLine();
		 if (fun != null) {
		 System.out.println("Operation : " + fun);
		 }
		 if (fun.compareTo("age") == 0) {
		 a = Integer.parseInt(receiveRead.readLine());
		 System.out.println("year you are born " + a);
		 b = 2022 - a;
		 System.out.println("Your Age = " + b);
		 pwrite.println("Your Age = " + b);
		 }
		 if (fun.compareTo("date") == 0) {
		 DateTimeFormatter dtf =
		DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now(); 
		 System.out.println(dtf.format(now));
		 pwrite.println(dtf.format(now));
		 }
		 if (fun.compareTo("exit")== 0){
		 break;
		 }
		 System.out.flush();
		 }
		 }
		}
