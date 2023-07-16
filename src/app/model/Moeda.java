package app.model;

import java.util.ArrayList;
import java.util.List;

public class Moeda {
	
	private double cotacao;
	private String nome;
	private String sigla;
	
	private static List<String> nomeTodasAsMoedas = new ArrayList<>(); //Guarda uma lista do nome de todas moedas criadas
	private static List<Moeda> todasAsMoedas = new ArrayList<>(); //Guarda uma lista com todas os objetos do tipo Moeda criados
	
	public Moeda() {
		
	}
	
	public Moeda(String nome, double cotacao, String sigla) {
		
		this.setNome(nome);
		this.setCotacao(cotacao);
		this.setSigla(sigla);
		
		this.todasAsMoedas.add(this);
		
		this.nomeTodasAsMoedas.add(nome);
		
	}
	
	public double getCotacao() {
		return cotacao;
	}
	public void setCotacao(double cotacao) {
		this.cotacao = cotacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public static List<Moeda> getTodasAsMoedas() {
		return todasAsMoedas;
	}
	
	public static List<String> getNomeTodasAsMoedas() {
		return nomeTodasAsMoedas;
	}
	
}
