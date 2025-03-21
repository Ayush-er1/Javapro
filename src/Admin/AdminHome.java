package Admin;

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

public class AdminHome extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblStaffID, lblAvaiableStatus, lblRoomNo, lblRoomAvaiability, lblCleaningstatus,lblMessage;
		TextField txtStaffID, txtAvaiableStatus, txtRoomNo, txtRoomAvaiability, txtCleaningstatus;
		Button btnSave,btnSearch,btnClose;
		
		lblTitle=new Label("Home");
		lblTitle.relocate(50, 0);
		Font font1 = new Font("Arial", 20);
		lblTitle.setFont(font1);
		
		lblStaffID = new Label("StaffID");
		lblStaffID.relocate(50, 40);
        lblStaffID.setStyle("-fx-font-size:14");
		
		txtStaffID = new TextField();
		txtStaffID.relocate(50,70);
		
		lblAvaiableStatus=new Label("Avaiable Status");
		lblAvaiableStatus.relocate(50,100);
        lblAvaiableStatus.setStyle("-fx-font-size:14");
		
		txtAvaiableStatus= new TextField();
		txtAvaiableStatus.relocate(50,130);
		
		lblRoomNo=new Label("RoomNo");
		lblRoomNo.relocate(50,160);
        lblRoomNo.setStyle("-fx-font-size:14");
		
		txtRoomNo=new TextField();
		txtRoomNo.relocate(50,190);
		
		lblRoomAvaiability=new Label("Room Avaiability");
		lblRoomAvaiability.relocate(50,220);
        lblRoomAvaiability.setStyle("-fx-font-size:14");
		
		txtRoomAvaiability=new TextField();
		txtRoomAvaiability.relocate(50,250);
		
		lblCleaningstatus = new Label("Cleaning Status");
		lblCleaningstatus.relocate(50,280);
        lblCleaningstatus.setStyle("-fx-font-size:14");
		
		txtCleaningstatus=new TextField();
		txtCleaningstatus.relocate(50,310);
		
		
		
		btnSave=new Button("Save");
		btnSave.relocate(50, 400);
		btnSave.setStyle("-fx-background-color: Green; -fx-text-fill: white;");
		btnSearch=new Button("Search");
		btnSearch.relocate(150, 400);
		btnSearch.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		
		
		btnClose=new Button("Close");
		btnClose.relocate(250, 400);
		btnClose.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		
		lblMessage = new Label("Message");
		lblMessage.relocate(50, 430);
		 lblMessage.setStyle("-fx-font-size:14");
		
		
		//Insert
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				AdminUser user=new AdminUser();
		        user.setStaffID(Integer.parseInt(txtStaffID.getText()));
		        user.setAvaiableStatus(txtAvaiableStatus.getText());
		        user.setRoomNo(Integer.parseInt(txtRoomNo.getText()));
		        user.setRoomavaiability(txtRoomAvaiability.getText()); // 
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
							txtRoomNo.setText(String.valueOf(user.getRoomNo()));
			                txtRoomAvaiability.setText(user.getRoomavaiability());
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
		
		
		
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(350);
		primaryStage.setHeight(500);
		

		pane.getChildren().add(lblTitle); //Pane
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


