package Modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD 
{
   private String server, user, mdp, bdd;
   private Connection maConnexion;
   
   public BDD(String server, String bdd, String user, String mdp)
   {
       this.server = server;
       this.user = user;
       this.bdd = bdd;
       this.mdp = mdp;
       this.maConnexion = null;
   }
   
   public void chargerPilote()
   {
       try
       {
    	   Class.forName("com.mysql.jdbc.Driver");
       }
       
       catch(ClassNotFoundException exp)
       {
    	   System.out.println("Absence du pilote JDBC !");
       }
   }
   
   public void seConnecter() 
   {
       this.chargerPilote();
       String url = "jdbc:mysql://" + this.server + "/" + this.bdd;
       try 
       {
           this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
       }
       
       catch(SQLException exp) 
       {
           System.out.println("Connexion impossible  à " + url);
       }
   }
   
   public void seDeConnecter()
   {
	   try
	   {
		   if(this.maConnexion != null)
	       {
	    	   this.maConnexion.close();
	       }   
	   }
       
       catch(SQLException exp)
       {
    	   System.out.println("Impossible de fermer la connexion !");
       }
   }
   
   public Connection getMaConnexion()
   {
       return this.maConnexion;
   }
} 
