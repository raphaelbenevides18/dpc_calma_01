package br.com.rlb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.rlb.application.AppConfig;
import br.com.rlb.entity.Documento;
import br.com.rlb.repository.DocumentoRepository;

@SpringBootTest(classes = AppConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class DocumentoControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private DocumentoRepository dao;
	
	private static final String NU_GRU = "242501";
	private static final String NUMERO_GRU_NAO_ENCONTRADO = "0";
	private static final String NUMERO_GRU_INVALIDO = "abc-1";
	
	@Before
	public void setUp() {
		Documento obj = new Documento();
		obj.setGru(NU_GRU);
		obj.setNomeDocumento("teste gru");

		//System.out.println(obj.getId() + "," + obj.getServico() + "," + obj.getGru());
		dao.save(obj);
	}
	
	@Test
	public void findByGru_badRequest() throws Exception {
		 this.mockMvc.perform(get("/documento/buscar/" + NUMERO_GRU_INVALIDO)).andExpect(status().isBadRequest());
	}
	
	@Test
	public void findByGru_NotFound() throws Exception {
		 this.mockMvc.perform(get("/documento/buscar/" + NUMERO_GRU_NAO_ENCONTRADO)).andExpect(status().isNotFound());
	}
	
	@Test
	public void findByGru_ok() throws Exception {
		this.mockMvc.perform(get("/documento/buscar/" + NU_GRU)).andExpect(status().isOk());
	}
	
}
