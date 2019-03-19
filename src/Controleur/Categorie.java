package Controleur;

public class Categorie 
{
	private int idCategorie;
	private String libelle;
	
	public Categorie(int idCategorie, String libelle) 
	{
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	
	public Categorie(String libelle) 
	{
		this.idCategorie = 0;
		this.libelle = libelle;
	}
	
	public Categorie() 
	{
		this.idCategorie = 0;
		this.libelle = "";
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
