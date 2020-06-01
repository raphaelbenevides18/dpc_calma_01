package br.com.rlb.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.rlb.entity.Documento;
import br.com.rlb.repository.DocumentoRepository;

@Service
public class DocumentoService {
	@Autowired
	private DocumentoRepository repository;
	
	public Documento findBynuGru(String gru) {
		if (gru == null || gru.trim().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero de GRU nulo ou vazio");
		}
		
		Pattern pattern = Pattern.compile("^[0-9]{1,}$");
		Matcher matcher = pattern.matcher(gru);
		if(!matcher.find()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero de GRU invalido");
		}
		
		Optional<Documento> documento = repository.findByGru(gru);
		if (documento.isPresent()) {
			return documento.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Documento não encontrado");
		}
	}
}
