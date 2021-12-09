package application;

public class Snacks extends Produs{
	public int cantitate;
	public String nume;
	public int pret;
	public Snacks(int cod, int cantitate, String nume, int pret) {
		super(cod);
		this.cantitate = cantitate;
		this.nume = nume;
		this.pret = pret;
	}
	@Override
	public String toString() {
		return "Snacks [nume=" + nume + ", cantitate=" + cantitate + ", pret=" + pret + ", cod=" + cod + "]";
	}
	
}
