import java.io.*;
import java.util.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

class Image
{
	public static void main(String args[])throws IOException
	{
		int choice;
		// Image file dimensions 
		int width = 640, height = 320;
		//for pixel shifting
		int x,y,a,r,g,b,p;
		//for infinite loop
		int num=0;
		Scanner sc=new Scanner(System.in);
		
		while(num<1)	// infinite loop
		{
			System.out.println("Enter 1 for copying and 2 for encrypting");
			choice=sc.nextInt();	
			switch(choice)
			{
				case 1:
					File input = new File("digital_image_processing.jpg");
      					BufferedImage image = ImageIO.read(input);

      					File compressedImageFile = new File("compress.jpg");
      					OutputStream os =new FileOutputStream(compressedImageFile);

      					Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
      					ImageWriter writer = (ImageWriter) writers.next();

      					ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      					writer.setOutput(ios);

      					ImageWriteParam param = writer.getDefaultWriteParam();
      
      					param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      					param.setCompressionQuality(1f);
      					writer.write(null, new IIOImage(image, null, null), param);
      
      					os.close();
      					ios.close();
      					writer.dispose();
				break;
				case 2:
					 

					// Create buffered image object 
					BufferedImage img = null; 
					img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 

					// file object 
					File f = null; 

					// create random values pixel by pixel 
					for (y = 0; y < height; y++) 
					{ 
						for (x = 0; x < width; x++) 
						{ 
							a = (int)(Math.random()*256); //generating 
							r = (int)(Math.random()*256); //values 
							g = (int)(Math.random()*256); //less than 
							b = (int)(Math.random()*256); //256 

							p = (a<<24) | (r<<16) | (g<<8) | b; //pixel 

							img.setRGB(x, y, p); 
						} 
					} 

					// write image 
					try
					{ 
						f = new File("/home/mamik/Desktop/test/compress.jpg"); 
						ImageIO.write(img, "jpg", f); 
					} 
					catch(IOException e) 
					{ 
						System.out.println("Error: " + e); 
					}
				break;
				default :
					System.out.println("Wrong choice");
				break;
			}
		}
	}
}
