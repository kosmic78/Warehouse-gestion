package application;

public class Sucuri extends Produs {
	public int cantitate;
	public int pret;
	public String nume;
	public Sucuri(int cod, int cantitate, String nume, int pret) {
		super(cod);
		this.cantitate = cantitate;
		this.pret = pret;
		this.nume = nume;
	}
	@Override
	public String toString() {
		return "Suc [nume=" + nume + ", cantitate=" + cantitate + ", pret=" + pret + ", cod=" + cod + "]";
	}
	
}
