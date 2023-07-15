package app;

import java.io.IOException;

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
	
	public MainApp() {
		
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
	
	public void showOverviewAndController(String src, Initializable controller) {
		
		try {
			
			//Carrega o arquivo FXML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(src));
			rootLayout = (AnchorPane)loader.load();
			
			//Mostra a scene
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
			
			controller = loader.getController();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void showMenuOverview() {
			MenuControllerOverview controller = null;
			showOverviewAndController("view/MenuOverview.fxml", controller);
		
	}
	
	public void showConversorDeMoedasOverview(ActionEvent event) {
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			MenuControllerOverview controller = null;
			showOverviewAndController("view/ConversorDeMoedasOverview.fxml", controller);
	}
	
	public Stage getPrimaryStage() {
		return stage;
	}

	
}
