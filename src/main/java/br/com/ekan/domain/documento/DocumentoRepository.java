package br.com.ekan.domain.documento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository  extends JpaRepository<Documento, Long> {
    List<Documento> findByBeneficiarioId(Long beneficiarioId);
}
