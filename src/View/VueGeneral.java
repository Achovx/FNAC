package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.Main;
import Controleur.User;

public class VueGeneral extends JFrame implements ActionListener
{
	private JButton btQuitter = new JButton("Quitter");
	private JPanel panelProfil = new JPanel();
	
	private static PanelAjout unPanelAjout = new PanelAjout();
	private JButton btAjouter = new JButton("Ajouter");
	
	private static PanelLister unPanelLister = new PanelLister();
	private JButton btLister = new JButton("Lister");
	
	private JButton btClient = new JButton("Client");
	private PanelClient unPanelClient = new PanelClient();
	
    public VueGeneral(User unUser)
    {
        this.setTitle("Administration de la Fnac");
        this.setBounds(100, 100, 1200, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);

        //Ajout des panels
        this.add(unPanelAjout);
        this.btAjouter.setBounds(250, 10, 100, 40);
        this.add(this.btAjouter);
        this.btAjouter.addActionListener(this);
        
        
        this.add(unPanelLister);
        this.btLister.setBounds(370, 10, 100, 40);
        this.add(this.btLister);
        this.btLister.addActionListener(this);
        
        this.btClient.setBounds(500, 10, 80, 40);
        this.add(this.btClient);
        this.btClient.addActionListener(this);
        this.add(unPanelClient);
        
        //Construction du panel profil
        this.panelProfil.setBounds(40, 40, 200, 300);
        this.panelProfil.setBackground(Color.CYAN);
        this.panelProfil.setLayout(new GridLayout(6, 1));
        this.panelProfil.add(new JLabel("Votre profil : "));
        this.panelProfil.add(new JLabel("Votre nom : " + unUser.getNom()));
        this.panelProfil.add(new JLabel("Votre prenom : " + unUser.getPrenom()));
        this.panelProfil.add(new JLabel("Votre email : " + unUser.getEmail()));
        this.panelProfil.add(new JLabel("Vous avez les droits : " + unUser.getDroit()));
        this.add(this.panelProfil);
        
        this.btQuitter.setBounds(650, 400, 100, 40);
        this.add(this.btQuitter);
        this.btQuitter.addActionListener(this);

        this.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btQuitter)
		{
			this.dispose();
			Main.setVisible(true);
		}
		else if(e.getSource() == this.btAjouter)
		{
			unPanelAjout.setVisible(true);
			unPanelLister.setVisible(false);
			unPanelClient.setVisible(false);
		}
		else if(e.getSource() == this.btLister)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(true);
			unPanelClient.setVisible(false);
		}
		else if(e.getSource() == this.btClient)
		{
			unPanelAjout.setVisible(false);
			unPanelLister.setVisible(false);
			unPanelClient.setVisible(true);
		}
	}
}