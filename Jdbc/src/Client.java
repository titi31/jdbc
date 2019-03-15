
public class Client {
	private int CodeCli;
	private String nom;
	private String prenom;
	public Client(int CodeCli,String nom,String prenom) {
		this.CodeCli=CodeCli;
		this.nom=nom;
		this.prenom=prenom;
	}
	public Client(){};
    
	  public int getCodeCli() {
	    return CodeCli;
	     
	  }
	    public void setCodeCli(int CodeCli) {
		      this.CodeCli = CodeCli;
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
		@Override
		public String toString() {
			return "Client [CodeCli=" + CodeCli + ", nom=" + nom + ", prenom=" + prenom + "]";
		}


}
