package app.util;

import java.util.List;

import app.model.Moeda;

public class ConversorDeMoedaUtil {
	
	private Moeda real;
	private Moeda dolar;
	private Moeda libra;
	private Moeda pesoArgentino;
	private Moeda pesoChileno;
	
	private Moeda moeda;
	
	private String ultimaDataAtualizacao = "12/06/2023";
	
	private List<String> nomeTodasAsMoedas;
	
	public ConversorDeMoedaUtil() {
		 
		real = new Moeda("Real Brasileiro", 1, "BRL");
		dolar = new Moeda("Dólar Americano", 4.859, "USD");
		libra = new Moeda("Libras Esterlinas", 6.286, "GBP");
		pesoArgentino = new Moeda("Peso Argentino", 0.019, "ARS");
		pesoChileno = new Moeda("Peso Chileno", 0.006, "CLP");
		
		nomeTodasAsMoedas = real.getNomeTodasAsMoedas();
		

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
		
		if (moedaParaConverter == this.real) {
			
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
	
	public List<String> getNomeTodasAsMoedas() {
		return nomeTodasAsMoedas;
	}
	
}
