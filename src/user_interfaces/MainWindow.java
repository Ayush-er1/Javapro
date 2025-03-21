package user_interfaces;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MainWindow  extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		
		//Declare
		
		Label lblTitle,lblSid,lblNAME,lblCOURSE,lblSECTION,lblLEVEL,lblSUB1,lblSUB2,lblTOTAL,lblAVERAGE,lblRESULT;
		TextField txtSid,txtNAME,txtCOURSE,txtSECTION,txtLEVEL,txtSUB1,txtSUB2,txtTOTAL,txtAVERAGE,txtRESULT;
		Button btnSearch;
		
		lblTitle=new Label("Student Result Processing");
		lblTitle.relocate(50, 5);
		Font font1=new Font("Arial",25);
		lblTitle.setFont(font1);

		lblSid=new Label("SID");
		lblSid.relocate(50, 35);
		Font font2=new Font("Arial",18);
		lblSid.setFont(font2);
		
		txtSid=new TextField();
		txtSid.relocate(150, 35);
		
		
		btnSearch=new Button("Search");
		btnSearch.relocate(325, 35);
		
		lblNAME=new Label("NAME");
		lblNAME.relocate(50, 90);
		lblNAME.setFont(font2);
		txtNAME=new TextField();
		txtNAME.relocate(150, 90);
		
		lblCOURSE=new Label("COURSE");
		lblCOURSE.relocate(50, 145);
		lblCOURSE.setFont(font2);
		txtCOURSE=new TextField();
		txtCOURSE.relocate(150, 145);
		
		lblSECTION=new Label("SECTION");
		lblSECTION.relocate(50, 200);
		lblSECTION.setFont(font2);
		txtSECTION=new TextField();
		txtSECTION.relocate(150, 200);
		
		lblSUB2=new Label("SUB2");
		lblSUB2.relocate(50, 365);
		lblSUB2.setFont(font2);
		txtSUB2=new TextField();
		txtSUB2.relocate(150, 365);
		
		lblLEVEL=new Label("LEVEL");
		lblLEVEL.relocate(50, 255);
		lblLEVEL.setFont(font2);
		txtLEVEL=new TextField();
		txtLEVEL.relocate(150, 255);
		
		lblSUB1=new Label("SUB1");
		lblSUB1.relocate(50, 310);
		lblSUB1.setFont(font2);
		txtSUB1=new TextField();
		txtSUB1.relocate(150, 310);
		
		lblTOTAL=new Label("TOTAL");
		lblTOTAL.relocate(50, 420);
		lblTOTAL.setFont(font2);
		txtTOTAL=new TextField();
		txtTOTAL.relocate(150, 420);
		
		lblAVERAGE=new Label("AVERAGE");
		lblAVERAGE.relocate(50, 475);
		lblAVERAGE.setFont(font2);
		txtAVERAGE=new TextField();
		txtAVERAGE.relocate(150, 475);
		
		lblRESULT=new Label("RESULT");
		lblRESULT.relocate(50, 530);
		lblRESULT.setFont(font2);
		txtRESULT=new TextField();
		txtRESULT.relocate(150, 530);
		
		Pane pane=new Pane();
		Scene scene=new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(700);
		
		//Add controls
		
		pane.getChildren().add(lblTitle);
		pane.getChildren().add(lblSid);
		pane.getChildren().add(txtSid);
		pane.getChildren().add(lblNAME);
		pane.getChildren().add(txtNAME);
		pane.getChildren().add(lblCOURSE);
		pane.getChildren().add(txtCOURSE);
		pane.getChildren().add(lblSECTION);
		pane.getChildren().add(txtSECTION);
		pane.getChildren().add(lblLEVEL);
		pane.getChildren().add(txtLEVEL);
		pane.getChildren().add(lblSUB1);
		pane.getChildren().add(txtSUB1);
		pane.getChildren().add(lblSUB2);
		pane.getChildren().add(txtSUB2);
		pane.getChildren().add(lblTOTAL);
		pane.getChildren().add(txtTOTAL);
		pane.getChildren().add(lblAVERAGE);
		pane.getChildren().add(txtAVERAGE);
		pane.getChildren().add(lblRESULT);
		pane.getChildren().add(txtRESULT);
		pane.getChildren().add(btnSearch);
		
		
		//Display window
		primaryStage.show();
		
	}

	public static void main(String[]args) {
		launch(args);
		
	}
}
