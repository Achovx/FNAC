package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.jws.WebParam.Mode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controleur.Article;
import Controleur.Categorie;
import Modele.Modele;

public class PanelAjout extends Panel implements ActionListener
{
	private JTextField txtDesignation = new JTextField();
	private JTextField txtPrix = new JTextField();
	private JTextField txtQte = new JTextField();
	private JComboBox<String> cbxCategorie = new JComboBox();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistre = new JButton("Enrengistrer");
	
	public PanelAjout()
	{
		super();
		this.setLayout(new GridLayout(5, 1));
		this.add(new JLabel("Désignation : "));
		this.add(this.txtDesignation);
		
		this.add(new JLabel("Prix unitaire : "));
		this.add(this.txtPrix);
		
		this.add(new JLabel("Quantité en stock : "));
		this.add(this.txtQte);
		
		this.add(new JLabel("Catégorie : "));
		this.add(this.cbxCategorie);
		
		this.add(this.btAnnuler);
		this.add(this.btEnregistre);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistre.addActionListener(this);
		
		//Remplir le combo box
		this.remplirCategories();
	}
	
	public void remplirCategories()
	{
		ArrayList<Categorie> lesCategories = Modele.selectAllCategories();
		
		for(Categorie uneCategorie : lesCategories)
		{
			this.cbxCategorie.addItem(uneCategorie.getIdCategorie() + " - " + uneCategorie.getLibelle());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btAnnuler)
		{
			this.txtDesignation.setText("");
			this.txtPrix.setText("");
			this.txtQte.setText("");
			//this.txtCategorie.setText("");
		}
		else if(e.getSource() == this.btEnregistre)
		{
			if(this.txtDesignation.getText().equals("") || this.txtPrix.getText().equals("") || this.txtQte.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
			}
			else
			{
				String designation = this.txtDesignation.getText();
				String tab[] = this.cbxCategorie.getSelectedItem().toString().split(" - ");
				int categorie = Integer.parseInt(tab[0]);
				int qte = 0;
				float prix = 0;
				try
				{
					prix = Float.parseFloat(this.txtPrix.getText());
					qte = Integer.parseInt(this.txtQte.getText());
				}
				catch(NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(this, "Erreur sur le format du nombre !");
				}
				
				if(qte > 0 && prix > 0)
				{
					Article unArticle = new Article(designation, prix, qte, categorie);
					Modele.insertArticle(unArticle);
					
					PanelLister.insertTable(Modele.selectWhereArticle(unArticle));
					
					
					JOptionPane.showMessageDialog(this, "Insertion effectuée avec succès", "Information", JOptionPane.INFORMATION_MESSAGE);
					this.txtDesignation.setText("");
					this.txtPrix.setText("");
					this.txtQte.setText("");
					//this.txtCategorie.setText("");
					this.setVisible(false);
				}
				else
				{
					if(qte < 0)
					{
						this.txtQte.setBackground(Color.red);
					}
					
					if(prix < 0)
					{
						this.txtPrix.setBackground(Color.red);
					}
				}
			}
		}
	}
}
