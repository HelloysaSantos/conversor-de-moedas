package app.util;

public class ConversorDeMoedaUtil {
	
	private double cotacaoDolar = 4.859;
	private double cotacaoLibras = 6.286;
	private double cotacaoPesoArgentino = 0.019;
	private double cotacaoPesoChileno = 0.006;
	private String ultimaDataAtualizacao = "12/06/2023";
	
	public double converteParaReal(double valor, String moeda) {
		
		if(moeda == "Dólar Americano") { return valor * this.cotacaoDolar; } 
		else if (moeda == "Libras Esterlinas") { return valor * this.cotacaoLibras;} 
		else if (moeda == "Peso Argentino") {return valor * this.cotacaoPesoArgentino;} 
		else if (moeda == "Peso Chileno" ) {return valor * this.cotacaoPesoChileno;} 
		else {return valor;}
		
	}
	
	public double converteParaMoedaX(double valor, String moeda) {
			
			if(moeda == "Dólar Americano") { return valor/this.cotacaoDolar; } 
			else if (moeda == "Libras Esterlinas") { return valor/this.cotacaoLibras;} 
			else if (moeda == "Peso Argentino") {return valor/this.cotacaoPesoArgentino;} 
			else if (moeda == "Peso Chileno" ) {return valor/this.cotacaoPesoChileno;} 
			else {return valor;}
			
	}
	
	public String getSigla(String moeda) {
		
		if(moeda == "Dólar Americano") { return "USD"; } 
		else if (moeda == "Libras Esterlinas") { return "GBP";} 
		else if (moeda == "Peso Argentino") {return "ARS";} 
		else if (moeda == "Peso Chileno" ) {return "CLP";} 
		else {return "BRL";}
	}
}
