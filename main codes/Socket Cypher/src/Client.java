// A Java program for a Client 
import java.net.*; 
import java.io.*; 
import java.util.*;
public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket		 = null; 
	private DataInputStream input = null; 
	private DataOutputStream out	 = null; 

	// constructor to put ip address and port 
	public Client(String address, int port) 
	{ 
		// establish a connection 
		try
		{ 
			socket = new Socket(address, port); 
			System.out.println("Connected"); 

			// takes input from terminal 
			input = new DataInputStream(System.in); 

			// sends output to the socket 
			out = new DataOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 
		String line2="";
		Scanner sc1=new Scanner(System.in);
		// keep reading until "Over" is input 
		for(;;)
		{ 
			System.out.println("Enter Y to read file and Over to terminate");
			line2= sc1.nextLine();
			if(line2.equals("Over"))
			{
				break;
			}
			else
			{
			try
			{ 
				
				line=Read(); 
				out.writeUTF(line); 
			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
			}
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 
	String Read()//reading of file
	{
		String f;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file name");
		f=sc.nextLine();
		String str="";
		try(FileReader fr = new FileReader(f))
		{
			int c;
			while((c=fr.read())!=-1)
				str=str+(char)c;
		}
		catch(IOException e)
		{
			System.out.println("Error "+e);
		}
		return str;
	}


	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 5001); 
	} 
} 
