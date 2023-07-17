package app.util;

import java.util.List;

import app.model.Moeda;

public class ConversorDeMoedaUtil {
	
	private String ultimaDataAtualizacao = "12/06/2023";
	
	Moeda moeda;
	
	public ConversorDeMoedaUtil() {
		
	}
	
	public double getValorConvertido(double valor, String nomeMoedaParaConverter, String nomeMoedaConvertida) {
		
		List<Moeda> todasAsMoedas = moeda.getTodasAsMoedas();
		Moeda moedaParaConverter =  new Moeda();
		Moeda moedaConvertida = new Moeda();
		
		for (int i = 0; i < todasAsMoedas.size();i++) {
			
			if (todasAsMoedas.get(i).getNome() == nomeMoedaParaConverter) {
				moedaParaConverter = todasAsMoedas.get(i);
			}
			
			if (todasAsMoedas.get(i).getNome() == nomeMoedaConvertida) {
				moedaConvertida = todasAsMoedas.get(i);
			}
		}
		
		if (moedaParaConverter.getNome() == "Real Brasileiro") {
			
			return valor / moedaConvertida.getCotacao();
			
		} else {
			
			double valorEmReal = valor * moedaParaConverter.getCotacao();
			return valorEmReal / moedaConvertida.getCotacao();
			
		}
	}
	
	public String getSigla(String moeda) {
		
		if(moeda == "Dólar Americano") { return "USD"; } 
		else if (moeda == "Libras Esterlinas") { return "GBP";} 
		else if (moeda == "Peso Argentino") {return "ARS";} 
		else if (moeda == "Peso Chileno" ) {return "CLP";} 
		else {return "BRL";}
	}
	
}
