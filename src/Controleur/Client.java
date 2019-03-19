package Controleur;

public class Client 
{
	private int idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String tel;
	
	public Client(int idClient, String nom, String prenom, String adresse, String email, String tel) 
	{
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	public Client(String nom, String prenom, String adresse, String email, String tel) 
	{
		this.idClient = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}
	
	public Client() 
	{
		this.idClient = 0;
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.email = "";
		this.tel = "";
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
