package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
	@FXML
	TextField username;
	@FXML
	TextField password;
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
		String usernameTmp=username.getText();
		String passwordTmp=password.getText();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				Statement statement =con.createStatement();
				String sql="select username,password from users where username= '"+usernameTmp+"' and password ='"+password+"'";
				ResultSet rs=statement.executeQuery(sql);
				while (rs.next())
				{
					String usernameDB=rs.getString("username");
					String passwordDB=rs.getString("password");
					
				}
				con.close();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
		
	}
}
