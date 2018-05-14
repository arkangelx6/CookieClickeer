import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class CookieScreen extends Canvas implements MouseListener, Runnable, ActionListener{

	
	private BufferedImage back;
	
	Cookie cookie, cookie2, cookieBig;
	Girl girl;
	Boy boy;
	ArrayList<Cookie> cook;
	public CookieScreen(){
		
		
		//setBackground(Color.BLUE);
		
		cookie = new Cookie(-40, 280, 250, 250);
		
		
		cookie2 = new Cookie(550, 320, 200, 200);
		
		
		cookieBig = new Cookie(190, 90,300, 300);
		
		cook = new ArrayList<Cookie>();
		for(int i = 0; i < 8; i++){
			cook.add(new Cookie((int)(Math.random()*650+20),-100, 70, 70, (int)(Math.random()*5+5)));
		}
		
		girl = new Girl(425,0, 188, 317);
		
		boy = new Boy(37, 24, 196, 284);
		
		
		this.addMouseListener(this);
		new Thread(this).start();

		setVisible(true);
	}
	static JPanel panel;
	JPanel panel2, panel3;
	static JFrame frame;
	JFrame frame2, frame3; 
	static JButton button, button2, button3;
	JButton button4, button5;
	static JTextField tf, tf2, tf3, tf4, tf5;
	static JFormattedTextField t;
	static long counter = 0L;
	static int multiplier = 1;
	static int backgroundGrandma = 0;
	static int grandmaCost = 20;
	static int armCost = 20;
	public static void main(String[] args) {
        CookieScreen cs = new CookieScreen();
        cs.buildMenuScreen();
        cs.buildInstructionScreen();
		frame = new JFrame("COOKIECLICKER");
		
		
        Canvas canvas = new CookieScreen();
        frame.setSize(700, 600);
        canvas.setPreferredSize(new Dimension(687,431));
        
        //canvas.setSize(687, 431);
        
        panel = new JPanel();
       
        button = new JButton();
        button2 = new JButton();
		button3 = new JButton();
		
        frame.add(panel);
        
       
        panel.add(canvas);
       
		//panel.add(button);
		tf = new JTextField(60);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		tf5 = new JTextField(20);
		
		
		tf.setText("Cookies: " + counter);
		tf2.setText("Worker amount: " + backgroundGrandma);
		tf3.setText("Arm amount: " + multiplier);
		button2.setText("Click the girl to hire a worker: ");
		button3.setText("Click the boy to buy an arm: " );
		tf4.setText("Worker cost: " + grandmaCost);
		tf5.setText("Arms cost: " + armCost);
		
		
		panel.add(tf);
		panel.add(button2);
		panel.add(tf2);
		panel.add(tf4);
		panel.add(button3);
		panel.add(tf3);
		panel.add(tf5);
		
		
		
		
		
		//button.setBounds(800, 0, 200, 200);
		button.setText("HI               ");
       // frame.pack();
		
       // frame.setVisible(true);
        
    }
	
	public void buildMenuScreen() {
		frame2 = new JFrame("Menu");
		 panel2 = new JPanel();
		frame2.add(panel2);
		
		button4 = new JButton();
		panel2.add(button4);
		button4.addActionListener(this);
		
		//frame2.setSize(700, 600);
		//button4.setSize(560, 480);
		
		
		/*try {
            frame2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("MenuS.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		try {
			Image image = ImageIO.read(new File("MenuS.jpg"));
		    button4.setIcon(new ImageIcon(image));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		frame2.pack();
		frame2.setVisible(true);
	}
	
	public void buildInstructionScreen() {
		frame3 = new JFrame("Instruction");
		 panel3 = new JPanel();
		frame3.add(panel3);
		frame3.setSize(700, 600);
		button5 = new JButton();
		panel3.add(button5);
		button5.addActionListener(this);
		
		//frame2.setSize(700, 600);
		//button4.setSize(560, 480);
		
		
		/*try {
            frame2.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("MenuS.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		try {
			Image image = ImageIO.read(new File("Instructions.jpg"));
		    button5.setIcon(new ImageIcon(image));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		frame3.pack();
		//frame3.setVisible(true);
	}
	
	
/*	public void buildGUI(){
		JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new CookieScreen();
        frame.setSize(700, 600);
        canvas.setPreferredSize(new Dimension(687,431));
        
        //canvas.setSize(687, 431);
        
        panel = new JPanel();
        panel2 = new JPanel();
        button = new JButton();
      //  button2 = new JButton();
		//button3 = new JButton();
        frame.add(panel);
       
        panel.add(canvas);
       
		//panel.add(button);
		tf = new JTextField(60);
		tf2 = new JTextField(20);
		tf3 = new JTextField(20);
		tf4 = new JTextField(20);
		tf5 = new JTextField(20);
		
		
		tf.setText("Cookies: " );
		tf2.setText("Grandma amount: " + backgroundGrandma);
		tf3.setText("Arm amount: " + multiplier);
		//button2.setText("Click the girl to hire her");
		//button3.setText("Buy an arm: " );
		tf4.setText("Grandmas cost: " );
		tf5.setText("Arms cost: " );
		
		
		panel.add(tf);
		//panel.add(button2);
		panel.add(tf2);
		panel.add(tf4);
		//panel.add(button3);
		panel.add(tf3);
		panel.add(tf5);
		
		
		
		
		
		//button.setBounds(800, 0, 200, 200);
		//button.setText("HI               ");
       // frame.pack();
        frame.setVisible(true);
	}*/
	
	public void update(Graphics window)
	   {
		   paint(window);
	   }
	
	
	
	
	Image image;
	int counter2 = 0;
	boolean menu = true;
	public void paint( Graphics window )
	{
		
		
		
		
		
		/*if(menu){
			panel.setVisible(false);
			
			try {
	            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("cookie2.png")))));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			
			
		}
		else{*/
			panel.setVisible(true);
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		
			
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		
		
		
		
		
		try {
			image = ImageIO.read(new File("kitchen.jpg"));
			
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		if(back==null)
			   back = (BufferedImage) image;
		
		
		Graphics graphToBack = back.createGraphics();
		

		
		cookie.draw(graphToBack);
		
		cookie2.draw(graphToBack);
		
		cookieBig.draw(graphToBack);
		girl.draw(graphToBack);
		boy.draw(graphToBack);
		//graphToBack.setColor(Color.BLACK);
		//graphToBack.fillRect(0,0,600,800);
		//graphToBack.drawImage(image, 800, 600, this);
		
		
	
		//cookieBig.setPos(190, 90);
	
		
		/*for(int i = 0; i < cook.size(); i++){
			
				cook.get(i).move("DOWN");
				
		}*/
		
		/*if(counter2 == cook.size()-2){
			counter2 = 0;
		}*/
		
		
		/*Timer timer = new Timer();
		
		
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  cook.get(counter2).move("DOWN");
				  if(counter2 == cook.size()-3){
						counter2 = 0;
					}else{
				  counter2++;
					}
				  
				  //System.out.println(counter2);
			  }
			}, 1000, 1000);
		
		for(int i = 0; i < cook.size()-2; i++){
			if(cook.get(i).getY() >= 431){
				
				//cook.remove(i);
				
					
				//cook.add(new Cookie((int)(Math.random()*650+20),-100, 70, 70, (int)(Math.random()*5+5)));
				
				
				cook.get(i).setY(-(int)(Math.random()*700));
				cook.get(i).setX((int)(Math.random()*681));
				//cook.get(i).setSpeed(-cook.get(i).getSpeed());
				cook.get(i).setSpeed((int)(cook.get(i).getSpeed()*0.3));
				
			}
		}*/
		
		
		
		
		
		
		graphToBack.drawImage(image, 0, 0, this);
		cookie.draw(graphToBack);
		
		cookie2.draw(graphToBack);
		
		cookieBig.draw(graphToBack);
		girl.draw(graphToBack);
		boy.draw(graphToBack);
		
		
		for(int i = 0; i < cook.size(); i++){
			cook.get(i).draw(graphToBack);
		}
	
		
	
	
	
	
		twoDGraph.drawImage(back, null, 0, 0);
		}
	/*}*/
	
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == button4) {
			System.out.println("button4");
			frame2.dispose(); 
			frame3.setVisible(true);
		}
		
		if(arg0.getSource() == button5) {
			System.out.println("button5");
			frame3.dispose(); 
			frame.setVisible(true);
		}
	}
	
	
	boolean click = false;
	boolean click2 = false;
	boolean click3 = false;
	boolean click4 = false;
	boolean click5 = false;
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		if((arg0.getX() >= cookieBig.getX() && arg0.getX() <= cookieBig.getX()+300) &&
				(arg0.getY() >= cookieBig.getY() && arg0.getY() <= cookieBig.getY()+300)){
		
			if(click){
				cookieBig.setPos(cookieBig.getX()+7, cookieBig.getY()+7);
				cookieBig.setXSize(300);
				cookieBig.setYSize(300);
				click = false;
			}
			else{
			cookieBig.setPos(cookieBig.getX()-7, cookieBig.getY()-7);
			cookieBig.setXSize(314);
			cookieBig.setYSize(314);
			click = true;
			}
			
			counter = counter + 1*multiplier;
			tf.setText("Cookies: " + counter);
		}
		
		
	
		
		if((arg0.getX() >= cookie.getX() && arg0.getX() <= cookie.getX()+250) &&
				(arg0.getY() >= cookie.getY() && arg0.getY() <= cookie.getY()+250)){
		
			if(click2){
				cookie.setPos(cookie.getX()+5, cookie.getY()+5);
				cookie.setXSize(250);
				cookie.setYSize(250);
				click2 = false;
			}
			else{
			cookie.setPos(cookie.getX()-5, cookie.getY()-5);
			cookie.setXSize(260);
			cookie.setYSize(260);
			click2 = true;
			}
			
			counter = counter + 1*multiplier;
			tf.setText("Cookies: " + counter);
		}
		
		if((arg0.getX() >= cookie2.getX() && arg0.getX() <= cookie2.getX()+200) &&
				(arg0.getY() >= cookie2.getY() && arg0.getY() <= cookie2.getY()+200)){
		
			if(click3){
				cookie2.setPos(cookie2.getX()+4, cookie2.getY()+4);
				cookie2.setXSize(200);
				cookie2.setYSize(200);
				click3 = false;
			}
			else{
			cookie2.setPos(cookie2.getX()-4, cookie2.getY()-4);
			cookie2.setXSize(208);
			cookie2.setYSize(208);
			click3 = true;
			}
			
			counter = counter + 1*multiplier;
			tf.setText("Cookies: " + counter);
		}
		
		
		
		
		
		if((arg0.getX() >= girl.getX() && arg0.getX() <= girl.getX()+188) &&
				(arg0.getY() >= girl.getY() && arg0.getY() <= girl.getY()+317)){
		
			if(click4){
				girl.setPos(girl.getX()+5, girl.getY()+5);
				girl.setXSize(188);
				girl.setYSize(317);
				click4 = false;
			}
			else{
			girl.setPos(girl.getX()-5, girl.getY()-5);
			girl.setXSize(193);
			girl.setYSize(322);
			click4 = true;
			}
			
			backgroundGrandma++;
			counter -= grandmaCost;
			
			Thread t = new Thread(()-> backgroundGrandmas());
			t.start();
			tf2.setText("Worker amount: " + backgroundGrandma);
			grandmaCost += backgroundGrandma*5;
			tf4.setText("Worker cost: " + grandmaCost);
			tf.setText("Cookies: " + counter);
		}
		
		
		
		if((arg0.getX() >= boy.getX() && arg0.getX() <= boy.getX()+196) &&
				(arg0.getY() >= boy.getY() && arg0.getY() <= boy.getY()+284)){
		
			if(click5){
				boy.setPos(boy.getX()+5, boy.getY()+5);
				boy.setXSize(196);
				boy.setYSize(284);
				click5 = false;
			}
			else{
			boy.setPos(boy.getX()-5, boy.getY()-5);
			boy.setXSize(201);
			boy.setYSize(289);
			click5 = true;
			}
			
			counter -= armCost;
			counterMultipier();
			tf3.setText("Arm amount: " + multiplier);
			armCost += multiplier*5;
			
			tf5.setText("Arms cost: " + armCost);
			tf.setText("Cookies: " + counter);
		}
		
		
		
		
		
		
	}
	
	
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	public void counterMultipier(){
		multiplier++;
		
	}
	public void backgroundGrandmas(){
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
			    counter += 1*backgroundGrandma;
			    tf.setText("Cookies: " + counter);
			  }
			}, 1000, 1000);
			
			
	
		
		}

	
	


}