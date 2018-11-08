package Gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{

	public MyFrame() {
		super("Hello Button World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(500, 500);
	
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
	
		
		JPanel panel = new JPanel();
		add(panel);

	}
	
	
}
