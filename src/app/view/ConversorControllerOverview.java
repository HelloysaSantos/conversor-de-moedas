package app.view;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import app.MainApp;
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
	
	private String[] nomeMoedas = {"Real Brasileiro", "Dólar Americano", "Libras Esterlinas", "Peso Argentino", "Peso Chileno"};
	
	public ConversorControllerOverview() {
		conversor = new ConversorDeMoedaUtil();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.seletorDeMoeda1.getItems().addAll(nomeMoedas);
		this.seletorDeMoeda2.getItems().addAll(nomeMoedas);
		
		seletorDeMoeda1.setValue("Real Brasileiro");
		seletorDeMoeda2.setValue("Dólar Americano");
		
	}
	
	@FXML
	public void calcularConversao() {
		
		double valor =  Double.parseDouble(this.valorField.getText());
		String moedaParaConverter = this.seletorDeMoeda1.getValue();
		String moedaConvertida = this.seletorDeMoeda2.getValue();
		double valorConvertido;
		double valorConvertidoPor1A = 0;
		double valorConvertidoPor1B = 0;
		
		String siglaMoedaConvertida = this.conversor.getSigla(moedaConvertida);
		String siglaMoedaParaConverter = this.conversor.getSigla(moedaParaConverter);
		
		//Conversão do valor do Field
		if (moedaParaConverter != moedaConvertida) {
			
			if (moedaParaConverter == "Real Brasileiro") {
				
				valorConvertido = this.conversor.converteParaMoedaX(valor, moedaConvertida);
				valorConvertidoPor1A = this.conversor.converteParaMoedaX(1, moedaConvertida);
				valorConvertidoPor1B = this.conversor.converteParaReal(1, moedaConvertida);
				
			} else {
				
				double valorConvertidoEmReal = this.conversor.converteParaReal(valor, moedaParaConverter);
				valorConvertido = this.conversor.converteParaMoedaX(valorConvertidoEmReal, moedaConvertida);
				
				double valorConvertidoEmReal2 = this.conversor.converteParaReal(1, moedaParaConverter);
				valorConvertidoPor1A = this.conversor.converteParaMoedaX(valorConvertidoEmReal2, moedaConvertida);
				
				double valorConvertidoEmReal3 = this.conversor.converteParaReal(1, moedaConvertida);
				valorConvertidoPor1B = this.conversor.converteParaMoedaX(valorConvertidoEmReal3, moedaParaConverter);
				
			}
			
		} else {
			
			valorConvertido = valor;
			valorConvertidoPor1A = 1;
			valorConvertidoPor1B = 1;
			
		}
		
		valorAConverterLabel.setText(Double.toString(valor) + " em " + moedaParaConverter + " =");
		valorConvertidoLabel.setText(Double.toString(valorConvertido) + " em " + moedaConvertida);
		cotacaoMoeda1Label.setText("1 " + siglaMoedaParaConverter + " = " + valorConvertidoPor1A + " " + siglaMoedaConvertida);
		cotacaoMoeda2Label.setText("1 " + siglaMoedaConvertida + " = " + valorConvertidoPor1B + " " + siglaMoedaParaConverter);
	}
	
	public void limparConversor(ActionEvent event) {
	
			mainApp = new MainApp();
			mainApp.showConversorDeMoedasOverview(event);
			
	}
	
}
