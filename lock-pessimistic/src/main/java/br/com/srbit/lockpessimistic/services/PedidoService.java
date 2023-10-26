package br.com.srbit.lockpessimistic.services;

import br.com.srbit.lockpessimistic.models.Pedido;
import br.com.srbit.lockpessimistic.models.Produto;
import br.com.srbit.lockpessimistic.models.dto.PedidoDTO;
import br.com.srbit.lockpessimistic.repositories.PedidoRepository;
import br.com.srbit.lockpessimistic.repositories.ProdutoRepository;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ResponseEntity<PedidoDTO> save(PedidoDTO pedidoDTO){

        var produto = produtoRepository.findByCodigoLock(pedidoDTO.getProduto().getCodigo());

        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        if(produto.get().getQuantidade() < pedidoDTO.getQuantidade()){
            return ResponseEntity.badRequest().build();
        }
        produto.get().setQuantidade(produto.get().getQuantidade() - pedidoDTO.getQuantidade());
        Pedido pedido = new Pedido(pedidoDTO);
        pedido.setProduto(produtoRepository.save(produto.get()));
        return ResponseEntity.ok(new PedidoDTO(pedidoRepository.save(pedido)));
    }

    public ResponseEntity<PedidoDTO> findById(Long id){
        var pedido = pedidoRepository.findById(id);
        return pedido.map(value -> ResponseEntity.ok(new PedidoDTO(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    public ResponseEntity<List<PedidoDTO>> findAll(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return ResponseEntity.ok(pedidos.stream().map(PedidoDTO::new).collect(java.util.stream.Collectors.toList()));
    }
}
