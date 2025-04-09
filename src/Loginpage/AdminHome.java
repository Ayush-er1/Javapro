package Loginpage;



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

public class AdminHome extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblStaffID, lblAvaiableStatus, lblRoomNo, lblRoomAvaiability, lblCleaningstatus,lblMessage;
		TextField txtStaffID, txtAvaiableStatus, txtRoomNo, txtRoomAvaiability, txtCleaningstatus;
		Button btnSave,btnSearch,btnClose,btnDelete;
		
		lblTitle=new Label("Update Staff Record!");
		lblTitle.relocate(40, 0);
		Font font1 = new Font("Arial", 20);
		lblTitle.setFont(font1);
		
		lblStaffID = new Label("Staff ID");
		lblStaffID.relocate(50, 130);
		Font font2 = new Font("Times New Roman", 17);
		lblStaffID.setFont(font2);
		
		txtStaffID = new TextField();
		txtStaffID.relocate(50,160);
		
		lblAvaiableStatus=new Label("Avaiable Status");
		lblAvaiableStatus.relocate(300,130);
		lblAvaiableStatus.setFont(font2);
		
		txtAvaiableStatus= new TextField();
		txtAvaiableStatus.relocate(300,160);
		
		lblRoomNo=new Label("RoomNo");
		lblRoomNo.relocate(300,190);
		lblRoomNo.setFont(font2);
		
		txtRoomNo=new TextField();
		txtRoomNo.relocate(300,220);
		
		lblRoomAvaiability=new Label("Room Avaiability");
		lblRoomAvaiability.relocate(300,250);
		lblRoomAvaiability.setFont(font2);
		
		txtRoomAvaiability=new TextField();
		txtRoomAvaiability.relocate(300,280);
		
		lblCleaningstatus = new Label("Cleaning Status");
		lblCleaningstatus.relocate(300,310);
		lblCleaningstatus.setFont(font2);
		
		txtCleaningstatus=new TextField();
		txtCleaningstatus.relocate(300,340);
		
		
		
		btnSave=new Button("Save");
		btnSave.relocate(310, 400);
		btnSave.setStyle("-fx-background-color: Green; -fx-text-fill: white;-fx-font-size:13");
		
		btnSearch=new Button("Search");
		btnSearch.relocate(50, 210);
		btnSearch.setStyle("-fx-background-color: blue; -fx-text-fill: white;-fx-font-size:13");
		
		
		
//		btnDelete=new Button("Delete");
//		btnDelete.relocate(150, 400);
//		btnDelete.setStyle("-fx-background-color: gray; -fx-text-fill: white;");
		
		btnClose=new Button("Close");
		btnClose.relocate(400, 400);
		btnClose.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-font-size:13");
		
		lblMessage = new Label("Message");
		lblMessage.relocate(300, 480);
		 lblMessage.setStyle("-fx-font-size:14");
		
		
		//Insert
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				
				AdminUser user=new AdminUser();
				user.setStaffID(Integer.parseInt(txtStaffID.getText()));
				user.setAvaiableStatus(txtAvaiableStatus.getText());
				user.setRoomNo(txtRoomNo.getText());
				user.setRoomavaiablity(txtRoomAvaiability.getText());
				user.setCleaningStatus(txtCleaningstatus.getText());
				boolean result = new AdminCRUD().insert(user);
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
						int staffID = Integer.parseInt(txtStaffID.getText());
						AdminUser user = new AdminCRUD().search(staffID);
						if(user.getStaffID()>0) {
							//Record found and display
							txtAvaiableStatus.setText(user.getAvaiableStatus());
							 txtRoomNo.setText(user.getRoomNo());
			                txtRoomAvaiability.setText(user.getRoomavaiablity());
			                txtCleaningstatus.setText(user.getCleaningStatus());
							lblMessage.setText("Record found !");
						}
						else {
							txtAvaiableStatus.setText("");
							txtRoomNo.setText("");
                  			txtRoomAvaiability.setText("");
							txtCleaningstatus.setText("");

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
				
				//box for entities
				Rectangle other = new Rectangle();
				other.relocate(280, 110);
				other.setArcWidth(20);
				other.setArcHeight(20);
				other.setWidth(230);
				other.setHeight(350);
				other.setFill(Color.LIGHTGRAY); 
				other.setStroke(Color.DARKGRAY); 
				other.setStrokeWidth(2);
				
				//box for staffiD
				Rectangle staffId = new Rectangle();
				staffId.relocate(30, 110);
				staffId.setArcWidth(20);
				staffId.setArcHeight(20);
				staffId.setWidth(180);
				staffId.setHeight(150);
				staffId.setFill(Color.LIGHTGRAY); 
				staffId.setStroke(Color.DARKGRAY); 
				staffId.setStrokeWidth(2);
		
		
		
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(550);
		primaryStage.setHeight(600);
		pane.setStyle("-fx-background-color: #e6f3ff;");

		pane.getChildren().add(lblTitle); 
		pane.getChildren().add(staffId);
		pane.getChildren().add(other);
		pane.getChildren().add(lblStaffID);
		pane.getChildren().add(txtStaffID); 
		pane.getChildren().addAll(lblAvaiableStatus, txtAvaiableStatus);
		pane.getChildren().addAll(lblRoomNo, txtRoomNo);
		pane.getChildren().addAll(lblRoomAvaiability, txtRoomAvaiability);
		pane.getChildren().addAll(lblCleaningstatus, txtCleaningstatus);
		pane.getChildren().addAll(btnSave);
		pane.getChildren().addAll(btnSearch);
		pane.getChildren().addAll(btnClose);
		
		pane.getChildren().addAll(lblMessage);
		
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}


