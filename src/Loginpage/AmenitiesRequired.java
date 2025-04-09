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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AmenitiesRequired extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblRoomNo, lblSoap, lblToothpaste, lblToothbrush, lblShampoo,lblMessage;
		TextField txtToothpaste, txtRoomNo, txtSoap, txtToothbrush, txtShampoo;
		Button btnTurnOver,btnSearch,btnClose;
		
		lblTitle=new Label("Inventory Management");
		lblTitle.relocate(100,50);
		Font font1 = new Font("Arial",22);
		lblTitle.setFont(font1);
		
		lblRoomNo = new Label("Room  NO");
		lblRoomNo.relocate(70, 140);
        lblRoomNo.setStyle("-fx-font-size:14");
		
		txtRoomNo = new TextField();
		txtRoomNo.relocate(210,140);
		
		lblSoap=new Label("Soap Quantity");
		lblSoap.relocate(70,190);
        lblSoap.setStyle("-fx-font-size:14");
		
		txtSoap= new TextField();
		txtSoap.relocate(210,190);
		
		lblToothpaste=new Label("Toothpast Quantity");
		lblToothpaste.relocate(70,240);
        lblToothpaste.setStyle("-fx-font-size:14");
		
		txtToothpaste=new TextField();
		txtToothpaste.relocate(210,240);
		
		lblToothbrush=new Label("Toothbrush Quantity");
		lblToothbrush.relocate(70,290);
        lblToothbrush.setStyle("-fx-font-size:14");
		
		txtToothbrush=new TextField();
		txtToothbrush.relocate(210,290);
		
		lblShampoo = new Label("Shampoo Quantity");
		lblShampoo.relocate(70,340);
        lblShampoo.setStyle("-fx-font-size:14");
		
		txtShampoo=new TextField();
		txtShampoo.relocate(210,340);
		
		
		
		btnTurnOver=new Button("Save");
		btnTurnOver.relocate(90, 460);
		btnTurnOver.setStyle("-fx-background-color:green; -fx-text-fill: white;-fx-font-size:13");
		
		btnSearch=new Button("Search");
		btnSearch.relocate(200, 460);
		btnSearch.setStyle("-fx-background-color: blue; -fx-text-fill: white;-fx-font-size:13");
	
		
		btnClose=new Button("Exit");
		btnClose.relocate(310, 460);
		btnClose.setStyle("-fx-background-color: Red; -fx-text-fill: white;-fx-font-size:13");
		
		lblMessage = new Label("Message");
		lblMessage.relocate(70, 530);
		 lblMessage.setStyle("-fx-font-size:14");
		
		
		//Insert data
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
					lblMessage.setText("Data Insert sucessful");
					 primaryStage.close();
				}
				
				else {
					lblMessage.setText("Error to insert Data");
					lblMessage.setStyle("-fx-text-fill: RED;");
				}
				
			}
		});

		
		//Search data
				btnSearch.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						int roomNo = Integer.parseInt(txtRoomNo.getText());
						AmenitiesUser user = new UserCRUD().search(roomNo);
						if(user.getRoomNo()>0) {
							//all insert record found 
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
							lblMessage.setStyle("-fx-text-fill: RED;");
						}
					}
				});
				
				btnClose.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						primaryStage.close();
					}
				});
		
				
				Rectangle amenities = new Rectangle();
				amenities.setArcWidth(20);
				amenities.setArcHeight(20);
				amenities.setWidth(330);
				amenities.setHeight(330);
				amenities.relocate(60, 110);
				amenities.setFill(Color.WHITE); 
				amenities.setStroke(Color.DARKGRAY); 
				amenities.setStrokeWidth(1);
		
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		 primaryStage.setWidth(450);
		primaryStage.setHeight(600);
		 pane.setStyle("-fx-background-color:#B0E0E6;");

		pane.getChildren().add(lblTitle); 
		pane.getChildren().add(amenities);
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





