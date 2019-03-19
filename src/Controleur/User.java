package Controleur;

public class User 
{
	private int idUser;
	private String email;
	private String mdp;
	private String nom;
	private String prenom;
	private String droit;
	
	public User(int idUser, String email, String mdp, String nom, String prenom, String droit) 
	{
		this.idUser = idUser;
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.droit = droit;
	}
	
	public User(String email, String mdp, String nom, String prenom, String droit) 
	{
		this.idUser = 0;
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.droit = droit;
	}
	
	public User() 
	{
		this.idUser = 0;
		this.email = "";
		this.mdp = "";
		this.nom = "";
		this.prenom = "";
		this.droit = "";
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDroit() {
		return droit;
	}

	public void setDroit(String droit) {
		this.droit = droit;
	}
}
