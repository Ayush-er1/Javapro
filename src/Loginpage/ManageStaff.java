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

public class ManageStaff extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label lblTitle, lblStaffID, lblAssignTask, lblMessage;
		TextField txtStaffID, txtAssignTask;
		Button btnSave,btnSearch,btnClose;
		
		lblTitle=new Label("Manage Staff");
		lblTitle.relocate(700,180);
		Font font1 = new Font("Arial", 28);
		lblTitle.setFont(font1);
		
		lblStaffID = new Label("Staff ID");
		lblStaffID.relocate(630, 320);
        lblStaffID.setStyle("-fx-font-size:20;-fx-font-weight: bold;");
		
		txtStaffID = new TextField();
		txtStaffID.relocate(750,320);
		
		lblAssignTask=new Label("Assign Task");
		lblAssignTask.relocate(630,380);
        lblAssignTask.setStyle("-fx-font-size:20;-fx-font-weight: bold;");
		
		txtAssignTask= new TextField();
		txtAssignTask.relocate(750,380);
		
		lblMessage=new Label("Message");
		lblMessage. relocate(600,580);
		lblMessage.setStyle("-fx-font-size:14");
		
		btnSave=new Button("Save");
		btnSave.relocate(650, 480);
		btnSave.setPrefSize(60, 35);
		btnSave.setStyle("-fx-background-color: Green; -fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius:12;");
		
		btnSearch=new Button("Search");
		btnSearch.relocate(770, 480);
		btnSearch.setPrefSize(60, 35);
		btnSearch.setStyle("-fx-background-color: blue;-fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius: 12;");
		
		
		btnClose=new Button("Close");
		btnClose.relocate(890, 480);
		btnClose.setPrefSize(60, 35);
		btnClose.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius: 12;");
		
		
		
		
		//Insert
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				StaffUser user=new StaffUser();
				user.setStaffID(Integer.parseInt(txtStaffID.getText()));
				user.setAssignTask(txtAssignTask.getText());
				boolean result = new StaffCRUD().insert(user);
				if(result==true) {
					lblMessage.setText("Data insert Successfully");
					primaryStage.close();
	                // This will display Admin Home page
	                Stage Update = new Stage();
	                try {
	                    new DisplayHome().start(Update);
	                } catch (Exception e) {
	                    e.printStackTrace();           
	                    }
				}
				else {
					lblMessage.setText("Error to insert Data");
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
				// Rectangle box to group controls
				Rectangle staffbox = new Rectangle();
				staffbox.relocate(600, 250);
				staffbox.setArcWidth(20);
				staffbox.setArcHeight(20);
				staffbox.setWidth(400);
				staffbox.setHeight(300);
				staffbox.setFill(Color.LIGHTGRAY); 
				staffbox.setStroke(Color.DARKGRAY); 
				staffbox.setStrokeWidth(2);
		
		
		
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(1580);
		primaryStage.setHeight(840);
		

		pane.getChildren().add(lblTitle); //Pane
		pane.getChildren().add(staffbox);
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
