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
		List<Produs>listaProduse=new LinkedList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				Statement statement =con.createStatement();
				String sql="select * from produse";
				ResultSet rs=statement.executeQuery(sql);
				while(rs.next()) {
					nume=rs.getString("nume");
					cod=rs.getInt("cod");
					cantitate=rs.getInt("cantitate");
					categorie=rs.getString("categorie");
					pret=rs.getInt("pret");
					System.out.println(nume+" "+cod+" "+cantitate+" "+pret+" "+categorie);
					
					if(categorie.equals("Sucuri")) {
						System.out.println("creez suc");
						Sucuri sucNou=new Sucuri(cod,cantitate,nume,pret);
						listaProduse.add(sucNou);
					}
					else if(categorie.equals("Dulciuri")) {
						Dulciuri dulceNou=new Dulciuri(cod,cantitate,nume,pret);
						listaProduse.add(dulceNou);
					}
					else if(categorie.equals("Snacks")) {
						Snacks snacksNou=new Snacks(cod,cantitate,nume,pret);
						listaProduse.add(snacksNou);
					}
				}
				con.close();
		}
					catch (Exception e) {
						e.printStackTrace();
					}
		return listaProduse;
		 
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
	public void editeazaProdus(ActionEvent event) throws IOException{
		FXMLLoader loaderr = new FXMLLoader(getClass().getResource("EditeazaProdus.fxml"));
		root = loaderr.load();
		scene = new Scene(root);
		// stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		Stage Stage = new Stage();
		Stage.setScene(scene);
		Stage.initOwner(stage);
		Stage.close();
		Stage.showAndWait();
	}
	public void stergeProdus(ActionEvent event) throws IOException {
		final int selectedIdx = listView.getSelectionModel().getSelectedIndex();
		if (selectedIdx != -1) {
			Produs itemToRemove = listView.getSelectionModel().getSelectedItem();
			final int newSelectedIdx = (selectedIdx == listView.getItems().size() - 1) ? selectedIdx - 1 : selectedIdx;
			listView.getItems().remove(selectedIdx);
			listaProduse.remove(itemToRemove);
			listView.getSelectionModel().select(newSelectedIdx);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
					String sql="delete from produse where cod=?";
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setInt(1,itemToRemove.cod);
					statement.executeUpdate();
					statement.close();
					
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void showLista(List<Produs> listaProduse) {
		for (Produs p : listaProduse)
			System.out.println(p);
	}
}