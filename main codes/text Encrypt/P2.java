import java.util.*;
import java.io.*;
import java.lang.*;
class Show
{
	String Read()//reading of file
	{
		String str="";
		try(FileReader fr = new FileReader("file.txt"))
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
	void Write(String str)throws IOException//writing of file
	{
		FileWriter fw=new FileWriter("file.txt");
		fw.write(str);
		fw.close();
	}
	char Encrypt(char c , int n)//Encryption
	{
		int a=(int)c;
		a=a+n;
		char nc=(char)a;
		return nc;
	}
	char Decrypt(char c1 , int n1)//Decryptiion
	{
		int a1=(int)c1;
		a1=a1-n1;
		char nc1=(char)a1;
		return nc1;
	}
}
class P2
{
	public static void main(String args[])throws IOException
	{
		String choice;
		String str2="";
		String nmsg1="",nmsg2="",b1="",b2=""; 
		int len,n;
		char ch,ech=' ',dch=' ';
		Show s=new Show();
		str2=s.Read();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		n=sc.nextInt();
		len=str2.length();
		for(int i=0;i<len;i++)
		{
			ch=str2.charAt(i);
			ech=s.Encrypt(ch,n);
			b1=Integer.toBinaryString((int)ech);	
			nmsg1=nmsg1+b1;
			dch=s.Decrypt(ech,n);
			nmsg2=nmsg2+dch;
		
		}
		for(;;)
		{
			System.out.println("Enter the Cypher Text");
			choice=sc.next();
			if(choice.equals("mav1907@1996"))
			{
				s.Write(nmsg2);
				break;
			}
			else
			{
				s.Write(nmsg1);
			}

		}
	}
}
