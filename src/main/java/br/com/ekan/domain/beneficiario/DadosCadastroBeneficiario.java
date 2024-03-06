package br.com.ekan.domain.beneficiario;

import java.time.LocalDate;
import java.util.List;

import br.com.ekan.domain.documento.DadosCadastroDocumento;

public record DadosCadastroBeneficiario(
		String nome, 
		String telefone,
		LocalDate dataNascimento, 
		LocalDate dataInclusao, 
		List<DadosCadastroDocumento> documentos) {}
