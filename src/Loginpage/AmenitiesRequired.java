package Loginpage;



import Amenities.AmenitiesUser;
import Amenities.UserCRUD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AmenitiesRequired extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblRoomNo, lblSoap, lblToothpaste, lblToothbrush, lblShampoo,lblMessage;
		TextField txtToothpaste, txtRoomNo, txtSoap, txtToothbrush, txtShampoo;
		Button btnTurnOver,btnSearch,btnClose;
		
		lblTitle=new Label("AMENITIES REQUIRED");
		lblTitle.relocate(50, 0);
		Font font1 = new Font("Arial", 18);
		lblTitle.setFont(font1);
		
		lblRoomNo = new Label("RoomNO");
		lblRoomNo.relocate(50, 40);
        lblRoomNo.setStyle("-fx-font-size:14");
		
		txtRoomNo = new TextField();
		txtRoomNo.relocate(50,70);
		
		lblSoap=new Label("Soap");
		lblSoap.relocate(50,100);
        lblSoap.setStyle("-fx-font-size:14");
		
		txtSoap= new TextField();
		txtSoap.relocate(50,130);
		
		lblToothpaste=new Label("Toothpast");
		lblToothpaste.relocate(50,160);
        lblToothpaste.setStyle("-fx-font-size:14");
		
		txtToothpaste=new TextField();
		txtToothpaste.relocate(50,190);
		
		lblToothbrush=new Label("Toothbrush");
		lblToothbrush.relocate(50,220);
        lblToothbrush.setStyle("-fx-font-size:14");
		
		txtToothbrush=new TextField();
		txtToothbrush.relocate(50,250);
		
		lblShampoo = new Label("Shampoo");
		lblShampoo.relocate(50,280);
        lblShampoo.setStyle("-fx-font-size:14");
		
		txtShampoo=new TextField();
		txtShampoo.relocate(50,310);
		
		
		
		btnTurnOver=new Button("Save");
		btnTurnOver.relocate(50, 400);
		
		btnSearch=new Button("Search");
		btnSearch.relocate(150, 400);
		
	
		
		btnClose=new Button("Close");
		btnClose.relocate(250, 400);
		
		lblMessage = new Label("Message");
		lblMessage.relocate(50, 430);
		 lblMessage.setStyle("-fx-font-size:14");
		
		
		//Insert
		btnTurnOver.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				AmenitiesUser user=new AmenitiesUser();
				user.setRoomNo(Integer.parseInt(txtRoomNo.getText()));
				user.setSoap(txtSoap.getText());
				user.setToothpaste(txtToothpaste.getText());
				user.setToothbrush(txtToothbrush.getText());
				user.setShampoo(txtShampoo.getText());
				boolean result = new UserCRUD().insert(user);
				if(result==true) {
					lblMessage.setText("Insert User Successfully");
				}
				else {
					lblMessage.setText("Error to insert User");
				}
			}
		});

		
		//Search
				btnSearch.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						int roomNo = Integer.parseInt(txtRoomNo.getText());
						AmenitiesUser user = new UserCRUD().search(roomNo);
						if(user.getRoomNo()>0) {
							//Record found and display
							txtSoap.setText(user.getSoap());
							txtToothpaste.setText(user.getToothpaste());
			                txtToothbrush.setText(user.getToothbrush());
			                txtShampoo.setText(user.getShampoo());
							lblMessage.setText("Record found !");
						}
						else {
							txtSoap.setText("");
							txtToothpaste.setText("");
                  			txtToothbrush.setText("");
							txtShampoo.setText("");

							lblMessage.setText("Record not found !");
						}
					}
				});
				
				btnClose.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						primaryStage.close();
					}
				});
		
		
		
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(350);
		primaryStage.setHeight(500);
		

		pane.getChildren().add(lblTitle); //Pane
		pane.getChildren().add(lblRoomNo);
		pane.getChildren().add(txtRoomNo); 
		pane.getChildren().addAll(lblSoap, txtSoap);
		pane.getChildren().addAll(lblToothpaste, txtToothpaste);
		pane.getChildren().addAll(lblToothbrush, txtToothbrush);
		pane.getChildren().addAll(lblShampoo, txtShampoo);
		pane.getChildren().addAll(btnTurnOver);
		pane.getChildren().addAll(btnSearch);
		pane.getChildren().addAll(btnClose);
		pane.getChildren().addAll(lblMessage);
		
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}





