package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerRegister {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	TextField passwordRepeat;
	@FXML
	TextField email;
	@FXML
	Label labelRegister;
	String passwordTmp;
	String passwordRepeatTmp,usernameTmp,emailTMP;
	 public static int stringCompare(String str1, String str2)
	    {
	  
	        int l1 = str1.length();
	        int l2 = str2.length();
	        int lmin = Math.min(l1, l2);
	  
	        for (int i = 0; i < lmin; i++) {
	            int str1_ch = (int)str1.charAt(i);
	            int str2_ch = (int)str2.charAt(i);
	  
	            if (str1_ch != str2_ch) {
	                return str1_ch - str2_ch;
	            }
	        }
	        if (l1 != l2) {
	            return l1 - l2;
	        }
	        else {
	            return 0;
	        }
	    }
	public void clickRegister(ActionEvent e) {
	try {
		
		usernameTmp=username.getText();
		passwordTmp=password.getText();
		passwordRepeatTmp=passwordRepeat.getText();
		emailTMP=email.getText();
			if(stringCompare(passwordTmp,passwordRepeatTmp)==0&&usernameTmp.length()>0&&emailTMP.length()>0)
			{
				Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
				stage=(Stage)((Node)e.getSource()).getScene().getWindow();
				Scene scene=new Scene(root);
				stage.setResizable(false);
				stage.setScene(scene);
				stage.show();
			}
			else
				if(stringCompare(passwordTmp,passwordRepeatTmp)!=0)
					labelRegister.setText("Parolele nu corespund!");
				else
					if(usernameTmp.length()==0)
						labelRegister.setText("Username invalid!");
					else
						if(emailTMP.length()==0)
							labelRegister.setText("Email invalid!");
				
			
	
		}catch (Exception e1) {
		System.out.println(e1);
	}
		
	}
	public void clickCancel(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene=new Scene(root);
		stage.setResizable(true);
		stage.setScene(scene);
		stage.show();
	}
}
