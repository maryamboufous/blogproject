package com.xadmin.usermanagement.bean;

public class Blog {
	protected int id;
	protected String titre;
	protected String soustitre;
	protected String contenu;
	
	public Blog() {
	}
	
	public Blog(String titre, String soustitre, String contenu) {
		super();
		this.titre = titre;
		this.soustitre = soustitre;
		this.contenu = contenu;
	}

	public Blog(int id, String titre, String soustitre, String contenu) {
		super();
		this.id = id;
		this.titre = titre;
		this.soustitre = soustitre;
		this.contenu = contenu;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSoustitre() {
		return soustitre;
	}
	public void setSoustitre(String soustitre) {
		this.soustitre = soustitre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}