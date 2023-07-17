package app.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
import app.model.Moeda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuControllerOverview implements Initializable{
	
	private Stage stage;
	
	private Scene scene;
	
	@FXML
	private ChoiceBox <String> tipoConversorChoiceBox;
	
	private String[] ListaDeConversores = {"Conversor de Moedas", "Conversor de Temperatura"};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		this.tipoConversorChoiceBox.getItems().addAll(ListaDeConversores);
		tipoConversorChoiceBox.setValue("Conversor de Moedas");
		
	}
	
	public void setStage(Stage stage) {

		this.stage = stage;
		
	}
	
	@FXML
	public void showConversorOverview() {
		
		if (tipoConversorChoiceBox.getValue() == "Conversor de Moedas") {
			MainApp mainApp = new MainApp("");
			mainApp.showConversorDeMoedasOverview();
			
		}
	}
	
	public void cancelarButton() {
		
		stage.close();
		
	}
	
}
