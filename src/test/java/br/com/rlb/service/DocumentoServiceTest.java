package br.com.rlb.service;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.server.ResponseStatusException;

import br.com.rlb.application.AppConfig;
import br.com.rlb.entity.Documento;
import br.com.rlb.repository.DocumentoRepository;

@SpringBootTest(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DocumentoServiceTest {
	
	@Autowired
	private DocumentoService service;
	
	@Autowired
	private DocumentoRepository dao;

	@Before
	public void setUp() {
		Documento obj = new Documento();
		obj.setGru("242501");
		obj.setNomeDocumento("teste gru");
		
		//System.out.println(obj.getId() + "," + obj.getServico() + "," + obj.getGru());
		dao.save(obj);
		
	}
	
	@Test
	public void deveRetornar_valorNulo() {
		try {
			service.findBynuGru(null);
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.BAD_REQUEST, ex.getStatus());
		}
	}
	
	@Test
	public void deveRetornar_numeroGruVazio() {
		try {
			service.findBynuGru("");
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.BAD_REQUEST, ex.getStatus());
		}
	}
	
	@Test
	public void deveRetornar_numeroGruInvalido() {
		try {
			service.findBynuGru("abc-1");
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.BAD_REQUEST, ex.getStatus());
		}
	}
	
	@Test
	public void deveRetornar_gruNaoEncontrada() {
		try {
			service.findBynuGru("0");
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.NOT_FOUND, ex.getStatus());
		}
	}
	
	@Test
	public void deveRetornar_statusOk() {
		try {
			service.findBynuGru("242501");
		} catch (ResponseStatusException ex) {
			assertEquals(HttpStatus.OK, ex.getMessage());
		}
	}
}
