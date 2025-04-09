package Loginpage;

	import java.util.List;
import java.util.Optional;

import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.Event;
	import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
    import javafx.scene.control.Menu;
    import javafx.scene.control.MenuBar;
    import javafx.scene.control.MenuItem;
    import javafx.scene.control.TabPane;
    import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
    import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

	public class DisplayHome extends Application {

		@Override
		public void start(Stage primaryStage) throws Exception {
			Label lblTitle,lblTitle2 ;
			Button btnDisplay, btnClose,btnUpdate,btnDelete;
			TableView tblTable;

			//
			
			// FlowPane pane=new FlowPane();
			Pane pane = new Pane();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setWidth(1580);
			primaryStage.setHeight(840);

			//Main heading of page
			 VBox Top = new VBox();
		        Top.setStyle("-fx-background-color: black;");
		        Top.setLayoutX(0);
		        Top.setLayoutY(0);
		        Top.setPrefWidth(1580);
		        Top.setPrefHeight(50);
		        
		        //Font for title
			Font font = new Font("Arial", 28);
			lblTitle=new Label("Hotel Management System");
			lblTitle.setFont(font);
			lblTitle.relocate(57, 0);
			lblTitle.setTextFill(Color.BLUE); 
			
			
			
			btnDisplay = new Button("Display");
			btnDisplay.relocate(400, 730);
			btnDisplay.setStyle("-fx-background-color: Green; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");

			btnClose = new Button("Exit");
			btnClose.relocate(600, 730);
			btnClose.setStyle("-fx-background-color: Red; -fx-text-fill: white; -fx-font-size: 16px;-fx-background-radius:12;");
		
			btnUpdate = new Button("Update");
			btnUpdate.relocate(800, 730);
			btnUpdate.setStyle("-fx-background-color:Blue; -fx-text-fill: white;-fx-font-size: 16px;-fx-background-radius:12;");
			
			Button btnDelete1 = new Button("Delete");
			btnDelete1.relocate(1000, 730);
			btnDelete1.setStyle("-fx-background-color: darkred; -fx-text-fill: white; -fx-font-size: 16px; -fx-background-radius: 12;");

			//Font For Subtitle
			Font font1 = new Font("Arial", 23);
			lblTitle2=new Label("Staff and room status");
			lblTitle2.setFont(font1);
			lblTitle2.relocate(57, 80);
			

	 		       //creating menu
			        Menu menu = new Menu("Menu"); 
			        menu.setStyle("-fx-font-size:16");
			        MenuItem menu1 = new MenuItem("ManageStaff"); 
			        MenuItem menu2 = new MenuItem("Invontary Management"); 
			        MenuItem export = new MenuItem("Export to PDF");
			        menu.getItems().add(export);
			        
			
			        menu.getItems().add(menu1); 
			        menu.getItems().add(menu2); 
			  
			        // creating  a menubar 
			        MenuBar menubar = new MenuBar();  
			        menubar.getMenus().add(menu);
			        menubar.setStyle("-fx-background-color:White; -fx-padding: 5px;");
			        menubar.setPrefHeight(30);
			        // creating a vbox
			        VBox vb = new VBox(menubar);
		          Scene scene1 = new Scene(vb); 
		          vb.relocate(450,0); 

		        //  ManageStaff menu item
//		        menu1.setOnAction(new EventHandler<ActionEvent>() {
//		            @Override
//		            public void handle(ActionEvent actionEvent) {
//		                Stage manageStaffStage = new Stage();
//		                manageStaffStage.setTitle("Manage Staff");
//		                Pane manageStaffPane = new Pane();
//		                Scene manageStaffScene = new Scene(manageStaffPane, 400, 300);
//
//		                Label lblManageStaff = new Label("Manage Staff Screen");
//		                lblManageStaff.relocate(120, 30);
//		                manageStaffPane.getChildren().add(lblManageStaff);
//		                // display of manageStaff
//		                manageStaffStage.setScene(manageStaffScene);
//		                manageStaffStage.show();
//		            }
//		        });

		        menu2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	primaryStage.close();
		                // This Display inventory management
		                Stage inventory = new Stage();
		                try {
		                    new AmenitiesRequired().start(inventory);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        menu1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		            	primaryStage.close();
		                // This Display ManageStaff
		                Stage inventoryStage = new Stage();
		                try {
		                    new ManageStaff().start(inventoryStage);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        
		        
		     // Top Section - Title and Menu (with black background)
		        VBox topBox = new VBox(10);
		        topBox.setAlignment(Pos.CENTER);
		        topBox.setStyle("-fx-background-color: black; -fx-padding: 15px;");

			 // TableDetials
			tblTable = new TableView();
			tblTable.setPrefHeight(600);
			tblTable.setPrefWidth(1440);
			tblTable.relocate(60, 110);

			// Columns
			TableColumn<AdminUser,Integer> cstaff_id = new TableColumn<>("StaffID");
			TableColumn<AdminUser,Integer> cavaiablestatus = new TableColumn<>("Avaiable Status");
			TableColumn<AdminUser,Integer> cRoomNO = new TableColumn<>("RoomNO");
			TableColumn<AdminUser,Integer> cRoomavaiability = new TableColumn<>("Room Availability");
			TableColumn<AdminUser,Integer> cCleaningStatus = new TableColumn<>("Cleaning Status");
			
			
			// Add on table
			tblTable.getColumns().add(cstaff_id);
			tblTable.getColumns().add(cavaiablestatus);
			tblTable.getColumns().add(cRoomNO);
			tblTable.getColumns().add(cRoomavaiability);
			tblTable.getColumns().add(cCleaningStatus);

			// Binding column with instance variable of class
			cstaff_id.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
			cavaiablestatus.setCellValueFactory(new PropertyValueFactory<>("AvaiableStatus"));
			cRoomNO.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			cRoomavaiability.setCellValueFactory(new PropertyValueFactory<>("Roomavaiablity"));
			cCleaningStatus.setCellValueFactory(new PropertyValueFactory<>("CleaningStatus"));
			
			//set Font size of details inside table
			tblTable.setStyle("-fx-font-size: 14px;"); 
			
			//adjusting columns size
			cstaff_id.setPrefWidth(290);
	        cavaiablestatus.setPrefWidth(290);
	        cRoomNO.setPrefWidth(290);
	        cRoomavaiability.setPrefWidth(290);
	        cCleaningStatus.setPrefWidth(290);


	
			btnDisplay.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {

					List<AdminUser> users = new AdminCRUD().all();
					// clear All
					tblTable.getItems().clear();
					// Add rows
					for (AdminUser user : users) {
						tblTable.getItems().add(user);
					}

				}
			});
			
			
			//update 
			 btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                // This will display inventory management
		                Stage Update = new Stage();
		                try {
		                    new AdminHome().start(Update);
		                } catch (Exception e) {
		                    e.printStackTrace();           
		                    }
		            }
		        });
			
			
			//action close button
			btnClose.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					primaryStage.close();
					  

				}
			});
			
			btnDelete1.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			   public void handle(ActionEvent Event) {
			        AdminUser deleterow = (AdminUser) tblTable.getSelectionModel().getSelectedItem();
			        if (deleterow != null) {
			            // Confirmation Alert
			            Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
			            ale.setTitle("Confirm Delete");
			            ale.setHeaderText("Do you want to delete this record?");

			            Optional<ButtonType> result = ale.showAndWait();
			 
			            
			            //delete form database
			            if (result.isPresent() && result.get() == ButtonType.OK) {
			                 boolean success = new AdminCRUD().delete(deleterow.getStaffID());
			                if (success) {
			                	//Remove data from table
			                }
			                     tblTable.getItems().remove(deleterow);
			            }
			        } else {
			            //In case the row is not select
			            Alert alart = new Alert(Alert.AlertType.WARNING);
			             alart.setTitle("Delete");
			            alart.setHeaderText(null);
			            alart.setContentText("Please choose row first");
			             alart.showAndWait();
			       }
	    }
			});

			
			pane.getChildren().add(Top);
			pane.getChildren().addAll(lblTitle, btnDisplay, btnClose,btnUpdate,btnDelete1,lblTitle2);
			pane.getChildren().add(tblTable);
			pane.getChildren().add(vb);
		
			primaryStage.show();
			primaryStage.setScene(scene);

		}

		public static void main(String[] args) {
			launch(args);
		}
	}

