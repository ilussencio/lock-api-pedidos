package br.com.srbit.lockpessimistic.services;

import br.com.srbit.lockpessimistic.models.Produto;
import br.com.srbit.lockpessimistic.models.dto.ProdutoDTO;
import br.com.srbit.lockpessimistic.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ResponseEntity<ProdutoDTO> save(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);
        return ResponseEntity.ok(new ProdutoDTO(produtoRepository.save(produto)));
    }
    @Transactional
    public ResponseEntity<ProdutoDTO> update(ProdutoDTO produtoDTO){
        Produto produto = new Produto(produtoDTO);
        return ResponseEntity.ok(new ProdutoDTO(produtoRepository.save(produto)));
    }

    public ResponseEntity<ProdutoDTO> findById(Long id){
        var produto = produtoRepository.findByCodigoLock(id);
        return produto.map(value -> ResponseEntity.ok(new ProdutoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<ProdutoDTO>> findAll(){
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList()));
    }
}
