package Loginpage;



	
import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
    import javafx.scene.layout.GridPane;
    import javafx.scene.text.Font;
    import javafx.stage.Stage;


	public class LoginPage extends Application {

		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			 GridPane pane=new GridPane();
	     
			 
			Scene scene=new Scene(pane);
			 primaryStage.setScene(scene);
			 pane.setHgap(8);
			 pane.setVgap(8);
			 pane.setStyle("-fx-background-color:#FFF;");
			 
			
			primaryStage.setTitle("Hotel Management System");
			primaryStage.setWidth(450);
			primaryStage.setHeight(320);
		    primaryStage.setAlwaysOnTop(false);
		    
		    

	        Label lblTitle,lblUserID,lblPassword,lblMessage;
	        TextField txtUser;
	        PasswordField txtPassword;
	        Button btnLogout,btnLogin;
	        
	        lblTitle=new Label("User Login Window");
	        lblTitle.setStyle("-fx-font-size:16");
	        
	        Font font1=new Font("Courier New",30);
	        lblTitle.setFont(font1);
	        
	        
	        lblUserID=new Label("User Id");
	        lblUserID.setStyle("-fx-font-size:14" );
	        lblPassword=new Label("Password");
	        lblPassword.setStyle("-fx-font-size:14");
	        lblMessage=new Label("Error Message");
	        Button btnLogin1=new Button("Login");
	        Button btnLogout1=new Button("Logout");
	        
	        
	        
	        txtUser=new TextField();
	        txtPassword=new PasswordField();
	        
	        
	     // Login Button Action
	           btnLogin1.setOnAction(e -> {
	            String username = txtUser.getText();
	            String password = txtPassword.getText();

	            if (LoginpageDatabase.validateUser(username, password)) {
	                lblMessage.setText("Login Successful!");
	                lblMessage.setStyle("-fx-text-fill: green;");
	                // Open new window on success
	                try {
						new DisplayHome().start(new Stage());
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	                // Close th e present window
	               } else {
	                lblMessage.setText("Wrong password");
	                lblMessage.setStyle("-fx-text-fill: red;");
	               }
	        });
	        btnLogout1=new Button("Logout");
	        btnLogout1.setOnAction(e -> primaryStage.close());
	        
	       pane.relocate(20, 20);
	        
	        
	        btnLogin1.setStyle("-fx-background-color: Green; -fx-text-fill: white;");

	        btnLogout1.setStyle("-fx-background-color: red; -fx-text-fill: white;");
	       
	        
	        pane.add(lblTitle,1 ,0);
			pane.add(lblUserID ,1,2);
			pane.add(txtUser,2,2);
			pane.add(lblPassword,1,4);
			pane.add(txtPassword,2,4);
			pane.add(btnLogin1,2,10);
			pane.add(btnLogout1,3,10);
			pane.add(lblMessage,1,14);
			
			

		   
	       
	        primaryStage.show();
	}

	public static void main(String[]args) {
	launch(args);
	}
		}

