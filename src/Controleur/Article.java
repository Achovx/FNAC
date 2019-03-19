package Controleur;

public class Article 
{
	private int idArticle;
	private String designation;
	private float prix;
	private int qte;
	private int idCategorie;
	
	public Article(int idArticle, String designation, float prix, int qte, int idCategorie) 
	{
		this.idArticle = idArticle;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
		this.idCategorie = idCategorie;
	}
	
	public Article(String designation, float prix, int qte, int idCategorie) 
	{
		this.idArticle = 0;
		this.designation = designation;
		this.prix = prix;
		this.qte = qte;
		this.idCategorie = idCategorie;
	}
	
	public Article() 
	{
		this.idArticle = 0;
		this.designation = "";
		this.prix = 0;
		this.qte = 0;
		this.idCategorie = 0;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
}
