package br.com.srbit.lockoptimistic.controllers;

import br.com.srbit.lockoptimistic.models.dto.ProdutoDTO;
import br.com.srbit.lockoptimistic.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.save(produtoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id){
        return produtoService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll(){
        return produtoService.findAll();
    }
}
