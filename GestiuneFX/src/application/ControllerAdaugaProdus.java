package application;

import java.io.IOException;
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
		int cantitateSucc = Integer.parseInt(cantitate.getText());
		Sucuri sucNou = new Sucuri(codSucc, cantitateSucc, numeSucc, pretSucc);
		return sucNou;
	}

	public Dulciuri adaugaDulce(){
		String numeDulcee = nume.getText();
		int pretDulcee = Integer.parseInt(pret.getText());
		int codDulcee = Integer.parseInt(cod.getText());
		int cantitateDulcee = Integer.parseInt(cantitate.getText());
		Dulciuri dulceNou = new Dulciuri(codDulcee, cantitateDulcee, numeDulcee, pretDulcee);
		return dulceNou;

	}

	public Snacks adaugaSnacks() {
		String numeSnacks = nume.getText();
		int pretSnacks = Integer.parseInt(pret.getText());
		int codSnacks = Integer.parseInt(cod.getText());
		int cantitateSnacks = Integer.parseInt(cantitate.getText());
		Snacks snacksNou = new Snacks(codSnacks, cantitateSnacks, numeSnacks, pretSnacks);
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
