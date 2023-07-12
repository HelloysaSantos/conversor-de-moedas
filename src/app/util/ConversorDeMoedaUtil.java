package app.util;

public class ConversorDeMoedaUtil {
	
	private double cotacaoDolar = 4.859;
	private double cotacaoLibras = 6.286;
	private double cotacaoPesoArgentino = 0.019;
	private double cotacaoPesoChileno = 0.006;
	
	
	public double converteParaReal(double valor, String moeda) {
		
		if(moeda == "Dolar") { return valor * this.cotacaoDolar; } 
		else if (moeda == "Libras Esterlinas") { return valor * this.cotacaoLibras;} 
		else if (moeda == "Peso Argentino") {return valor * this.cotacaoPesoArgentino;} 
		else if (moeda == "Peso Chileno" ) {return valor * this.cotacaoPesoChileno;} 
		else {return valor;}
		
	}
	
	public double converteParaMoedaX(double valor, String moeda) {
			
			if(moeda == "Dolar") { return valor/this.cotacaoDolar; } 
			else if (moeda == "Libras Esterlinas") { return valor/this.cotacaoLibras;} 
			else if (moeda == "Peso Argentino") {return valor/this.cotacaoPesoArgentino;} 
			else if (moeda == "Peso Chileno" ) {return valor/this.cotacaoPesoChileno;} 
			else {return valor;}
			
	}
}
