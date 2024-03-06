package br.com.ekan.domain.beneficiario;

import java.time.LocalDate;

public record DadosListagemBeneficiario(Long id, String nome, String telefone, LocalDate dataNascimento) {

	public DadosListagemBeneficiario(Beneficiario beneficiario) {
		this(beneficiario.getId(), beneficiario.getNome(), beneficiario.getTelefone(), beneficiario.getDataNascimento());
	}

}
