package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAdaugaProdus {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	TextField nume;
	@FXML
	TextField pret;
	@FXML
	TextField cod;
	@FXML
	TextField cantitate;
	@FXML
	TextField categorie;

	public Sucuri adaugaSuc() {
		String numeSucc = nume.getText();
		int pretSucc=Integer.parseInt(pret.getText());
		int codSucc = Integer.parseInt(cod.getText());
		String categorie="Sucuri";
		int cantitateSucc = Integer.parseInt(cantitate.getText());
		Sucuri sucNou = new Sucuri(codSucc, cantitateSucc, numeSucc, pretSucc);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				Statement statement =con.createStatement();
				String sql="insert into produse (cod,nume,pret,cantitate,categorie)" +"values('"+codSucc +"','"+numeSucc+"','"+pretSucc+"','"+cantitateSucc+"','"+categorie+"')";
				statement.executeUpdate(sql);
				con.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return sucNou;
	}

	public Dulciuri adaugaDulce(){
		String numeDulcee = nume.getText();
		int pretDulcee = Integer.parseInt(pret.getText());
		int codDulcee = Integer.parseInt(cod.getText());
		int cantitateDulcee = Integer.parseInt(cantitate.getText());
		String categorie="Dulciuri";
		Dulciuri dulceNou = new Dulciuri(codDulcee, cantitateDulcee, numeDulcee, pretDulcee);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				Statement statement =con.createStatement();
				String sql="insert into produse (cod,nume,pret,cantitate,categorie)" +"values('"+codDulcee +"','"+numeDulcee+"','"+pretDulcee+"','"+cantitateDulcee+"','"+categorie+"')";
				statement.executeUpdate(sql);
				con.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return dulceNou;

	}

	public Snacks adaugaSnacks() {
		String numeSnacks = nume.getText();
		String categorie="Snacks";
		int pretSnacks = Integer.parseInt(pret.getText());
		int codSnacks = Integer.parseInt(cod.getText());
		int cantitateSnacks = Integer.parseInt(cantitate.getText());
		Snacks snacksNou = new Snacks(codSnacks, cantitateSnacks, numeSnacks, pretSnacks);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				String sql="insert into produse (cod,nume,pret,cantitate,categorie)" +"values('"+codSnacks +"','"+numeSnacks+"','"+pretSnacks+"','"+cantitateSnacks+"','"+categorie+"')";
				Statement statement =con.prepareStatement(sql);
				statement.execute(sql);
				con.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return snacksNou;
	}

	public void cancel(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
	}
}
