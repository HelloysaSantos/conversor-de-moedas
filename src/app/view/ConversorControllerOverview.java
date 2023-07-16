package app.view;

import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
import app.model.Moeda;
import app.util.ConversorDeMoedaUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.Initializable;

public class ConversorControllerOverview implements Initializable{
	
	private ConversorDeMoedaUtil conversor;
	
	@FXML
	private TextField valorField;
	
	@FXML
	private ChoiceBox<String> seletorDeMoeda1; 
	
	@FXML
	private ChoiceBox<String> seletorDeMoeda2;
	
	@FXML
	private Label valorConvertidoLabel;
	
	@FXML
	private Label valorAConverterLabel;
	
	@FXML
	private Label cotacaoMoeda1Label;
	
	@FXML
	private Label cotacaoMoeda2Label;
	
	private MainApp mainApp;
	
	public ConversorControllerOverview() {
		conversor = new ConversorDeMoedaUtil();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.seletorDeMoeda1.getItems().addAll(conversor.getNomeTodasAsMoedas());
		this.seletorDeMoeda2.getItems().addAll(conversor.getNomeTodasAsMoedas());
		
		seletorDeMoeda1.setValue("Real Brasileiro");
		seletorDeMoeda2.setValue("Dólar Americano");
		
		valorConvertidoLabel.setText("");
		valorAConverterLabel.setText("");
		cotacaoMoeda1Label.setText("");
		cotacaoMoeda2Label.setText("");
		
		
	}
	
	@FXML
	public void calcularConversao() {
		
		if (validacaoDeDados()) {
			
			//Transforma valor de String em double
			double valor =  Double.parseDouble(this.valorField.getText());
			
			String moedaParaConverter = this.seletorDeMoeda1.getValue();
			String moedaConvertida = this.seletorDeMoeda2.getValue();
			double valorConvertido;
			double valorConvertidoPor1A = 0;
			double valorConvertidoPor1B = 0;
			
			//Conversão do valor do Field
			valorConvertido = conversor.getValorConvertido(valor, moedaParaConverter, moedaConvertida);
			valorConvertidoPor1A = conversor.getValorConvertido(1, moedaParaConverter, moedaConvertida);
			valorConvertidoPor1B = conversor.getValorConvertido(1, moedaConvertida, moedaParaConverter);
			
			String siglaMoedaConvertida = this.conversor.getSigla(moedaConvertida);
			String siglaMoedaParaConverter = this.conversor.getSigla(moedaParaConverter);
			
			valorAConverterLabel.setText(Double.toString(valor) + " em " + moedaParaConverter + " =");
			valorConvertidoLabel.setText(Double.toString(valorConvertido) + " em " + moedaConvertida);
			cotacaoMoeda1Label.setText("1 " + siglaMoedaParaConverter + " = " + valorConvertidoPor1A + " " + siglaMoedaConvertida);
			cotacaoMoeda2Label.setText("1 " + siglaMoedaConvertida + " = " + valorConvertidoPor1B + " " + siglaMoedaParaConverter);
			
		}
	}
	
	@FXML
	public void limparConversor(ActionEvent event) {
	
		mainApp = new MainApp();
		mainApp.showConversorDeMoedasOverview(event);
			
	}
	
	@FXML
	public boolean validacaoDeDados() {
		
		try {
			
			double valor =  Double.parseDouble(this.valorField.getText());
			return true;
			
		} catch (NumberFormatException e) {
			
			Alert alert = new Alert(AlertType.ERROR);
				valorField.setText("");
				alert.setTitle("Campo Inválido");
				alert.setHeaderText("Por favor, corrija os campos inválidos.");
				alert.setContentText("Digite apenas valores numéricos!");
			alert.showAndWait();
				
			return false;
		}
		
	}
	
}
