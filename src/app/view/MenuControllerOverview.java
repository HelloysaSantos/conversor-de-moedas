package app.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
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
	
	private Parent root;
	
	@FXML
	private ChoiceBox <String> tipoConversorChoiceBox;
	
	private String[] ListaDeConversores = {"Conversor de Moedas", "Conversor de Temperatura"};
	
	private MainApp mainApp;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		this.tipoConversorChoiceBox.getItems().addAll(ListaDeConversores);
		tipoConversorChoiceBox.setValue("Conversor de Moedas");
		
	}
	
	@FXML
	public void showConversorOverview(ActionEvent event) {
		
		if (tipoConversorChoiceBox.getValue() == "Conversor de Moedas") {
			mainApp = new MainApp();
			mainApp.showConversorDeMoedasOverview(event);
			
		}
	}
	
}
