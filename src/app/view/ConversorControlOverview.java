package app.view;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import app.util.ConversorDeMoedaUtil;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.fxml.Initializable;

public class ConversorControlOverview implements Initializable{
	
	private ConversorDeMoedaUtil conversor;
	
	@FXML
	private TextField valorField;
	
	@FXML
	private ChoiceBox<String> seletorDeMoeda1; 
	
	@FXML
	private ChoiceBox<String> seletorDeMoeda2;
	
	@FXML
	private Button buttonCalcular;
	
	@FXML
	private Button buttonLimpar;
	
	@FXML
	private Label valorConvertidoLabel;
	
	private String[] nomeMoedas = {"Reais", "Dolar", "Libras Esterlinas", "Peso Argentino", "Peso Chileno"};
	
	public ConversorControlOverview() {
		conversor = new ConversorDeMoedaUtil();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.seletorDeMoeda1.getItems().addAll(nomeMoedas);
		this.seletorDeMoeda2.getItems().addAll(nomeMoedas);
		
		seletorDeMoeda1.setValue("Reais");
		seletorDeMoeda2.setValue("Dolar");
		
	}
	
	@FXML
	public void calcularConversao() {
		
		double valor =  Double.parseDouble(this.valorField.getText());
		String moedaParaConverter = this.seletorDeMoeda1.getValue();
		String moedaConvertida = this.seletorDeMoeda2.getValue();
		double valorConvertido;
		
		if (moedaParaConverter != moedaConvertida) {
			
			if (moedaParaConverter == "Real") {
				
				valorConvertido = this.conversor.converteParaMoedaX(valor, moedaConvertida);
				
			} else {
				
				double valorConvertidoEmReal = this.conversor.converteParaReal(valor, moedaParaConverter);
				valorConvertido = this.conversor.converteParaMoedaX(valorConvertidoEmReal, moedaConvertida);
				
			}
			
		} else {
			
			valorConvertido = valor;
			
		}
			
		
		
		valorConvertidoLabel.setText(Double.toString(valorConvertido)); 
	}
	
}
