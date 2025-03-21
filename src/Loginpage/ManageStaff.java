package Loginpage;

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

public class ManageStaff extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblStaffID, lblAssignTask, lblMessage;
		TextField txtStaffID, txtAssignTask;
		Button btnSave,btnSearch,btnClose;
		
		lblTitle=new Label("Manage Staff");
		lblTitle.relocate(20, 0);
		Font font1 = new Font("Arial", 20);
		lblTitle.setFont(font1);
		
		lblStaffID = new Label("Staff ID");
		lblStaffID.relocate(50, 40);
        lblStaffID.setStyle("-fx-font-size:15");
		
		txtStaffID = new TextField();
		txtStaffID.relocate(50,80);
		
		lblAssignTask=new Label("Avaiable Status");
		lblAssignTask.relocate(50,120);
        lblAssignTask.setStyle("-fx-font-size:15");
		
		txtAssignTask= new TextField();
		txtAssignTask.relocate(50,160);
		
		lblMessage=new Label("Message");
		lblMessage. relocate(50,200);
		lblMessage.setStyle("-fx-font-size:9");
		
		btnSave=new Button("Save");
		btnSave.relocate(50, 250);
		btnSave.setStyle("-fx-background-color: Green; -fx-text-fill: white;");
		btnSearch=new Button("Search");
		btnSearch.relocate(150, 250);
		btnSearch.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		
		
		btnClose=new Button("Close");
		btnClose.relocate(250, 250);
		btnClose.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		
		
		
		
		//Insert
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				StaffUser user=new StaffUser();
				user.setStaffID(Integer.parseInt(txtStaffID.getText()));
				user.setAssignTask(txtAssignTask.getText());
				boolean result = new StaffCRUD().insert(user);
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
						StaffUser user = new StaffCRUD().search(staffID);
						if(user.getStaffID()>0) {
							//Record found and display
							txtAssignTask.setText(user.getAssignTask());
							lblMessage.setText("Record found !");
						}
						else {
							txtAssignTask.setText("");
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
		primaryStage.setHeight(350);
		

		pane.getChildren().add(lblTitle); //Pane
		pane.getChildren().add(lblStaffID);
		pane.getChildren().add(txtStaffID); 
		pane.getChildren().addAll(lblAssignTask, txtAssignTask);
		pane.getChildren().addAll(btnSave);
		pane.getChildren().addAll(btnSearch);
		pane.getChildren().addAll(btnClose);
		pane.getChildren().add(lblMessage);
		
		
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	

}
