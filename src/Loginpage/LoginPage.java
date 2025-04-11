package Loginpage;

	
import Staff.StaffFront;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.CheckBox;
	import javafx.scene.control.ChoiceBox;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
    import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
    import javafx.stage.Stage;
    import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
    import javafx.scene.effect.DropShadow;


	public class LoginPage extends Application {

		
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			 GridPane pane=new GridPane();
	     
			 //Adjusting the nav bar
			Scene scene=new Scene(pane);
			 primaryStage.setScene(scene);
			 pane.setAlignment(Pos.CENTER);
			 pane.setHgap(25);
			 pane.setVgap(15);
			 pane.setPadding(new Insets(40,40,40,40));
			 pane.setStyle("-fx-background-color:#ADD8E6;");
			 
			 
			//Adjusting display
			primaryStage.setTitle("Hotel Management System");
			primaryStage.setWidth(1580);
			primaryStage.setHeight(840);
		    primaryStage.setAlwaysOnTop(false);
		    
		    
            //Declare
	        Label lblTitle,lblUserID,lblPassword,lblMessage;
	        TextField txtUser;
	        PasswordField txtPassword;
	        Button btnLogout,btnLogin ;
	        
	        //Title
	        lblTitle=new Label("User Login");
	        Font font1=new Font("Constantia",30);
	        lblTitle.setFont(font1);
	        Font font2=new Font("Times New Roman",20);
	        
	      
	        lblUserID=new Label("User Id");
	        lblUserID.setFont(font2);
	        lblPassword=new Label("Password");
	        lblPassword.setFont(font2);
	        lblMessage=new Label("Message");
	        Font font3=new Font("Times New Roman",12);
	        lblMessage.setFont(font3);
	        
	        //Buttons
	        Button btnLogin1=new Button("Login");
	        Button btnLogout1=new Button("Logout");
	        
	        
	        
	        txtUser=new TextField();
	        txtUser.setStyle("-fx-pref-width: 150px; -fx-padding: 8px; -fx-font-size: 14px;");
	        txtPassword=new PasswordField();
	        txtPassword.setStyle("-fx-pref-width:150px;-fx-padding: 8px;");
	        
	        
	        
	     // Login Button Action
	           btnLogin1.setOnAction(e -> {
	        	   String userId = txtUser.getText().trim();
	               String password = txtPassword.getText().trim();

	               //if only enter userid or password
	               if (userId.isEmpty() || password.isEmpty()) {
	                   lblMessage.setText("Enter both UserId and password");
	                   lblMessage.setStyle("-fx-text-fill: red;");
	                   return;
	               }
	               String role = LoginpageDatabase.validateUser(userId, password);
	               
	               if (role != null) {
	                   lblMessage.setText("Login Successful!");
	                   lblMessage.setStyle("-fx-text-fill: green;");
	                   
	                   try {
	                       if ("admin".equals(role)) {
	                           new DisplayHome().start(new Stage());
	                       } else if ("staff".equals(role)) {
	                           new StaffFront().start(new Stage());
	                       }
	                       primaryStage.close();
	                   } catch (Exception ex) {
	                       lblMessage.setText("Error");
	                       lblMessage.setStyle("-fx-text-fill: red;");
	                       ex.printStackTrace();
	                   }
	                   
	                   //while entering wrong userid or password
	               } else {
	                   lblMessage.setText("Wrong UserId or password");
	                   lblMessage.setStyle("-fx-text-fill: red;");
	               }
	           });
	           
	           
	           //Logout Button in action
	        btnLogout1=new Button("Logout");
	        btnLogout1.setOnAction(e -> primaryStage.close());
	        
	       
	        //manage color and font size
	        btnLogin1.setStyle("-fx-background-color: Green;-fx-font-size: 13px; -fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius:11;");
	        btnLogout1.setStyle("-fx-background-color: Red;-fx-font-size: 13px; -fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius:11;");
	       
	     // Rectangle box
	        Rectangle loginBox = new Rectangle(450, 270);
	        loginBox.setArcWidth(20);
	        loginBox.setArcHeight(20);
	        loginBox.setFill(Color.web("#ffff"));
	        loginBox.setStroke(Color.LIGHTGRAY);
	        loginBox.setStrokeWidth(2);
	        loginBox.setEffect(new DropShadow(5, Color.GRAY));

	        //enter elements inside vbox
	        VBox disign = new VBox(21);
	        disign.setPadding(new Insets(20));
	        disign.setAlignment(Pos.CENTER);
	        disign.getChildren().addAll(
	            lblUserID, txtUser,
	            lblPassword, txtPassword,
	            new HBox(130, btnLogin1, btnLogout1)
	        );

	        // to combine rectange and layer
	        StackPane loginPane = new StackPane();
	        loginPane.getChildren().addAll(loginBox,disign);
	      
	        //locating all elements
	        pane.add(loginPane, 0, 2, 2, 6); 
	        pane.add(lblTitle,1 ,0);
			pane.add(lblMessage,1,13);
			
			
	       
	        primaryStage.show();
	}

	public static void main(String[]args) {
	launch(args);
	}
		}

