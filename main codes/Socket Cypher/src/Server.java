// A Java program for a Server 
import java.net.*; 
import java.io.*; 
import java.util.*;

public class Server 
{ 
	//initialize socket and input stream 
	private Socket		 socket = null; 
	private ServerSocket server = null; 
	private DataInputStream in	 = null; 

	// constructor with port 
	public Server(int port) 
	{ 
		// starts server and waits for a connection 
		try
		{ 
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			socket = server.accept(); 
			System.out.println("Client accepted"); 

			// takes input from the client socket 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = "";
			String line2 = ""; 

			// reads message from client until "Over" is sent 
			while (!line.equals("Over")) 
			{ 
				try
				{ 
					line = in.readUTF(); 
					line2=Encrypt(line);
					//System.out.println(line2);
					Write(line2);

				} 
				catch(IOException i) 
				{ 
					//System.out.println(i);
					break; 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	}
		public String Encrypt(String str)
		{
			int len,i,b;
			char ch,ch2;
			String str2="";
			len=str.length();
			for(i=0;i<len;i++)
			{
				ch=str.charAt(i);
				b=(int)ch+1;
				ch2=(char)b;
				str2+=ch2;
			}
			return str2;
		}
	void Write(String str)throws IOException//writing of file
	{
		FileWriter fw=new FileWriter("file1.txt");
		fw.write(str);
		fw.close();
	}
	
	public static void main(String args[]) 
	{ 
		Server server = new Server(5001); 
	} 
} 
