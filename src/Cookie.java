import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Cookie {

	private Image image;
	private int xPos;
	private int yPos;
	private int xSize;
	private int ySize;
	private int speed;

	public Cookie(int x, int y, int sX, int sY)
	{
		xPos = x;
		yPos = y;
		xSize = sX;
		ySize = sY;
		try
		{
			image = ImageIO.read(new File("cookie2.png"));
		}
		catch(Exception e)
		{
			System.out.println("no cookies");
		}
	}
	
	
	public Cookie(int x, int y, int sX, int sY, int s)
	{
		xPos = x;
		yPos = y;
		xSize = sX;
		ySize = sY;
		speed = s;
		try
		{
			image = ImageIO.read(new File("cookie2.png"));
		}
		catch(Exception e)
		{
			System.out.println("no cookies");
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
	
	public void setSpeed(int s)
	{
	   //add more code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	
	public void move(String direction)
	{
		if(direction.equals("LEFT"))
	      setX(getX()-getSpeed());
		
		
		
		if(direction.equals("RIGHT"))
		      setX(getX()+getSpeed());
		
		if(direction.equals("UP"))
		      setY(getY()-getSpeed());
		if(direction.equals("DOWN"))
		      setY(getY()+getSpeed());
      //add more code to complete the move method
	}

	public String toString()
	{
		return "";
	}
}