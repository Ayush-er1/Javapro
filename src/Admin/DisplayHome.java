package Admin;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DisplayHome extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label lblTitle;
		Button btnDisplay, btnClear, btnClose;
		TableView tblUsers;

	
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
		colRoomavaiability.setCellValueFactory(new PropertyValueFactory<>("AvaiableStatus"));
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
				tblUsers.getItems().clear();
				for (AdminUser user : users) {
					tblUsers.getItems().add(user);
				}

			}
		});

		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				primaryStage.close();

			}
		});

		pane.getChildren().addAll(lblTitle, btnClear, btnDisplay, btnClose);
		pane.getChildren().add(tblUsers);

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}