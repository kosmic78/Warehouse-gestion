package application;

public class Dulciuri extends Produs{
	public int cantitate;
	public String nume;
	public int  pret;
	public Dulciuri(int cod, int cantitate, String nume, int pret) {
		super(cod);
		this.cantitate = cantitate;
		this.nume = nume;
		this.pret = pret;
	}
	@Override
	public String toString() {
		return "Dulce [nume=" + nume + ", cantitate=" + cantitate + ", pret=" + pret + ", cod=" + cod + "]";
	}
	public String getNume() {
		return this.nume;
	}
	public int getCantitate() {
		return this.cantitate;
	}
	public double getPret() {
		return this.pret;
	}
	public int getCod() {
		return this.cod;
	}
}
