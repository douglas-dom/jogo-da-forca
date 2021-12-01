package br.com.jogo.forca.resources;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.jogo.forca.dto.PartidaDTO;
import br.com.jogo.forca.services.GameSessionService;

@Resource
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameSession {
	
	@Autowired
	private GameSessionService session;
	
	@GetMapping("/start")
	public PartidaDTO start() throws NoSuchAlgorithmException {
		return session.start();
	}
	
	@PostMapping("/letra")
	public PartidaDTO selecionaLetra(@RequestBody String letra) {
		return session.selecionaLetra(letra);
	}

}
