package br.com.rlb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlb.entity.Documento;
import br.com.rlb.service.DocumentoService;

@RestController
@ResponseBody
@RequestMapping({"/documento"})
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;

	@GetMapping("/buscar/{gru}")
	public ResponseEntity<Object> findByGru(@PathVariable("gru") String gru) {
		Documento documento = service.findBynuGru(gru);
		return ResponseEntity.ok(documento);
	}

}
