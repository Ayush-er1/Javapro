package Staff;


	import java.util.List;

import Loginpage.AdminHome;
import Loginpage.AmenitiesRequired;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
			primaryStage.setWidth(1580);
			primaryStage.setHeight(840);
//adjusting nav bar
			 VBox Hea = new VBox();
		        Hea.setStyle("-fx-background-color: black;");
		        Hea.setLayoutX(0);
		        Hea.setLayoutY(0);
		        Hea.setPrefWidth(1580);
		        Hea.setPrefHeight(50);
		        
		        //Title
			lblTitle = new Label("Assign Task and room status");
			Font font = new Font("Arial", 27);
			lblTitle.setFont(font);
			lblTitle.relocate(57, 0);
			lblTitle.setTextFill(Color.WHITE); 

			btnClear = new Button("Clear All");
			btnClear.relocate(400, 730);
			btnClear.setStyle("-fx-background-color: Gray; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");

			btnDisplay = new Button("Display All");
			btnDisplay.relocate(600, 730);
			btnDisplay.setStyle("-fx-background-color: Green; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");

			btnClose = new Button("Exit");
			btnClose.relocate(800, 730);
			btnClose.setStyle("-fx-background-color: Red; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");
			
			btnUpdate = new Button("Inventory");
			btnUpdate.relocate(1000, 730);
			btnUpdate.setStyle("-fx-background-color: Blue; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");
	 			  
			 // TableView
			tblUsers = new TableView();
			tblUsers.setPrefHeight(600);
			tblUsers.setPrefWidth(1440);
			tblUsers.relocate(60, 90);

			// All Columns in the table
			TableColumn<SpageUser, Integer> Astaff_id = new TableColumn<>("Staff ID");
			TableColumn<SpageUser, String> yassignedtask = new TableColumn<>("Assigned Task");
			TableColumn<SpageUser, String> uRoomNO = new TableColumn<>("RoomNO");
			TableColumn<SpageUser, String> sRoomavaiability = new TableColumn<>("Room Avaiability");
			TableColumn<SpageUser, String> hCleaningStatus = new TableColumn<>("Cleaning Status");
			
			//adjusting columns size
			Astaff_id.setPrefWidth(290);
	        yassignedtask.setPrefWidth(290);
	        uRoomNO.setPrefWidth(290);
	        sRoomavaiability.setPrefWidth(290);
	       hCleaningStatus.setPrefWidth(290);

			
			// Add on table
			tblUsers.getColumns().add(Astaff_id);
			tblUsers.getColumns().add(yassignedtask);
			tblUsers.getColumns().add(uRoomNO);
			tblUsers.getColumns().add(sRoomavaiability);
			tblUsers.getColumns().add(hCleaningStatus);
			tblUsers.setStyle("-fx-font-size: 14px;"); 
			
			// connecting column with field
			Astaff_id.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
			yassignedtask.setCellValueFactory(new PropertyValueFactory<>("AssignedTask"));
			
			uRoomNO.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			sRoomavaiability.setCellValueFactory(new PropertyValueFactory<>("Roomavaiability"));
			hCleaningStatus.setCellValueFactory(new PropertyValueFactory<>("CleaningStatus"));

			
			//Action clear button
			btnClear.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					tblUsers.getItems().clear();

				}
			});
			
			
			//display button in action
			btnDisplay.setOnAction(new EventHandler<ActionEvent>() {
				@Override
			    public void handle(ActionEvent actionEvent) {
			        List<SpageUser> users = new SpageCRUD().all();
			        tblUsers.getItems().clear();
			        tblUsers.getItems().addAll(users);
			    }
			});

			//Updata button in action
			btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                // This Display inventory management
		                Stage Update = new Stage();
		                try {
		                    new AmenitiesRequired().start(Update);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
			
		
//action close buttons
			btnClose.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					primaryStage.close();
					  

				}
			});
            
			//pane
			pane.getChildren().add(Hea);
			pane.getChildren().addAll(lblTitle, btnClear, btnDisplay, btnClose,btnUpdate);
			pane.getChildren().add(tblUsers);
			

			primaryStage.show();
			primaryStage.setScene(scene);

		}

		public static void main(String[] args) {
			launch(args);
		}
	}

