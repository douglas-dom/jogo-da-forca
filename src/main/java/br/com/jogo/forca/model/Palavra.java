/**
 * 
 * Palavras do jogo
 * 
 * @author Douglas Domingos de Oliveira
 * 
 * @
 * 
 */

package br.com.jogo.forca.model;

import java.util.Objects;
import java.util.Optional;

public class Palavra {
	
	private String nome;
	private String dica;
	
	public Palavra() {}
	
	public Palavra(String nome, String dica) {
		this.nome = nome;
		this.dica = dica;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dica, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palavra other = (Palavra) obj;
		return Objects.equals(dica, other.dica) && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return Optional.ofNullable(this).map(Object::toString).orElse("");
	}
	
	
	
	

}
