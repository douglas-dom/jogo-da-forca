package br.com.jogo.forca.dto;

import java.util.Map;
import java.util.Set;

public class PartidaDTO {
	
	// Constante de jogo
	private int totalLetras;
	private String dica;
	
	// Estado do jogador
	private int statusJogador;
	
	// Estado da partida
	private Set<String> letrasUtilizadas; 
	private Map<Integer, String> letrasDescobertas;
	private boolean jogoEncerrado;
	private boolean jogadorGanhou;
	
	public PartidaDTO() {}
	
	public PartidaDTO(int totalLetras, String dica, int statusJogador, Set<String> letrasUtilizadas,
			Map<Integer, String> letrasDescobertas, boolean jogoEncerrado, boolean jogadorGanhou) {
		super();
		this.totalLetras = totalLetras;
		this.dica = dica;
		this.statusJogador = statusJogador;
		this.letrasUtilizadas = letrasUtilizadas;
		this.letrasDescobertas = letrasDescobertas;
		this.jogoEncerrado = jogoEncerrado;
		this.setJogadorGanhou(jogadorGanhou);
	}

	public int getTotalLetras() {
		return totalLetras;
	}
	public void setTotalLetras(int totalLetras) {
		this.totalLetras = totalLetras;
	}
	public int getStatusJogador() {
		return statusJogador;
	}
	public void setStatusJogador(int statusJogador) {
		this.statusJogador = statusJogador;
	}
	public Set<String> getLetrasUtilizadas() {
		return letrasUtilizadas;
	}
	public void setLetrasUtilizadas(Set<String> letrasUtilizadas) {
		this.letrasUtilizadas = letrasUtilizadas;
	}
	public Map<Integer, String> getLetrasDescobertas() {
		return letrasDescobertas;
	}
	public void setLetrasDescobertas(Map<Integer, String> letrasDescobertas) {
		this.letrasDescobertas = letrasDescobertas;
	}
	public boolean isJogoEncerrado() {
		return jogoEncerrado;
	}
	public void setJogoEncerrado(boolean jogoEncerrado) {
		this.jogoEncerrado = jogoEncerrado;
	}

	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public boolean isJogadorGanhou() {
		return jogadorGanhou;
	}

	public void setJogadorGanhou(boolean jogadorGanhou) {
		this.jogadorGanhou = jogadorGanhou;
	}

}
