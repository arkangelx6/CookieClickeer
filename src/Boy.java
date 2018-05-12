
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Boy {
	private Image image;
	private int xPos;
	private int yPos;
	private int xSize;
	private int ySize;
	

	public Boy(int x, int y, int sX, int sY)
	{
		xPos = x;
		yPos = y;
		xSize = sX;
		ySize = sY;
		try
		{
			image = ImageIO.read(new File("boy.png"));
		}
		catch(Exception e)
		{
			System.out.println("no boy");
		}
	}
	public void setPos( int x, int y)
	{
		//add more code
		xPos = x;
		yPos = y;
	}
	public void setX(int x)
	{
		//add more code
		xPos = x;
	}


	public void setY(int y)
	{
		//add more code
		yPos = y;
	}

	public int getX()
	{
		return xPos;
	}


	public int getY()
	{
		return yPos;
	}
	public int getXSize()
	{
		return xSize;
	}


	public int getYSize()
	{
		return ySize;
	}
	
	public void setXSize(int x)
	{
		xSize = x;
	}


	public void setYSize(int y)
	{
		ySize = y;
	}
	
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getXSize(),getYSize(),null);
	}
	
	

	public String toString()
	{
		return "";
	}
}
