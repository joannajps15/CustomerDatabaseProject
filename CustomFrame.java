/*CustomFrame class allows user to create frame using custom template with specified colours, fonts, and logo*/

import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class CustomFrame {

	//ATTRIBUTES (private and protected modifiers used accordingly)
	
	protected JFrame frame;
	protected JPanel panel;
	private ImageIcon imgLogo = new ImageIcon("titleLogo.png");
	private JLabel lblLogo;
	
	//Colours
	protected Color clrHeliotrope = new Color(216,145,239);
	protected Color clrKobi = new Color(231,159,196);
	protected Color clrPlum = new Color(221,160,221);
	
	//Fonts
	protected Font fontTitle = new Font("Elephant", Font.PLAIN, 15);
	protected Font fontNormal = new Font("Century", Font.PLAIN, 15);
	
	public CustomFrame(String txt) {
		
		frame = new JFrame(txt);
		panel = new JPanel();
		
		//Logo
		lblLogo = new JLabel();
		lblLogo.setBounds(135, 0, 305, 150);
		lblLogo.setIcon(imgLogo);
		lblLogo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.magenta, Color.magenta));
		
		//Panel
		panel.setLayout(null);
		panel.setBackground(clrHeliotrope);
		panel.add(lblLogo);
		
		//Frame Specifications
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setBounds(500, 200, 600, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

	}
	
	public void editFontTitleSize(int size) {
		fontTitle = new Font("Elephant", Font.PLAIN, size);	
	}
	
	public void editFontNormalSize(int size) {
		fontNormal = new Font("Century", Font.PLAIN, size);	
	}
	
}
