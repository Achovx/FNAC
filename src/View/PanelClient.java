package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Client;
import Controleur.Tableau;
import Modele.Modele;



public class PanelClient extends Panel implements ActionListener
{
	private JTable uneTable;
	private Tableau unTableau;
	
	private JPanel unPanelAjout = new JPanel();
	private JTextField txtIdClient = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtNom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtTel = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btModifier = new JButton("Modifier");
	private JButton btSupprimer = new JButton("Supprimer");
	private JButton btOk = new JButton("Ok");
	
	private JTextField txtMot = new JTextField();
	
	private JPanel unPanelDeRecherche = new JPanel();
	private JPanel unPanelBoutons = new JPanel();
	
	public PanelClient() 
	{
		super();
        this.setBackground(Color.green);
        String entetes [] = {"Id Client", "Nom", "Prénom", "Adresse", "Email", "Téléphone"};
        unTableau = new Tableau(this.getLesClients(Modele.selectAllClients()), entetes);
        uneTable = new JTable(unTableau);
        JScrollPane unScroll = new JScrollPane (uneTable);
        unScroll.setBounds(10, 10, 400, 150);
        this.add(unScroll);

        //construction du panel recherche
        this.unPanelDeRecherche.setLayout(new GridLayout(1, 3));
        this.unPanelDeRecherche.add(new JLabel ("Filtre par colonnes : "));
        this.unPanelDeRecherche.add(txtMot);
        this.unPanelDeRecherche.add(btOk);
        this.unPanelDeRecherche.setBounds(100, 170, 200, 30);
        this.add(unPanelDeRecherche);
        
        //Construction du panel ajouter
        this.unPanelAjout.setLayout(new GridLayout(2, 4));
        
        this.txtIdClient.setEditable(false);
        
        this.unPanelAjout.add(new JLabel("Id Client : "));
        this.unPanelAjout.add(txtIdClient);
        
        this.unPanelAjout.add(new JLabel("Nom : "));
        this.unPanelAjout.add(txtNom);
        
        this.unPanelAjout.add(new JLabel("Prénom : "));
        this.unPanelAjout.add(txtPrenom);
        
        this.unPanelAjout.add(new JLabel("Adresse : "));
        this.unPanelAjout.add(txtAdresse);
        
        this.unPanelAjout.add(new JLabel("Email : "));
        this.unPanelAjout.add(txtEmail);
        
        this.unPanelAjout.add(new JLabel("Téléphone : "));
        this.unPanelAjout.add(txtTel);
        
        this.unPanelAjout.setBounds(20, 220, 400, 60);
        this.add(this.unPanelAjout);
        
        //Construction du panel boutons
        this.unPanelBoutons.setLayout(new GridLayout(1, 4));
        this.unPanelBoutons.setBounds(20, 300, 370, 20);
        this.unPanelBoutons.add(this.btAnnuler);
        this.unPanelBoutons.add(this.btAjouter);
        this.unPanelBoutons.add(this.btModifier);
        this.unPanelBoutons.add(this.btSupprimer);
        this.add(this.unPanelBoutons);
        this.btAnnuler.addActionListener(this);
        this.btAjouter.addActionListener(this);
        this.btModifier.addActionListener(this);
        this.btSupprimer.addActionListener(this);
        
        this.btOk.addActionListener(this);
        
        uneTable.addMouseListener(new MouseListener() 
        {	
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int ligne = uneTable.getSelectedRow();

				txtIdClient.setText((int) uneTable.getValueAt(ligne, 0) + "");
				txtNom.setText((String) uneTable.getValueAt(ligne, 1));
				txtPrenom.setText((String) uneTable.getValueAt(ligne, 2));
				txtAdresse.setText((String) uneTable.getValueAt(ligne, 3));
				txtEmail.setText((String) uneTable.getValueAt(ligne, 4));
				txtTel.setText((String) uneTable.getValueAt(ligne, 5));
			}
		});
	}
	
	public Object[][] getLesClients(ArrayList <Client> lesClients)
	{
		
		Object[][] matrice = new Object[lesClients.size()][6];
		int i = 0;
		for(Client unClient : lesClients)
		{
			matrice[i][0] = unClient.getIdClient();
			matrice[i][1] = unClient.getNom();
			matrice[i][2] = unClient.getPrenom();
			matrice[i][3] = unClient.getAdresse();
			matrice[i][4] = unClient.getEmail();
			matrice[i][5] = unClient.getTel();
			i++;
		}
		return matrice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btOk)
		{
			String mot = this.txtMot.getText();
			Object [][] matrice = this.getLesClients(Modele.selectWhereClient(mot));
            unTableau.setDonnees (matrice);
		}
		else if(e.getSource() == this.btAnnuler)
		{
			txtIdClient.setText("");
			txtNom.setText("");
			txtPrenom.setText("");
			txtAdresse.setText("");
			txtEmail.setText("");
			txtTel.setText("");
		}
		else if(e.getSource() == this.btAjouter)
		{
			Client unClient = new Client
					(
						txtNom.getText(), txtPrenom.getText(), txtAdresse.getText(), txtEmail.getText(), txtTel.getText()
					);
			Modele.insertClient(unClient);
			
			unClient = Modele.selectWhereClient(unClient);
			
			Object ligne[] = {unClient.getIdClient(), unClient.getNom(), unClient.getPrenom(), unClient.getAdresse(), unClient.getEmail(), unClient.getTel()};
			unTableau.insertTable(ligne);
			JOptionPane.showMessageDialog(this, "Insertion réussie", "Insertion d'un client", JOptionPane.INFORMATION_MESSAGE);
			
			txtIdClient.setText("");
			txtNom.setText("");
			txtPrenom.setText("");
			txtAdresse.setText("");
			txtEmail.setText("");
			txtTel.setText("");
		}
		else if(e.getSource() == this.btModifier)
		{
			int idClient = Integer.parseInt(txtIdClient.getText());
			
			Client unClient = new Client
					(
						idClient, txtPrenom.getText(), txtNom.getText(), txtAdresse.getText(), txtEmail.getText(), txtTel.getText()
					);
			Modele.updateClient(unClient);
			Object ligne[] = {unClient.getIdClient(), unClient.getPrenom(), unClient.getNom(), unClient.getAdresse(), unClient.getEmail(), unClient.getTel()};
			int indiceLigne = uneTable.getSelectedRow();
			unTableau.updateTable(ligne, indiceLigne);
		}
		else if(e.getSource() == this.btSupprimer)
		{
			int idClient = Integer.parseInt(txtIdClient.getText());
			Modele.deleteClient(idClient);
			int indiceLigne = uneTable.getSelectedRow();
			unTableau.deleteTable(indiceLigne);
		}
	}
}
