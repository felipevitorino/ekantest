package br.com.ekan.domain.beneficiario;

import java.time.LocalDate;

import jakarta.annotation.Nonnull;

public record DadosAtualizacaoBeneficiario(
		@Nonnull
		Long id,
		String nome,
		String telefone,
		LocalDate dataNascimento,
		LocalDate dataAtualizacao) {
	
}
