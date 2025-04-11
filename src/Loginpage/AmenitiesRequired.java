package Loginpage;



import java.util.List;
import java.util.Optional;

import Amenities.AmenitiesUser;
import Amenities.UserCRUD;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AmenitiesRequired extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Declare
		Label lblTitle, lblRoomNo, lblSoap, lblToothpaste, lblToothbrush, lblShampoo,lblMessage,lblTitle2;
		TextField txtToothpaste, txtRoomNo, txtSoap, txtToothbrush, txtShampoo;
		Button btnTurnOver,btnSearch,btnClose,btnDisplay,btnDelete;
		TableView tblTable;
		ComboBox<String>btnchoice;
		
		//Title
		lblTitle=new Label("Inventory Management");
		lblTitle.relocate(650,40);
		Font font1 = new Font("Arial",24);
		lblTitle.setFont(font1);
		
		lblTitle2 = new Label("Insert Inventory Data");
		lblTitle2.relocate(280, 470);
        lblTitle2.setStyle("-fx-font-size:19");
		
		lblRoomNo = new Label("Room  NO");
		lblRoomNo.relocate(610, 130);
        lblRoomNo.setStyle("-fx-font-size:14");
		
		txtRoomNo = new TextField();
		txtRoomNo.relocate(740,130);
		
		lblSoap=new Label("Soap Quantity");
		lblSoap.relocate(610,180);
        lblSoap.setStyle("-fx-font-size:14");
		
		txtSoap= new TextField();
		txtSoap.relocate(740,180);
		
		lblToothpaste=new Label("Toothpast Quantity");
		lblToothpaste.relocate(610,230);
        lblToothpaste.setStyle("-fx-font-size:14");
		
		txtToothpaste=new TextField();
		txtToothpaste.relocate(740,230);
		
		lblToothbrush=new Label("Toothbrush Quantity");
		lblToothbrush.relocate(610,280);
        lblToothbrush.setStyle("-fx-font-size:14");
		
		txtToothbrush=new TextField();
		txtToothbrush.relocate(740,280);
		
		lblShampoo = new Label("Shampoo Quantity");
		lblShampoo.relocate(610,330);
        lblShampoo.setStyle("-fx-font-size:14");
		
		txtShampoo=new TextField();
		txtShampoo.relocate(740,330);
		
		
		
//		btnTurnOver=new Button("Save");
//		btnTurnOver.relocate(610, 420);
//		btnTurnOver.setStyle("-fx-background-color:green; -fx-text-fill: white;-fx-font-size:13");
//		
//		btnSearch=new Button("Search");
//		btnSearch.relocate(710, 420);
//		btnSearch.setStyle("-fx-background-color: blue; -fx-text-fill: white;-fx-font-size:13");
//	
//		
		btnClose=new Button("Logout");
		btnClose.relocate(850, 420);
		btnClose.setStyle("-fx-background-color: Red; -fx-text-fill: white;-fx-font-size:13");
//		
//		btnDisplay=new Button("Display");
//		btnDisplay.relocate(910, 420);
//		btnDisplay.setStyle("-fx-background-color: Gray; -fx-text-fill: white;-fx-font-size:13");
//		
		btnDelete=new Button("Delete");
		btnDelete.relocate(750, 420);
	btnDelete.setStyle("-fx-background-color: Black; -fx-text-fill: white;-fx-font-size:13");
		
		lblMessage = new Label("Message");
		lblMessage.relocate(1300, 730);
		 lblMessage.setStyle("-fx-font-size:14");
		// ComboBox for action
	        btnchoice = new ComboBox<>();
	        btnchoice.relocate(610, 420);
	        btnchoice.getItems().addAll("Save", "Search", "Display");
	        btnchoice.setStyle("-fx-font-size:13");
		
		
			
                
				 // TableDetials
				tblTable = new TableView();
				tblTable.setPrefHeight(250);
				tblTable.setPrefWidth(1040);
				tblTable.relocate(250, 510);

				// All Columns inside the table
				TableColumn<AmenitiesUser,Integer> Croom_no = new TableColumn<>("Room No");
				TableColumn<AmenitiesUser,String> Csoap = new TableColumn<>("Soap");
				TableColumn<AmenitiesUser,String> Ctoothpaste = new TableColumn<>("ToothPaste");
				TableColumn<AmenitiesUser,String> Ctoothbrush= new TableColumn<>("ToothBrush");
				TableColumn<AmenitiesUser,String> CShampoo = new TableColumn<>("Shampoo");
				
				
				// Add data on the table
				tblTable.getColumns().add(Croom_no);
				tblTable.getColumns().add(Csoap);
				tblTable.getColumns().add(Ctoothpaste);
				tblTable.getColumns().add(Ctoothbrush);
				tblTable.getColumns().add(CShampoo);

				//inserting data inside table
				Croom_no.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
				Csoap.setCellValueFactory(new PropertyValueFactory<>("Soap"));
				Ctoothpaste.setCellValueFactory(new PropertyValueFactory<>("Toothpaste"));
			 Ctoothbrush.setCellValueFactory(new PropertyValueFactory<>("Toothbrush"));
			 CShampoo.setCellValueFactory(new PropertyValueFactory<>("Shampoo"));
				
				//set Font size of details inside table
				tblTable.setStyle("-fx-font-size: 12px;"); 
				
				//adjusting columns size
				Croom_no.setPrefWidth(210);
		        Csoap.setPrefWidth(210);
		        Ctoothpaste.setPrefWidth(210);
		        Ctoothbrush.setPrefWidth(210);
		        CShampoo.setPrefWidth(210);
		      
		        //combo box
				btnchoice.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
		String selectedAction = btnchoice.getValue();
		                
		                if (selectedAction.equals("Save")) {
		                   AmenitiesUser user = new AmenitiesUser();
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
						

					 } else if (selectedAction.equals("Search")) {
								int roomNo = Integer.parseInt(txtRoomNo.getText());
								AmenitiesUser user = new UserCRUD().search(roomNo);
								if(user.getRoomNo()>0) {
									//if all insert record are found 
									txtSoap.setText(user.getSoap());
									txtToothpaste.setText(user.getToothpaste());
					                txtToothbrush.setText(user.getToothbrush());
					                txtShampoo.setText(user.getShampoo());
									lblMessage.setText("Record found !");
								}
								else {
									//if insert data didnt found
									txtSoap.setText("");
									txtToothpaste.setText("");
		                  			txtToothbrush.setText("");
									txtShampoo.setText("");

									lblMessage.setText("Record not found !");
									lblMessage.setStyle("-fx-text-fill: RED;");
								}
							}
					    else if (selectedAction.equals("Display")) {
		                List<AmenitiesUser> users = new UserCRUD().all();
		                System.out.println("Number of users retrieved: " + users.size());
		                tblTable.getItems().clear();
		                tblTable.getItems().addAll(users);
							       }
							}});

//		
//		        btnDisplay.setOnAction(new EventHandler<ActionEvent>() {
//		            @Override
//		            public void handle(ActionEvent actionEvent) {
//		                // Fetch the list of all records
//		                List<AmenitiesUser> users = new UserCRUD().all();
//		                
//		 
//		                System.out.println("Number of users retrieved: " + users.size());
//
//		                tblTable.getItems().clear();
//		                tblTable.getItems().addAll(users);
//		            }
//		        });
				
				//action close button
				btnClose.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						primaryStage.close();
						  

					}
				});
				
				//Delete button in action
		    	btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				    @Override
				   public void handle(ActionEvent Event) {
				        AmenitiesUser deleterow = (AmenitiesUser) tblTable.getSelectionModel().getSelectedItem();
				        if (deleterow != null) {
				            //conformation popup
				            Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
				            ale.setTitle("Confirm Delete");
				            ale.setHeaderText("Do you want to delete this record?");

				            Optional<ButtonType> result = ale.showAndWait();
				 
				            
				            //delete form database
				            if (result.isPresent() && result.get() == ButtonType.OK) {
				                 boolean success = new AdminCRUD().delete(deleterow.getRoomNo());
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

				//rectangle box for all amentites
				Rectangle amenities = new Rectangle();
				amenities.setArcWidth(20);
				amenities.setArcHeight(20);
				amenities.setWidth(360);
				amenities.setHeight(300);
				amenities.relocate(590, 90);
				amenities.setFill(Color.WHITE); 
				amenities.setStroke(Color.DARKGRAY); 
				amenities.setStrokeWidth(1);
		
				//adjusting tab
		Pane pane=new Pane();
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		 primaryStage.setWidth(1580);
		primaryStage.setHeight(840);
		 pane.setStyle("-fx-background-color:#B0E0E6;");

		 //Pane 
		pane.getChildren().add(lblTitle); 
		pane.getChildren().add(lblTitle2);
		pane.getChildren().add(amenities);
		pane.getChildren().add(lblRoomNo);
		pane.getChildren().add(txtRoomNo); 
		pane.getChildren().addAll(lblSoap, txtSoap);
		pane.getChildren().addAll(lblToothpaste, txtToothpaste);
		pane.getChildren().addAll(lblToothbrush, txtToothbrush);
		pane.getChildren().addAll(lblShampoo, txtShampoo);
        pane.getChildren().addAll(btnchoice);
//		pane.getChildren().addAll(btnTurnOver);
//		pane.getChildren().addAll(btnSearch);
//		pane.getChildren().addAll(btnDisplay);
		pane.getChildren().addAll(btnClose);
		pane.getChildren().addAll(btnDelete);
		pane.getChildren().add(tblTable);
		pane.getChildren().addAll(lblMessage);
		
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
		}





