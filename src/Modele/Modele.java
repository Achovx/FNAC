package Modele;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controleur.Article;
import Controleur.Categorie;
import Controleur.Client;
import Controleur.User;

public class Modele 
{
	private static BDD uneBDD = new BDD("localhost", "fnac", "root", "");
	
	public static ArrayList <Article> selectAllArticles()
	{
		ArrayList <Article> lesArticles = new ArrayList <Article>();
		String requete = "select *from article";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet desResultats = unState.executeQuery(requete);
			
			while(desResultats.next())
			{
				Article unArticle = new Article
				(
					desResultats.getInt("idArticle"),
					desResultats.getString("designation"),
					desResultats.getFloat("prix"),
					desResultats.getInt("qte"),
					desResultats.getInt("idCategorie")
				);
				
				lesArticles.add(unArticle);
			}
			unState.close();
			desResultats.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		return lesArticles;
	}
	
	public static void insertArticle(Article unArticle)
	{
		String requete = "insert into article values (null,'"
				+ unArticle.getDesignation() + "',"
				+ unArticle.getPrix() + ","
				+ unArticle.getQte() + ",'"
				+ unArticle.getIdCategorie() + "');";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static void deleteArticle(int idArticle)
	{
		String requete = "delete from article where idArticle = "+ idArticle +";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static void updateArticle(Article unArticle)
	{
		String requete = "update article set designation = '"
				+ unArticle.getDesignation() 
				+ "', prix = "
				+ unArticle.getPrix() 
				+ ", qte = "
				+ unArticle.getQte() 
				+ ", idCategorie = '"
				+ unArticle.getIdCategorie() 
				+ "' where idArticle = "
				+ unArticle.getIdArticle() + ";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	//USER
	public static ArrayList <User> selectAllUsers()
	{
		ArrayList <User> lesUsers = new ArrayList <User>();
		String requete = "select *from user";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet desResultats = unState.executeQuery(requete);
			
			while(desResultats.next())
			{
				User unUser = new User
				(
					desResultats.getInt("idUser"),
					desResultats.getString("email"),
					desResultats.getString("mdp"),
					desResultats.getString("nom"),
					desResultats.getString("prenom"),
					desResultats.getString("droit")
				);
				
				lesUsers.add(unUser);
			}
			unState.close();
			desResultats.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		return lesUsers;
	}
	
	public static void insertUser(User unUser)
	{
		String requete = "insert into user values (null,'"
				+ unUser.getEmail() + "','"
				+ unUser.getMdp() + "','"
				+ unUser.getNom() + "','"
				+ unUser.getPrenom() + "','"
				+ unUser.getDroit() + "');";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static void deleteUser(int idUser)
	{
		String requete = "delete from user where idUser = "+ idUser +";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static void updateUser(User unUser)
	{
		String requete = "update user set email = '"
				+ unUser.getIdUser()
				+ "', email = '"
				+ unUser.getEmail()
				+ "', mdp = '"
				+ unUser.getMdp() 	
				+ "', nom = '"
				+ unUser.getNom() 		
				+ "', prenom = '"
				+ unUser.getPrenom() 		
				+ "', droit = '"
				+ unUser.getDroit()
				+ "' where idUser = "
				+ unUser.getIdUser() + ";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static User selectWhereUser (String email, String mdp)
    {
        User unUser = null;
        String requete = "select * from user where email ='"
                + email + "' and mdp ='"
                + mdp + "';";
        Modele.uneBDD.seConnecter();
        try
        {
            Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
            ResultSet unResultat = unStat.executeQuery(requete);
            if (unResultat.next())
            {
                 unUser = new User (
                        unResultat.getInt("idUser"),
                        unResultat.getString("email"),
                        unResultat.getString("mdp"),
                        unResultat.getString("nom"),
                        unResultat.getString("prenom"),
                        unResultat.getString("droit")
                        );
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur execution :" + requete);
        }

        Modele.uneBDD.seDeConnecter();
        return unUser;
    }

	public static Article selectWhereArticle(Article unArticle) 
	{
		Article unA = null;
		String requete = "select idArticle from article where " 
		+ "designation = '" + unArticle.getDesignation()
		+ "' and prix = " + unArticle.getPrix()
		+ " and qte = " + unArticle.getQte()
		+ " and idCategorie = '" + unArticle.getIdCategorie() + "';";
		
		Modele.uneBDD.seConnecter();
		try
		{
			Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				unA = new Article(unRes.getInt("idArticle"), unArticle.getDesignation(), unArticle.getPrix(), unArticle.getQte(), unArticle.getIdCategorie());
			}
		}
		catch (SQLException exp) 
		{
			System.out.println("Erreur requete : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
		return unA;
	}
	
	public static ArrayList <Client> selectAllClients()
	{
		ArrayList <Client> lesClients = new ArrayList <Client>();
		String requete = "select *from client";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet desResultats = unState.executeQuery(requete);
			
			while(desResultats.next())
			{
				Client unClient = new Client
				(
					desResultats.getInt("idClient"),
					desResultats.getString("nom"),
					desResultats.getString("prenom"),
					desResultats.getString("adresse"),
					desResultats.getString("email"),
					desResultats.getString("tel")
				);
				
				lesClients.add(unClient);
			}
			unState.close();
			desResultats.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		return lesClients;
	}
	
	public static void insertClient(Client unClient)
	{
		String requete = "insert into client values (null,'"
                + unClient.getNom() + "','"
                + unClient.getPrenom() + "','"
                + unClient.getAdresse() + "','"
                + unClient.getEmail() + "','"
                + unClient.getTel() + "');";
        Modele.uneBDD.seConnecter();

        try
        {
	        Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
	        unState.execute(requete);
	        unState.close();
        }
        catch(SQLException exp)
        {
        	System.out.println("Erreur execution : " + requete);
        }
        Modele.uneBDD.seDeConnecter();
	}
	
	public static void deleteClient(int idClient)
	{
		String requete = "delete from client where idClient = "+ idClient +";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static void updateClient(Client unClient)
	{
		String requete = "update client set nom = '"
				+ unClient.getNom()
				+ "', prenom = '"
				+ unClient.getPrenom()
				+ "', adresse = '"
				+ unClient.getAdresse() 	
				+ "', email = '"
				+ unClient.getEmail() 		
				+ "', tel = '"
				+ unClient.getTel() 		
				+ "' where idClient = "
				+ unClient.getIdClient() + ";";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			unState.execute(requete);
			unState.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
	}
	
	public static ArrayList <Client> selectWhereClient(String mot)
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "select *from client where " 
		+ "nom like '%" + mot + "%'"
		+ "' or prenom like '%" + mot + "%'"
		+ " or adresse like '%" + mot + "%'"
		+ " or email like '%" + mot + "%'"
		+ " or tel like '%" + mot + "%'" + "';";
		
		Modele.uneBDD.seConnecter();
		try
		{
			Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
            {
                 Client unClient = new Client (
                         unRes.getInt("idclient"),
                         unRes.getString("nom"),
                         unRes.getString("prenom"),
                         unRes.getString("adresse"),
                         unRes.getString("email"),
                         unRes.getString("tel")
                        );
                 lesClients.add(unClient);
            }
            unStat.close();
            unRes.close();
		}
		catch (SQLException exp) 
		{
			System.out.println("Erreur requete : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
		return lesClients;
	}
	
	public static ArrayList <Categorie> selectAllCategories()
	{
		ArrayList <Categorie> lesCategories = new ArrayList <Categorie>();
		String requete = "select *from categorie";
		Modele.uneBDD.seConnecter();
		
		try
		{
			Statement unState = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet desResultats = unState.executeQuery(requete);
			
			while(desResultats.next())
			{
				Categorie unCategorie = new Categorie
				(
					desResultats.getInt("idCategorie"),
					desResultats.getString("libelle")
				);
				
				lesCategories.add(unCategorie);
			}
			unState.close();
			desResultats.close();
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur execution : " + requete);
		}
		
		return lesCategories;
	}
	
	public static Categorie selectWhereCategorie(int idCategorie)
	{
		Categorie uneCategorie = null;
		String requete = "select *from categorie " + "where idCategorie =" + idCategorie + ";";
		
		Modele.uneBDD.seConnecter();
		try
		{
			Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
            {
                 uneCategorie = new Categorie (
                         unRes.getInt("idCategorie"),
                         unRes.getString("libelle")
                        );
            }
            unStat.close();
            unRes.close();
		}
		catch (SQLException exp) 
		{
			System.out.println("Erreur requete : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
		return uneCategorie;
	}
	
	public static int[] statsBDD()
	{
		int tab[] = new int[3];
		String requete1 = "select count(*) as nbClient from client;";
		String requete2 = "select count(*) as nbArticle from article;";
		String requete3 = "select count(*) as nbCommande from commander;";
		
		Modele.uneBDD.seConnecter();
        try
        {
            Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete1);
            
            if (unRes.next())
            {
                tab[0] = unRes.getInt("nbClient");
            }
            
            unRes = unStat.executeQuery(requete2);
            if(unRes.next())
            {
            	tab[1] = unRes.getInt("nbArticle");
            }
            
            unRes = unStat.executeQuery(requete3);
            if(unRes.next())
            {
            	tab[2] = unRes.getInt("nbCommander");
            }
            
            unStat.close();
            unRes.close();
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur execution :" + requete1);
        }
        Modele.uneBDD.seDeConnecter();
        return tab;
	}

	public static Client selectWhereClient(Client unClient) 
	{
		Client unC = null;
		String requete = "select *from client where " 
		+ "nom = '" + unClient.getNom()
		+ "' and prenom = '" + unClient.getPrenom()
		+ "' and adresse = '" + unClient.getAdresse()
		+ "' and email = '" + unClient.getEmail()
		+ "' and tel = '" + unClient.getTel() + "';";
		
		Modele.uneBDD.seConnecter();
		try
		{
			Statement unStat = Modele.uneBDD.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				unC = new Client(unRes.getInt("idClient"), unClient.getNom(), unClient.getPrenom(), unClient.getAdresse(), unClient.getEmail(), unClient.getTel());
			}
		}
		catch (SQLException exp) 
		{
			System.out.println("Erreur requete : " + requete);
		}
		Modele.uneBDD.seDeConnecter();
		return unC;
	}
}