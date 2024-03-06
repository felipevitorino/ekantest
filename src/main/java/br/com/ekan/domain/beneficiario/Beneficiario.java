package br.com.ekan.domain.beneficiario;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ekan.domain.documento.Documento;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficiario")
public class Beneficiario {
	
	public Beneficiario() {}

	public Beneficiario(DadosCadastroBeneficiario dados) {
		this.nome = dados.nome();
		this.telefone = dados.telefone();
		this.dataNascimento = dados.dataNascimento();
		this.dataInclusao = LocalDate.now();
		this.documento = dados.documentos().stream().map(Documento::new).toList();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	private LocalDate dataNascimento;
	private LocalDate dataInclusao;
	private LocalDate dataAtualizacao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "beneficiario_id")
    @JsonIgnore 
	private List<Documento> documento;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
	
	public LocalDate getDataNascimento() { return dataNascimento; }
	public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

	public LocalDate getDataInclusao() { return dataInclusao; }
	public void setDataInclusao(LocalDate dataInclusao) { this.dataInclusao = dataInclusao; }

	public LocalDate getDataAtualizacao() { return dataAtualizacao; }
	public void setDataAtualizacao(LocalDate dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

	public List<Documento> getDocumento() { return documento; }
	public void setDocumento(List<Documento> documento) { this.documento = documento; }

	public void atualizarInformacoes(DadosAtualizacaoBeneficiario dados) {
	    if (StringUtils.isNotBlank(dados.nome())) {
	        this.nome = dados.nome();
	    }
	    if (StringUtils.isNotBlank(dados.telefone())) {
	        this.telefone = dados.telefone();
	    }
	    if (dados.dataNascimento() != null) {
	        this.dataNascimento = dados.dataNascimento();
	    }
	    this.dataAtualizacao = LocalDate.now();
	}
}
