package app;

import java.io.IOException;

import app.view.ConversorControlOverview;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class MainApp extends Application {
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	public MainApp() {
		
	}

	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Conversor de Moedas");
		
		showConversorDeMoedasOverview();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void showConversorDeMoedasOverview() {
		
		try {
			//Carrega o arquivo FXML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ConversorDeMoedasOverview.fxml"));
			rootLayout = (AnchorPane)loader.load();
			
			//Mostra a scene
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			//Define esta classe como control
			ConversorControlOverview control = loader.getController();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
}
