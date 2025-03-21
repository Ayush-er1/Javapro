package Staff;


	import java.util.List;

import Loginpage.AdminHome;
import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.Event;
	import javafx.event.EventHandler;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
    import javafx.scene.control.Menu;
    import javafx.scene.control.MenuBar;
    import javafx.scene.control.MenuItem;
    import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
	import javafx.scene.layout.Pane;
    import javafx.scene.text.Font;
	import javafx.stage.Stage;

	public class StaffFront extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			Label lblTitle;
			Button btnDisplay, btnClear, btnClose,btnUpdate;
			TableView tblUsers;

			// FlowPane pane=new FlowPane();
			Pane pane = new Pane();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setWidth(600);
			primaryStage.setHeight(375);

			lblTitle = new Label("Home");
			lblTitle.relocate(270, 0);
			Font font = new Font("Arial", 20);
			lblTitle.setFont(font);

			btnClear = new Button("Clear All");
			btnClear.relocate(50, 300);

			btnDisplay = new Button("Display All");
			btnDisplay.relocate(150, 300);

			btnClose = new Button("Close");
			btnClose.relocate(250, 300);
			 
			btnUpdate = new Button("Inventory");
			btnUpdate.relocate(350, 300);
			
	 			  
			 // TableView
			tblUsers = new TableView();
			tblUsers.setPrefHeight(250);
			tblUsers.setPrefWidth(500);
			tblUsers.relocate(60, 30);

			// Columns
			TableColumn<SpageUser, Integer> colstaff_id = new TableColumn<>("StaffID");
			TableColumn<SpageUser, Integer> colassignedtask = new TableColumn<>("Assigned Task");
			TableColumn<SpageUser, Integer> colRoomNO = new TableColumn<>("RoomNO");
			TableColumn<SpageUser, Integer> colRoomavaiability = new TableColumn<>("Roomavaiability");
			TableColumn<SpageUser, Integer> colCleaningStatus = new TableColumn<>("CleaningStatus");
			
			//adjusting columns size
			colstaff_id.setPrefWidth(100);
	        colassignedtask.setPrefWidth(100);
	        colRoomNO.setPrefWidth(100);
	        colRoomavaiability.setPrefWidth(100);
	        colCleaningStatus.setPrefWidth(100);

			
			// Add on table
			tblUsers.getColumns().add(colstaff_id);
			tblUsers.getColumns().add(colassignedtask);
			tblUsers.getColumns().add(colRoomNO);
			tblUsers.getColumns().add(colRoomavaiability);
			tblUsers.getColumns().add(colCleaningStatus);

			// Binding column with instance variable of class
			colstaff_id.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
			colassignedtask.setCellValueFactory(new PropertyValueFactory<>("AssignedTask"));
			colRoomNO.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			colRoomavaiability.setCellValueFactory(new PropertyValueFactory<>("Room avaiability"));
			colCleaningStatus.setCellValueFactory(new PropertyValueFactory<>("CleaningStatus"));

			btnClear.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent actionEvent) {
					tblUsers.getItems().clear();

				}
			});

			btnDisplay.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					List<SpageUser> users = new SpageCRUD().all();
					// clear All
					tblUsers.getItems().clear();
					// Add rows
					for (SpageUser user : users) {
						tblUsers.getItems().add(user);
					}

				}
			});
			btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                // This Display inventory management
		                Stage Update = new Stage();
		                try {
		                    new AdminHome().start(Update);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
			

			btnClose.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					primaryStage.close();
					  

				}
			});

			pane.getChildren().addAll(lblTitle, btnClear, btnDisplay, btnClose,btnUpdate);
			pane.getChildren().add(tblUsers);
			

			primaryStage.show();
			primaryStage.setScene(scene);

		}

		public static void main(String[] args) {
			launch(args);
		}
	}



