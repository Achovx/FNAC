package View;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel
{
	public Panel()
	{
		this.setBounds(300, 50, 800, 330);
		this.setBackground(new Color(204, 153, 0));
		this.setLayout(null);
		
		this.setVisible(false);
	}
}
