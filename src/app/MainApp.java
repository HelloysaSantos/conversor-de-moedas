package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import app.model.Moeda;
import app.view.ConversorControllerOverview;
import app.view.MenuControllerOverview;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class MainApp extends Application {
	
	private Stage stage;
	private AnchorPane rootLayout;
	private static List<Moeda> todasAsMoedas = new ArrayList<>();
	
	public MainApp() {
		
		todasAsMoedas.add(new Moeda("Real Brasileiro", 1, "BRL")); 
		todasAsMoedas.add(new Moeda("Dólar Americano", 4.859, "USD"));
		todasAsMoedas.add(new Moeda("Libras Esterlinas", 6.286, "GBP"));
		todasAsMoedas.add(new Moeda("Peso Argentino", 0.019, "ARS"));
		todasAsMoedas.add(new Moeda("Peso Chileno", 0.006, "CLP"));
	}
	
	public MainApp(String vazio) {
		
	}

	@Override
	public void start(Stage stage) {
		
		this.stage = stage;
		this.stage.setTitle("Menu");
		
		showMenuOverview();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void showMenuOverview() {
			
		try {
			
			//Carrega o arquivo FXML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/MenuOverview.fxml"));
			rootLayout = (AnchorPane)loader.load();
			
			//Mostra a scene
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
			
			MenuControllerOverview controller = loader.getController();
			controller.setStage(stage);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	public void showConversorDeMoedasOverview() {
		
		try {
			
			//Carrega o arquivo FXML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ConversorDeMoedasOverview.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			
			//Mostra a scene
			Stage conversorMoedas = new Stage();
			conversorMoedas.setTitle("Conversor de Moedas");
			
			Scene scene = new Scene(page);
			conversorMoedas.setScene(scene);
			
			ConversorControllerOverview controller = loader.getController();
			controller.setConversorStage(conversorMoedas);
			
			conversorMoedas.show();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public Stage getPrimaryStage() {
		return stage;
	}

	
}
