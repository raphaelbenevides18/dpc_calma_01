package br.com.rlb.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.rlb.entity.Documento;

public class DocumentoTest {

	@Test
	public void deveRetornarDocumento() {

		String gru = "242501";
		String nome = "teste gru";
		

		Documento obj = new Documento();
		obj.setGru(gru);
		obj.setNomeDocumento(nome);
		
		
		
		assertNotNull(gru);
		assertEquals(nome, obj.getNomeDocumento());
		assertEquals(gru, obj.getGru());
		
		System.out.println("Documento cadastrado: " + obj.getGru() + ", " + obj.getNomeDocumento());
		
	}

}
