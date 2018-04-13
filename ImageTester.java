import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageTester {
	public static void main(String[] args) {

		//Create New Image Utility.		
		ImageUtils utils = new ImageUtils();
		
		//Load Image
		Color[][] orig = utils.loadImage("src/LennaCV.png");
		
		//Add Original Image
		utils.addImage(orig,  "Original Image");
		
		//Process the Image
		
		Color[][] magic=magic(orig);
		utils.addImage(magic, "SpotLight");
		Color[][] inv=inv(orig);
		utils.addImage(inv, "Inverse");
		Color[][] Eightbit=Eightbit(orig);
		utils.addImage(Eightbit, "Eight Bit Color");
		Color[][] BW=BW(orig);
		utils.addImage(BW, "News Paper");
		Color[][] en=enhance(orig);
		utils.addImage(en, "Main Color Enhance");
		Color[][] ge=greeneye(orig);
		utils.addImage(ge, "Green Eyes");
	
		
		//Display images
		utils.display();
		
		
		
	}
	public static Color[][] halfred(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				if(i<tmp.length/2) {
					//Red, Green, Blue
					tmp[i][j] = new Color(0,0,0);
					Color pixel = img[i][j];
					int r = pixel.getRed();
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					tmp[i][j]=new Color(r,0,0);
				}
			}
		}
		return tmp;
	}	
	
	public static Color[][] halfblue(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				if(i<tmp.length/2) {
					//Red, Green, Blue
					tmp[i][j] = new Color(0,0,0);
					Color pixel = img[i][j];
					int r = pixel.getRed();
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					tmp[i][j]=new Color(0,0,b);
				}
			}
		}
		return tmp;
		
	}
	
	public static Color[][] halfgreen(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				if(i<tmp.length/2) {
					//Red, Green, Blue
					tmp[i][j] = new Color(0,0,0);
					Color pixel = img[i][j];
					int r = pixel.getRed();
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					tmp[i][j]=new Color(0,g,0);
				}
			}
		}
		return tmp;
		
	}
	
	public static Color[][] magic(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				
					if(i > (j*3)){
						Color pixel = img[i][j];
						tmp[i][j] = new Color(0,0,0);
					}	
					if(j > (i*3)){
						Color pixel = img[i][j];
						tmp[i][j] = new Color(0,0,0);
					}	
					
			}
		}
		
		return tmp;
	}
	
	public static Color[][] inv(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				int newr = 0;
				int newg = 0;
				int newb = 0;
				
				if(r<(256/2)) {
					 newr=r+(256/2);
				 }
				if(r>(256/2)) {
					 newr=r-(256/2);
				}
				if(r==256) {}
				if(r==(256/2)) {newr=r;}
				if(g<(256/2)) {
					 newg=g+(256/2);
				 }
				if(g>(256/2)) {
					 newg=g-(256/2);
				}
				if(g==256) {}
				if(g==(256/2)) {newg=g;}
				if(b<(256/2)) {
					 newb=b+(256/2);
				 }
				if(b>(256/2)) {
					 newb=b-(256/2);
				}
				if(b==256) {}
				if(b==(256/2)) {newb=b;}
				
				tmp[i][j]=new Color(newr , newg, newb);
				
			}
		}
		
		return tmp;
	}
	
	public static Color[][] Eightbit(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
					
					Color pixel = img[i][j];
					int r = pixel.getRed();
					int g = pixel.getGreen();
					int b = pixel.getBlue();
					int newr=0;
					int newg=0;
					int newb=0;
					//r
					if (0 <= r && r < 32) {
						newr=16;
					}
					else if(32 <= r && r < 64){
						newr= 48;
					}
					else if(64 <= r && r < 96){
						newr= 80;
					}
					else if(96 <= r && r < 128){
						newr= 112;
					}
					else if(128 <= r && r < 160){
						newr= 144;
					}
					else if(160 <= r && r < 192){
						newr= 176;
					}
					else if(192 <= r && r < 224){
						newr= 208;
					}
					else if(224 <= r && r <= 256){
						newr= 240;
					}
					//g
					if (0 <= g && g < 32) {
						newg=16;
					}
					else if(32 <= g && g < 64){
						newg= 48;
					}
					else if(64 <= g && g < 96){
						newg= 80;
					}
					else if(96 <= g && g < 128){
						newg= 112;
					}
					else if(128 <= g && g < 160){
						newg= 144;
					}
					else if(160 <= g && g < 192){
						newg= 176;
					}
					else if(192 <= g && g < 224){
						newg= 208;
					}
					else if(224 <= g && g <= 256){
						newg= 240;
					}
					//b
					if (0 <= b && b < 32) {
						newb=16;
					}
					else if(32 >= b && b < 64){
						newb= 48;
					}
					else if(64 >= b && b < 96){
						newb= 80;
					}
					else if(96 <= b && b < 128){
						newb= 112;
					}
					else if(128 <= b && b < 160){
						newb= 144;
					}
					else if(160 <= b && b < 192){
						newb= 176;
					}
					else if(192 <= b && b < 224){
						newb= 208;
					}
					else if(224 <= b && b <= 256){
						newb= 240;
					}
					tmp[i][j]=new Color(newr,newg,newb);				
			}
		}
		return tmp;
	}
	
	public static Color[][] BW(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				int newr=0;
				int newg=0;
				int newb=0;
				
				int a=(r+b+g)/3;
				tmp[i][j]= new Color(a-32,a-32,a-32);
			}
		}
		return tmp;
	}
	
	public static Color[][] enhance(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for( int j=0; j < tmp[i].length; j++) {
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				int newr=0;
				int newg=0;
				int newb=0;
				
				if(r>g && r>b) {
					if(r<256-64) {
						newr=r+64;
						newg=g;
						newb=b;
					}
					else {
						newr=r;
						newg=g;
						newb=b;
					}
				}
				else if(g>r && g>b) {
					if(g<256-64) {
						newg=g+64;	
						newr=r;
						newb=b;
					}
					else {
						newg=g;
						newr=r;
						newb=b;
					}
				}
				else if(b>r && b>g) {
					if(b<256-64) {
						newb=b+64;
						newr=r;
						newg=g;
					}
					else {
						newb=b;
						newr=r;
						newg=g;
					}
				}
				tmp[i][j]= new Color(newr,newg,newb);
			}
		}
		return tmp;
	}
	
	public static Color[][] greeneye(Color[][] img){
		Color[][] tmp= ImageUtils.cloneArray(img);
		for( int i=0; i < tmp.length; i++) {
			for(int j=0; j<tmp.length; j++) {
				//Red, Green, Blue
				tmp[i][j] = new Color(0,0,0);
				Color pixel = img[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				if( !(r*g*b >= 15119000) && !(r*g*b <= 200000) && b<150 && 259<= i && i <= 275 && 264<= j && j <= 271) {
					tmp[i][j] = new Color(64,108,46);
					//System.out.println(i + " " + j + "(" + r + "," + g + "," + b +")");
				}
				else if(323<= i && i <= 333 && 262<= j && j <= 272 && !(r*g*b >= 15119000) && !(r*g*b <= 200000) && b<150 ){
					tmp[i][j] = new Color(44,64,26);
				}
				else {
					tmp[i][j] = new Color(r,g,b);
				}
			}
		}
		return tmp;
	}
		
}
			
