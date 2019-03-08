package classes;

public class User {

	public String nom;
	public String email;
	public String mdp;

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setNom(String nom) {
		this.nom = nom;
	};

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public String getEmail() {
		return email;
	};

}
