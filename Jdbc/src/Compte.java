public class Compte {
	private int CodeCli;
	private int NumCpte;
	private int solde;
	public Compte(int NumCpte,int solde,int CodeCli) {
		this.NumCpte=NumCpte;
		this.solde=solde;
		this.CodeCli=CodeCli;
	}
	public Compte(){};
    
	  public int getCodeCli() {
	    return CodeCli;
	     
	  }
	    public void setCodeCli(int CodeCli) {
		      this.CodeCli = CodeCli;
		    }

	    public int getNumCpte() {
		      return NumCpte;
		    }

	    public void setNumCpte(int NumCpte) {
	      this.NumCpte = NumCpte;
	    }

	    public int getSolde() {
	      return solde;
	    }

	    public void setSolde(int solde) {
	      this.solde = solde;
	    
	  }
	    public String toString() {
			return "Compte [CodeCli=" + CodeCli + ", NumCpte=" + NumCpte + ", solde=" + solde + "]";
		}


}
