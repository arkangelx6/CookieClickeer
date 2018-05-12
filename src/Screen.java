import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Date;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Timer;



public class Screen implements ActionListener{
	
	
	boolean g = false;
	public static void main(String[] args) {
		Screen s = new Screen();
		s.buildGUI();
		
		
		
	}
	
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton button2, button3, button4;
	JTextField tf, tf2, tf3;
	Long counter;
	int multiplier = 1;
	int backgroundGrandma = 0;
	int grandmaCost = 10;
	public void buildGUI(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800, 600);
		panel = new JPanel();
		frame.add(panel);
		button = new JButton();
		button4 = new JButton();
		panel.add(button);
		button.setSize(500, 500);
		button.setText("click");
		tf = new JTextField(20);
		tf2 = new JTextField(20);
		tf3 = new JTextField(50);
		panel.add(tf3);
		panel.add(tf2);
		tf3.setText("You have " + backgroundGrandma + " grandmas\n Grandmas cost " + grandmaCost + " cookies");
		tf2.setText("You have " + multiplier + " arms");
		button2 = new JButton();
		button2.addActionListener(this);
		button2.setText("buy one more arm");
		button3 = new JButton();
		button3.addActionListener(this);
		button3.setText("buy a grandma");
		panel.add(button3);
		 panel.add(button2); 
		panel.add(tf);
		counter = 0L;
		button.addActionListener(this);
		tf.setText("Cookies: " + counter);
		button4.addActionListener(this);
		button4.setText("destroy everything");
		panel.add(button4);
		try {
			Image image = ImageIO.read(new File("cookie.jpg"));
		    button.setIcon(new ImageIcon(image));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
	}

	
	@Override
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == button){
			counter = counter + 1*multiplier;
			System.out.println("hi");
			tf.setText("Cookies: " + counter);
			
		}
		if(arg0.getSource() == button2){
			counterMultipier();
			tf2.setText("You have " + multiplier + " arms");
		}
		
		if(arg0.getSource() == button3){
			backgroundGrandma++;
			
			counter -= grandmaCost;
			tf.setText("Cookies: " + counter);
			tf3.setText("You have " + backgroundGrandma + " grandmas\n Grandmas cost" + grandmaCost + " cookies");
				Thread t = new Thread(()-> backgroundGrandmas());
				t.start();
				grandmaCost += backgroundGrandma*5;
		}
		if(arg0.getSource() == button4){
			counter = 0L;
			multiplier = 1;
			backgroundGrandma = 0;
			grandmaCost = 10;
			tf.setText("Cookies: " + counter);
			tf3.setText("You have " + backgroundGrandma + " grandmas\n Grandmas cost " + grandmaCost + " cookies");
			tf2.setText("You have " + multiplier + " arms");
			
		}
		
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
