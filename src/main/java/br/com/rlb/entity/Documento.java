package br.com.rlb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GRU_Recuperacao")
public class Documento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NU_GRU", unique=true)
	private String gru;

	@Column(name = "NOME_DOC")
	private String nomeDocumento;

	public Documento() {

	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}

	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getGru() {
		return gru;
	}

	public void setGru(String gru) {
		this.gru = gru;
	}

}
