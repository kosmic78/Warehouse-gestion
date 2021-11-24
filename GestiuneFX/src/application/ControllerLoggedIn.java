package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerLoggedIn implements Initializable {
	private Stage stage;
	private Scene scene;
	static String nume, categorie;
	static int cod, pret, cantitate;
	private Parent root;
	List<Produs> listaProduse = new LinkedList<>(creareLista());
	private String[] listaChoice = { "Snacks", "Dulciuri", "Sucuri", "Toate" };

	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private ListView<Produs> listView;
	private Sucuri sucNou;
	private Dulciuri dulceNou;
	private Snacks snacksNou;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceBox.getItems().addAll(listaChoice);
		choiceBox.setOnAction(this::setCategorie);
		listView.getItems().addAll(listaProduse);
	}

	public void setCategorie(ActionEvent event) {
		String categorie = choiceBox.getValue();
		listView.getItems().clear();
		if (categorie == "Dulciuri")
			listView.getItems().addAll(showDulciuri(listaProduse));
		else if (categorie == "Snacks")
			listView.getItems().addAll(showSnacks(listaProduse));
		else if (categorie == "Sucuri")
			listView.getItems().addAll(showSucuri(listaProduse));
		else if (categorie == "Toate")
			listView.getItems().addAll(listaProduse);
	}

	public static List<Produs> showDulciuri(List<Produs> listaProduse) {
		List<Produs> listaProduseTmp = new LinkedList<>();
		for (Produs p : listaProduse)
			if (p instanceof Dulciuri)
				listaProduseTmp.add(p);
		return listaProduseTmp;

	}

	public static List<Produs> showSnacks(List<Produs> listaProduse) {
		List<Produs> listaProduseTmp = new LinkedList<>();
		for (Produs p : listaProduse)
			if (p instanceof Snacks)
				listaProduseTmp.add(p);
		return listaProduseTmp;

	}

	public static List<Produs> showSucuri(List<Produs> listaProduse) {
		List<Produs> listaProduseTmp = new LinkedList<>();
		for (Produs p : listaProduse)
			if (p instanceof Sucuri)
				listaProduseTmp.add(p);
		return listaProduseTmp;

	}

	public static List<Produs> creareLista() {
		Snacks chioSare = new Snacks(6, 10, "Chio Chips sare", 3);
		Snacks chioCoptiSare = new Snacks(1, 10, "Chio Copti in cuptor sare", 5);
		Snacks laysSare = new Snacks(4, 45, "Lay's sare", 3);
		Snacks laysPaprika = new Snacks(5, 45, "Lay's paprika", 3);
		Dulciuri sevenDays = new Dulciuri(2, 20, "7Days", 3);
		Dulciuri kinderBueno = new Dulciuri(7, 20, "Kinder bueno", 2);
		Sucuri cocaCola = new Sucuri(3, 50, "Coca Cola", 3);
		Sucuri pepsi = new Sucuri(8, 20, "Pepsi", 3);
		Sucuri mirinda = new Sucuri(9, 30, "Mirinda", 5);
		List<Produs> listaProduse = new LinkedList<>(List.of(chioSare, sevenDays, cocaCola, laysSare, laysPaprika,
				chioCoptiSare, kinderBueno, pepsi, mirinda));
		return listaProduse;

		
		 /* try { try { Class.forName("com.mysql.cj.jdbc.Driver"); } catch
		  (ClassNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); } //Connection
		 Connection con=DriverManager.getConnection("jbdc:mysql://localhost:3360/gestiune","root"
		  ,"admin"); Connection con=DriverManager.getConnection(String.format("jbdc:mysql://%s:%d/%s",
		  "127.0.0.1",3306,"gestiune"),"root",""); PreparedStatement statement =
		  con.prepareStatement("select * from produse"); ResultSet query =
		  statement.executeQuery(); while (query.next()) { nume =
		  query.getString("nume"); System.out.print("test"); categorie =
		  query.getString("categorie"); cod = Integer.parseInt(query.getString("cod"));
		  pret = Integer.parseInt(query.getString("pret")); cantitate =
		  Integer.parseInt(query.getString("cantitate")); if (categorie == "Dulciuri")
		  { Dulciuri dulce = new Dulciuri(cod, cantitate, nume, pret);
		  listaProduse.add(dulce); } if (categorie == "Sucuri") { Sucuri suc = new
		  Sucuri(cod, cantitate, nume, pret); listaProduse.add(suc); } if (categorie ==
		  "Snacks") { Snacks snacks = new Snacks(cod, cantitate, nume, pret);
		  listaProduse.add(snacks); } } System.out.print("conexiune cu succes"); }
		  catch (SQLException ex) {
		  //Logger.getLogger(ControllerLoggedIn.class.getName()).log(Level.SEVERE,null,
		  ex); }
		  */
		 
	}

	public void logOut(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
	}

	public void adaugaProdus(ActionEvent event) throws IOException {
		FXMLLoader loaderr = new FXMLLoader(getClass().getResource("AdaugaProdus.fxml"));
		root = loaderr.load();
		scene = new Scene(root);
		// stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Stage Stage = new Stage();
		Stage.setScene(scene);
		Stage.initOwner(stage);
		Stage.close();
		Stage.showAndWait();
		ControllerAdaugaProdus controllerAdauga = loaderr.getController();
		System.out.print(controllerAdauga.categorie.getText());
		if (controllerAdauga.categorie.getText().equals("Sucuri")) {
			sucNou = controllerAdauga.adaugaSuc();
			listaProduse.add(sucNou);
		}
		if (controllerAdauga.categorie.getText().equals("Dulciuri")) {
			dulceNou = controllerAdauga.adaugaDulce();
			listaProduse.add(dulceNou);
		}
		if (controllerAdauga.categorie.getText().equals("Snacks")) {
			snacksNou = controllerAdauga.adaugaSnacks();
			listaProduse.add(snacksNou);
		}

	}

	public void stergeProdus(ActionEvent event) throws IOException {
		final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
		if (selectedIdx != -1) {
			Produs itemToRemove = listView.getSelectionModel().getSelectedItem();
			final int newSelectedIdx = (selectedIdx == listView.getItems().size() - 1) ? selectedIdx - 1 : selectedIdx;

			listView.getItems().remove(selectedIdx);
			listaProduse.remove(itemToRemove);
			listView.getSelectionModel().select(newSelectedIdx);
		}

	}

	public static void showLista(List<Produs> listaProduse) {
		for (Produs p : listaProduse)
			System.out.println(p);
	}
}
