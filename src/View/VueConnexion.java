package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controleur.Main;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel unPanel = new JPanel();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btSeConnecter = new JButton("Se Connecter");
	
	public VueConnexion()
	{
		this.setTitle("Administrateur");
		this.setResizable(false);
		this.setBounds(200, 200, 700, 300);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.gray);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.unPanel.setBounds(300, 40, 350, 200);
		this.unPanel.setBackground(new Color(236, 177, 16));
		this.unPanel.setLayout(new GridLayout(3, 2));
		
		JLabel lbEmail = new JLabel("Email :");
		lbEmail.setForeground(Color.white);
		this.unPanel.add(lbEmail);
		this.unPanel.add(this.txtEmail);
		
		JLabel lbMdp = new JLabel("Mdp :");
		lbMdp.setForeground(Color.white);
		this.unPanel.add(lbMdp);
		this.unPanel.add(this.txtMdp);
		
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeConnecter);
		this.add(this.unPanel);
		
		//Chargement de la police des objets du panel
		Font unePolice = new Font("Arial", Font.ITALIC, 20);
		for(int i = 0; i < this.unPanel.getComponentCount(); i++)
		{
			this.unPanel.getComponent(i).setFont(unePolice);
		}
		
		//Rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//Rendre les touches fonctionnables
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		//Insertation de l'image
		ImageIcon uneImage = new ImageIcon("src/img/fnac.png");
		JLabel monImage = new JLabel(uneImage);
		monImage.setBounds(30, 40, 200, 200);
		this.add(monImage);
		
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Annuler": 
				this.txtEmail.setText("");
				this.txtMdp.setText("");
			break;
			
			case "Se Connecter":
				String email = this.txtEmail.getText();
				String mdp = new String (this.txtMdp.getPassword());
				Main.verifConnexion(email, mdp);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
			Main.verifConnexion(email, mdp);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
