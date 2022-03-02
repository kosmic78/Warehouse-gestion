package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditeaza {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	TextField nume;
	@FXML
	TextField pret;
	@FXML
	TextField cantitate;
	@FXML
	TextField categorie;
	@FXML
	TextField id;
	public void confirmEditare() {
		String numeTmp=nume.getText();
		int pretTmp=Integer.parseInt(pret.getText());
		String cantitateTmp=cantitate.getText();
		String categorieTmp=categorie.getText();
		int idTmp=Integer.parseInt(id.getText());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestiune","root","");
				Statement statement =con.createStatement();
				String sql="update produse set nume= '" + numeTmp + "',pret ='" +pretTmp+"',cantitate='"+ cantitateTmp +"',categorie='"+categorieTmp+"'where cod= '" +idTmp+"'";
				statement.executeUpdate(sql);
				con.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
