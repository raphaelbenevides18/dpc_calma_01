package br.com.rlb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rlb.entity.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long>{

	public  Optional<Documento> findByGru(String gru);
}
