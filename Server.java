import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

public class Server {
public static void main(String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(12001);
System.out.println("HTTP Server (only POST implemented) is ready and is listening on Port Number 12001 \n");
while(true) {
Socket clientSocket = serverSocket.accept();
System.out.println(clientSocket.getInetAddress().toString() + " " + clientSocket.getPort());
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
OutputStream out = clientSocket.getOutputStream();
String temp;
while((temp=in.readLine()) != null)
System.out.println(temp);
String response = "HTTP/1.1 200 OK\n\r";
response = response + "Date: Fri, 04 May 2001 20:08:11 GMT\n\r";
response = response + "Server: Sanjits Server\n\r";
response = response + "Connection: close\n\r";
response = response + "1";
byte[] bytes = response.getBytes(); 
out.write(bytes);
out.flush();
in.close();
out.close();
}
} catch(Exception e) {
System.out.println("ERROR: " + e.getMessage());
System.exit(1);
}}}