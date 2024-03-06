package br.com.ekan.domain.documento;

import java.time.LocalDate;

import br.com.ekan.domain.beneficiario.Beneficiario;

public record DocumentoDTO(Long id, String tipoDocumento, String descricao, LocalDate dataInclusao, LocalDate dataAtualizacao, Beneficiario beneficiario) {
	
	public DocumentoDTO(Documento documento){
		this(documento.getId(), documento.getTipoDocumento(), documento.getDescricao(), documento.getDataInclusao(), documento.getDataAtualizacao(), documento.getBeneficiario());
	}
}

	