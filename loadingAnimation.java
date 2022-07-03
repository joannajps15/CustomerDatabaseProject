/*LoadingAnimation class creates frame to simulate a loading screen
 * Source: https://www.youtube.com/watch?v=JEI-fcfnFkc*/

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class loadingAnimation{
	
	//ATTRIBUTES
	private JProgressBar bar = new JProgressBar();
	private JFrame frame = new JFrame("Customer Database");
	private ImageIcon img = new ImageIcon("titleLogo.png");
	private JLabel lblTitle, lblLogo;
	
	private Font font = new Font("Elephant", Font.PLAIN, 40);
	private Color clr = new Color(216,145,239);
	
	//CONSTRUCTOR
	public loadingAnimation(){
		
		//Logo
		lblLogo = new JLabel();
		lblLogo.setBounds(135, 0, 305, 150);
		lblLogo.setIcon(img);
		lblLogo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.magenta, Color.magenta));
		
		//Title
		lblTitle = new JLabel("Loading....");
		lblTitle.setBounds(150, 200, 305, 50);
		lblTitle.setFont(font);
		lblTitle.setHorizontalAlignment(0);
		lblTitle.setForeground(Color.black);
		
		//Loading Bar
		bar.setValue(0);
		bar.setBounds(135, 300, 305, 50);
		bar.setStringPainted(true);
		bar.setForeground(clr);
		
		//Frame
		frame.add(lblLogo);
		frame.add(lblTitle);
		frame.add(bar);
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(500, 200, 600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		fill(); //fills bar to animate loading bar
		
		FileNameInput fn = new FileNameInput("File Name Request"); //creates object of class (frame) to receive user input
	}
	
	//METHODS
	
	//method to fill bar
	public void fill() {
		int counter = 0;
		
		while(counter <= 100) {
			bar.setValue(counter);
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
			}
			counter += 10;
		}
		
		frame.dispose(); //disposes of loading frame once animation is done
	
	}

}

