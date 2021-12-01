/**
 * Classe de serviço do jogo da forca, responsãvel pelo controle do jogo.
 * 
 * @author Douglas Domingos de Oliveira
 * 
 * @version 1.0
 * 
 * @since 2021-11-29
 */

package br.com.jogo.forca.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.jogo.forca.dto.PartidaDTO;
import br.com.jogo.forca.model.Palavra;

@Service
@ApplicationScope
public class GameSessionService {
	
	Logger logger = LoggerFactory.getLogger(GameSessionService.class);
	
	
	private List<Palavra> listaPalavras; // Lista de palavras disponíveis para jogar;
	
	private Palavra palavraEscolhida; // Palavra escolhida aleatóriamente.
	private Set<String> letrasUtilizadas; // Letras utilizadas pelo jogador.
	private Map<Integer, String> letrasDescobertas; // Letras da palavra descoberta pelo jogador.
	
	private int statusJogador; // status do jogador. 0 - normal : 6-Game Over
	private boolean jogoEncerrado;
	private boolean jogadorGanhou;
	
	public GameSessionService() {
		this.listaPalavras = new ArrayList<>();
		this.listaPalavras.add(new Palavra("medalha", "Prêmio de uma competição entre aos atlétas."));
		this.listaPalavras.add(new Palavra("carro", "Veiculo automotor de quatro rodas."));
		
		logger.info("Sessão de jogo pronta.");
	}
	
	
	/**
	 * Inicia o jogo.
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public PartidaDTO start() throws NoSuchAlgorithmException {
		
		Random rand = SecureRandom.getInstanceStrong();
		int rValue = rand.nextInt(this.listaPalavras.size());
		
		this.palavraEscolhida = this.listaPalavras.get(rValue);
		this.letrasUtilizadas =  new HashSet<>();
		this.letrasDescobertas = new HashMap<Integer, String>();
		this.jogoEncerrado = false;
		this.jogadorGanhou = false;
		
		this.statusJogador = 0;
		
		logger.info("Novo jogo iniciado.");
		
		return new PartidaDTO(
				this.palavraEscolhida.getNome().length(),
				this.palavraEscolhida.getDica(),
				this.statusJogador,
				this.letrasUtilizadas,
				this.letrasDescobertas,
				this.jogoEncerrado,
				this.jogadorGanhou);
	}
	
	/**
	 * Insere a letra desejada pelo jogador.
	 * 
	 * @param letra
	 */
	public PartidaDTO selecionaLetra(String letra) {
		if(this.letrasDescobertas.containsValue(letra) || this.letrasUtilizadas.contains(letra)) {
			return new PartidaDTO(
					this.palavraEscolhida.getNome().length(),
					this.palavraEscolhida.getDica(),
					this.statusJogador,
					this.letrasUtilizadas,
					this.letrasDescobertas,
					this.jogoEncerrado,
					this.jogadorGanhou);
		}
		if(this.palavraEscolhida.getNome().contains(letra) || this.palavraEscolhida.getNome().contains(letra.toUpperCase())) {
			String str = this.palavraEscolhida.getNome();
			List<Integer> indices = new ArrayList<>();

			int startFrom = 0;
			for(;;) {
				int index = str.indexOf(letra, startFrom);
				if(index >= 0) {
					indices.add(index);
					startFrom = index + 1;
				} else {
					break;
				}
			}
			for(int i : indices) {
				this.letrasDescobertas.put(i, letra.toUpperCase());
			}
		} else {
			this.statusJogador++;
			this.letrasUtilizadas.add(letra.toUpperCase());
		}
		
		if(this.statusJogador >= 6 ||
				this.letrasDescobertas.size() == this.palavraEscolhida.getNome().length()) {
			this.jogoEncerrado = true;
			if(this.letrasDescobertas.size() == this.palavraEscolhida.getNome().length() && this.statusJogador < 6) {
				this.jogadorGanhou = true;
			} else {
				this.jogadorGanhou = false;
			}
			
		}
		
		return new PartidaDTO(
				this.palavraEscolhida.getNome().length(),
				this.palavraEscolhida.getDica(),
				this.statusJogador,
				this.letrasUtilizadas,
				this.letrasDescobertas,
				this.jogoEncerrado,
				this.jogadorGanhou);
	}

}
