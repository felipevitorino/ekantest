package br.com.ekan.domain.documento;

import java.time.LocalDate;

import br.com.ekan.domain.beneficiario.Beneficiario;

public record DadosCadastroDocumento(String tipoDocumento, String descricao, LocalDate dataInclusao,
		Beneficiario beneficiario) {

	public DadosCadastroDocumento(String tipoDocumento, String descricao, Beneficiario beneficiario, Long beneficiarioId) {
		this(tipoDocumento, descricao, LocalDate.now(), beneficiario);
	}

}
