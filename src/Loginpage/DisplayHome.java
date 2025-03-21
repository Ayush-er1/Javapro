package Loginpage;

	import java.util.List;

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
    import javafx.scene.text.Font;
	import javafx.stage.Stage;

	public class DisplayHome extends Application {

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
			 
			btnUpdate = new Button("Update");
			btnUpdate.relocate(350, 300);
			
	 			     
			        Menu menu = new Menu("Menu"); 
			        MenuItem menu1 = new MenuItem("ManageStaff"); 
			        MenuItem menu2 = new MenuItem("Invontary Management"); 
			
			        menu.getItems().add(menu1); 
			        menu.getItems().add(menu2); 
			  
			        // creating  a menubar 
			        MenuBar menubar = new MenuBar();  
			        menubar.getMenus().add(menu); 
			        // creating a vxbox 
			        VBox vb = new VBox(menubar);
		        Scene scene1 = new Scene(vb); 
		        
		        vb.relocate(60,5); 

		        //  ManageStaff menu item
		        menu1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                Stage manageStaffStage = new Stage();
		                manageStaffStage.setTitle("Manage Staff");
		                Pane manageStaffPane = new Pane();
		                Scene manageStaffScene = new Scene(manageStaffPane, 400, 300);

		                Label lblManageStaff = new Label("Manage Staff Screen");
		                lblManageStaff.relocate(120, 30);
		                manageStaffPane.getChildren().add(lblManageStaff);
		                // display of manageStaff
		                manageStaffStage.setScene(manageStaffScene);
		                manageStaffStage.show();
		            }
		        });

		        menu2.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                // This Display inventory management
		                Stage inventoryStage = new Stage();
		                try {
		                    new AmenitiesRequired().start(inventoryStage);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
		        menu1.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent actionEvent) {
		                // This Display ManageStaff
		                Stage inventoryStage = new Stage();
		                try {
		                    new ManageStaff().start(inventoryStage);
		                } catch (Exception e) {
		                    e.printStackTrace();
		                }
		            }
		        });
			 
			 // TableView
			tblUsers = new TableView();
			tblUsers.setPrefHeight(250);
			tblUsers.setPrefWidth(500);
			tblUsers.relocate(60, 30);

			// Columns
			TableColumn<AdminUser, Integer> colstaff_id = new TableColumn<>("StaffID");
			TableColumn<AdminUser, Integer> colavaiablestatus = new TableColumn<>("AvaiableStatus");
			TableColumn<AdminUser, Integer> colRoomNO = new TableColumn<>("RoomNO");
			TableColumn<AdminUser, Integer> colRoomavaiability = new TableColumn<>("Roomavaiability");
			TableColumn<AdminUser, Integer> colCleaningStatus = new TableColumn<>("CleaningStatus");
			
			//adjusting columns size
			colstaff_id.setPrefWidth(100);
	        colavaiablestatus.setPrefWidth(100);
	        colRoomNO.setPrefWidth(100);
	        colRoomavaiability.setPrefWidth(100);
	        colCleaningStatus.setPrefWidth(100);

			
			// Add on table
			tblUsers.getColumns().add(colstaff_id);
			tblUsers.getColumns().add(colavaiablestatus);
			tblUsers.getColumns().add(colRoomNO);
			tblUsers.getColumns().add(colRoomavaiability);
			tblUsers.getColumns().add(colCleaningStatus);

			// Binding column with instance variable of class
			colstaff_id.setCellValueFactory(new PropertyValueFactory<>("StaffID"));
			colavaiablestatus.setCellValueFactory(new PropertyValueFactory<>("AvaiableStatus"));
			colRoomNO.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
			colRoomavaiability.setCellValueFactory(new PropertyValueFactory<>("Roomavaiability"));
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

					List<AdminUser> users = new AdminCRUD().all();
					// clear All
					tblUsers.getItems().clear();
					// Add rows
					for (AdminUser user : users) {
						tblUsers.getItems().add(user);
					}

				}
			});
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
			
			
			

			btnClose.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent actionEvent) {
					primaryStage.close();
					  

				}
			});
			pane.getChildren().addAll(lblTitle, btnClear, btnDisplay, btnClose,btnUpdate);
			pane.getChildren().add(tblUsers);
			pane.getChildren().add(vb);

			primaryStage.show();
			primaryStage.setScene(scene);

		}

		public static void main(String[] args) {
			launch(args);
		}
	}

