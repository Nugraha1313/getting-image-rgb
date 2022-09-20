package tugas1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/** @author Nugraha1313 Sep 20, 2022 10:14:51 PM **/

public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String args[])throws IOException {
//		Scanner input = new Scanner(System.in);
		System.out.println("--Welcome to Get RGB Image From Pixel Program--");
		System.out.println("======================");
		int no;
		do {
			System.out.println("| Select Option | \n1. Get RGB Each Pixel \n2, Get RGB From Input Pixel");
			System.out.println("======================");
			System.out.print("No : ");
			no = input.nextInt();
			if(no == 1)
				getRGBEachPixel();
			else if(no == 2)
				getRGBInputPixel();
			else
				System.err.println("Nomor yang dipilih tidak valid!");
		} while (no < 1 || no > 2);
		input.close();
	}
	
	/**
	 * Sebuah prosedur untuk mendapatkan nilai RGB Tiap pixel dari gambar yang diupload.
	 * @throws IOException
	 */
	public static void getRGBEachPixel() throws IOException {
		//Reading the image
//		File file= new File("C:\\Users\\aulia\\eclipse-workspace-2\\PengolahanCitra\\src\\tugas1\\gambar_cyan.jpg");
		File file= new File("C:\\Users\\aulia\\eclipse-workspace-2\\PengolahanCitra\\src\\tugas1\\rainbow.png");
		BufferedImage img = ImageIO.read(file);
		int height = img.getHeight();
		int width = img.getWidth();
		System.out.println("--Get RGB Each Pixel-- "
				+ "\nFile Path : " + file 
				+ "\nHeight : " + height + "px"
				+ "\nWidth : " + width + "px" 
				+ "\n======================");

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//Retrieving contents of a pixel
				int rgb = img.getRGB(x,y);
				//Creating a Color object from pixel value
				Color color = new Color(rgb);
				//Retrieving the R G B values
				System.out.println("x : " + x + " | y : " + y + " | Red : " + color.getRed() + " | Green : " + color.getGreen() + " | Blue : " + color.getBlue());
			}
		}
	}

	/**
	 * Prosedur untuk mendapatkan Nilai RGB dengan pixel yang diinput.
	 * @throws IOException
	 */
	public static void getRGBInputPixel() throws IOException {
//		File file= new File("C:\\Users\\aulia\\eclipse-workspace-2\\PengolahanCitra\\src\\tugas1\\gambar_cyan.jpg");
		File file= new File("C:\\Users\\aulia\\eclipse-workspace-2\\PengolahanCitra\\src\\tugas1\\rainbow.png");
		BufferedImage img = ImageIO.read(file);
		int height = img.getHeight();
		int width = img.getWidth();
		System.out.println("--Get RGB From Input Pixel-- "
				+ "\nFile Path : " + file 
				+ "\nHeight : " + height + "px"
				+ "\nWidth : " + width + "px" 
				+ "\n======================");
		int x, y;
		
		do {
			System.out.print("x : ");
			x = input.nextInt();
			if(x < 0)
				System.err.println("Pixel Minimal 0");
			else if(x > width - 1)
				System.err.println("Pixel yang dimasukkan melebihi " + (width - 1));
		} while (x < 0 || x > width - 1);

		do {
			System.out.print("y : ");
			y = input.nextInt();
			if(y < 0)
				System.err.println("Pixel Minimal 0");
			else if(y > height - 1)
				System.err.println("Pixel yang dimasukkan melebihi " + (height - 1));
		} while (y < 0 || y > height - 1);
		
		int rgb = img.getRGB(x, y);
		Color color = new Color(rgb);
		System.out.println("======================");
		System.out.println("Red : " + color.getRed() + "\nGreen : " + color.getGreen() + "\nBlue : " + color.getBlue());
	}
}
