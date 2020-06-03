package br.com.rlb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/")
public class RootController {

	@GetMapping
	public String hello() {
		return "Endpoint para consulta GET: /buscar/{numero da gru}";
	}
}
