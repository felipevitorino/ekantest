package br.com.ekan.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ekan.domain.beneficiario.Beneficiario;
import br.com.ekan.domain.beneficiario.BeneficiarioRepository;
import br.com.ekan.domain.beneficiario.DadosAtualizacaoBeneficiario;
import br.com.ekan.domain.beneficiario.DadosCadastroBeneficiario;
import br.com.ekan.domain.beneficiario.DadosDetalhamentoBeneficiario;
import br.com.ekan.domain.beneficiario.DadosListagemBeneficiario;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {
    
    @Autowired
    private BeneficiarioRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemBeneficiario>> listar(@PageableDefault(size = 100) Pageable paginacao) {
    	var page = repository.findAll(paginacao).map(DadosListagemBeneficiario::new);
    	return ResponseEntity.ok(page);
    }
    
    @PostMapping
    public ResponseEntity<DadosDetalhamentoBeneficiario> cadastrar(@RequestBody DadosCadastroBeneficiario dados, UriComponentsBuilder uriBuilder) {
        var beneficiario = new Beneficiario(dados);
        repository.save(beneficiario);
        
        URI uri = uriBuilder.path("/beneficiarios/{id}").buildAndExpand(beneficiario.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamentoBeneficiario(beneficiario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoBeneficiario> atualizar(@RequestBody DadosAtualizacaoBeneficiario dados) {
    	var beneficiario = repository.getReferenceById(dados.id());
    	beneficiario.atualizarInformacoes(dados);
    	
		return ResponseEntity.ok(new DadosDetalhamentoBeneficiario(beneficiario));
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
    	repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
