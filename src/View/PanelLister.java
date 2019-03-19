package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Article;
import Controleur.Categorie;
import Controleur.Main;
import Controleur.Tableau;
import Modele.Modele;

public class PanelLister extends Panel implements ActionListener
{
	private JTable uneTable;
	private static Tableau unTableau;
	private JPanel panelModif = new JPanel();
	private JTextField txtDesignation = new JTextField();
	private JTextField txtPrix = new JTextField();
	private JTextField txtQte = new JTextField();
	private JTextField txtCategorie = new JTextField();
	private JButton btModifier = new JButton("Modifier");
	
	public PanelLister()
	{
		super();
		
		String enTetes[] = {"idArticle", "Désignation", "Prix", "Quantité", "Catégorie"};
		unTableau = new Tableau(this.getLesDonnees(), enTetes);
		
		uneTable = new JTable(unTableau);
		
		JScrollPane unScroll = new JScrollPane(uneTable);
		unScroll.setBounds(20, 20, 310, 150);
		this.add(unScroll);
		
		uneTable.addMouseListener(new MouseListener() 
		{	
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void mousePressed(MouseEvent e) 
			{
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				// TODO Auto-generated method stub	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				int ligne = uneTable.getSelectedRow();
				
				if(e.getClickCount() == 1)
				{
					txtDesignation.setText((String) uneTable.getValueAt(ligne, 1));
					txtPrix.setText((float) uneTable.getValueAt(ligne, 2) + "");
					txtQte.setText((int) uneTable.getValueAt(ligne, 3) + "");
					txtCategorie.setText((String) uneTable.getValueAt(ligne, 4));
				}
				
				else if(e.getClickCount() == 2)
				{
					int idArticle = (int) uneTable.getValueAt(ligne, 0);
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer l'article", "Suppression article", JOptionPane.YES_NO_CANCEL_OPTION);
				
					if(retour == 0)
					{
						Modele.deleteArticle(idArticle);
						unTableau.deleteTable(ligne);
					}
				}
			}
		});
		
		panelModif.setLayout(new GridLayout(5, 4));
		panelModif.setBounds(20, 180, 350, 80);
		
		panelModif.add(new JLabel("Désignation :"));
		panelModif.add(txtDesignation);
		
		panelModif.add(new JLabel("Prix :"));
		panelModif.add(txtPrix);
		
		panelModif.add(new JLabel("Qte :"));
		panelModif.add(txtQte);
		
		panelModif.add(new JLabel("Catégorie :"));
		panelModif.add(txtCategorie);
		
		panelModif.add(btModifier);
		
		this.add(panelModif);
		
		//Rend le bouton cliquable
		this.btModifier.addActionListener(this);
		Main.getUnUser();
	}
	
	public Object[][] getLesDonnees()
	{
		ArrayList <Article> lesArticles = Modele.selectAllArticles();
		Object matrice[][] = new Object[lesArticles.size()][5];
		int i = 0;
		for(Article unA : lesArticles)
		{
			matrice[i][0] = unA.getIdArticle();
			matrice[i][1] = unA.getDesignation();
			matrice[i][2] = unA.getPrix();
			matrice[i][3] = unA.getQte();
			Categorie uneCategorie = Modele.selectWhereCategorie(unA.getIdCategorie());
			matrice[i][4] = uneCategorie.getLibelle();
			i++;
		}
		return matrice;
	}

	public static void insertTable(Article unArticle) 
	{
		Object ligne[] = {unArticle.getIdArticle(), unArticle.getDesignation(), unArticle.getPrix(), unArticle.getQte(), unArticle.getIdCategorie()};
		unTableau.insertTable(ligne);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btModifier)
		{
			float prix = Float.parseFloat(txtPrix.getText());
			int qte = Integer.parseInt(txtQte.getText());
			int i = uneTable.getSelectedRow();
			int idArticle = (int) uneTable.getValueAt(i, 0);
			
			Object ligne[] = {idArticle, txtDesignation.getText(), prix, qte, txtCategorie.getText()};
			unTableau.updateTable(ligne, uneTable.getSelectedRow());
			
			Article unArticle = new Article(idArticle, txtDesignation.getText(), prix, qte, Integer.parseInt(txtCategorie.getText()));
			Modele.updateArticle(unArticle);
			this.txtDesignation.setText("");
			this.txtPrix.setText("");
			this.txtQte.setText("");
			this.txtCategorie.setText("");
		}
	}
}
