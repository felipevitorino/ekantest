package br.com.ekan.domain.documento;

import java.time.LocalDate;

import br.com.ekan.domain.beneficiario.Beneficiario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String descricao;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;
    
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
    
    public Documento() {}
    
    public Documento(DadosCadastroDocumento dado) {
    	this.tipoDocumento = dado.tipoDocumento();
    	this.descricao     = dado.descricao();
    	this.dataInclusao  = LocalDate.now();
    	this.beneficiario  = dado.beneficiario();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public LocalDate getDataInclusao() { return dataInclusao; }
    public void setDataInclusao(LocalDate dataInclusao) { this.dataInclusao = dataInclusao; }
    
    public LocalDate getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(LocalDate dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }
    
    public Beneficiario getBeneficiario() { return beneficiario; }
    public void setBeneficiario(Beneficiario beneficiario) { this.beneficiario = beneficiario; }

}