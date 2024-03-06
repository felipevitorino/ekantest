package br.com.ekan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.domain.documento.DocumentoDTO;
import br.com.ekan.domain.documento.DocumentoRepository;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {
	
	@Autowired
	private DocumentoRepository repository;

	@GetMapping("/beneficiario/{beneficiarioId}")
    public ResponseEntity<List<DocumentoDTO>> getDocumentosByBeneficiarioId(@PathVariable Long beneficiarioId) {
		var result = repository.findByBeneficiarioId(beneficiarioId)
		        .stream()
		        .map(DocumentoDTO::new)
		        .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
