package Controleur;

import javax.swing.JOptionPane;

import Modele.BDD;
import Modele.Modele;
import View.VueConnexion;
import View.VueGeneral;

public class Main 
{
	private static User unUser = new User();
	private static VueConnexion uneVueConnexion;
	private static VueGeneral uneVueGeneral;
	
	public static void setVisible (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	
	public static void main(String[] args) 
	{
		uneVueConnexion = new VueConnexion();
	}
	
	public static void verifConnexion(String email, String mdp)
	{
		if(email.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Veuillez remplir les identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			User unUser = Modele.selectWhereUser(email, mdp);
			if(unUser == null)
			{
				JOptionPane.showMessageDialog(null, "Veuillez vérifier les identifiants !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bienvenue Mme / Mr " + unUser.getPrenom() + " " + unUser.getNom(), "information", JOptionPane.INFORMATION_MESSAGE);
				uneVueGeneral = new VueGeneral(unUser);
				uneVueConnexion.setVisible(false);
			}
		}
	}

	public static User getUnUser() {
		return unUser;
	}

	public static void setUnUser(User unUser) {
		Main.unUser = unUser;
	}
}


/*BDD uneBdd = new BDD("localhost", "fnac", "root", "");
uneBdd.seConnecter();
uneBdd.seDeConnecter();
System.out.println("Ok");*/

/*Article unA = new Article("First man", (float)2.20, 20, "Films");
Modele.insertArticle(unA);*/ //INSERT

/*Article unA = new Article(4, "Last man", (float)2.20, 20, "Films");
Modele.updateArticle(unA);*/ //UPDATE

/*Modele.deleteArticle(4);*/ //DELETE
	
/*System.out.println("Les articles");
for(Article unArticle : Modele.selectAllArticles())
{
	System.out.println("Designation : " + unArticle.getDesignation());
}*/

/*User unU = new User("c@gmail.com", "123", "On", "Sasorishi", "autre");
Modele.insertUser(unU);*/ //INSERT

/*User unU = new User(3, "c@gmail.com", "123", "On", "Sasorishi", "admin");
Modele.updateUser(unU);*/ //UPDATE

/*Modele.deleteUser(3);*/ //DELETE

/*System.out.println("Les User");
for(User unUser : Modele.selectAllUsers())
{
	System.out.println("******************************");
	System.out.println("Email : " + unUser.getEmail());
	System.out.println("Nom : " + unUser.getNom());
	System.out.println("Prenom : " + unUser.getPrenom());
	System.out.println("Droit : " + unUser.getDroit());
}*/
