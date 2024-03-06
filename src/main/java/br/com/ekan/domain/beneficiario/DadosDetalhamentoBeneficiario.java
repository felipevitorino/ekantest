package br.com.ekan.domain.beneficiario;

import java.time.LocalDate;

public record DadosDetalhamentoBeneficiario(Long id, String nome, String telefone, LocalDate dataNascimento,
		LocalDate dataAtualizacao) {

	public DadosDetalhamentoBeneficiario(Beneficiario beneficiario) {
		this(beneficiario.getId(), beneficiario.getNome(), beneficiario.getTelefone(), beneficiario.getDataNascimento(),
				beneficiario.getDataAtualizacao());
	}

}
