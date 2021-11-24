package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void clickRegister(ActionEvent event) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("SceneRegister.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void clickLogin(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
	}
}
