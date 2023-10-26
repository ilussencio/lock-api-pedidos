package br.com.srbit.lockpessimistic.controllers;

import br.com.srbit.lockpessimistic.models.dto.PedidoDTO;
import br.com.srbit.lockpessimistic.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> save(@RequestBody PedidoDTO pedidoDTO){
        return pedidoService.save(pedidoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
        return pedidoService.findById(id);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return pedidoService.findAll();
    }

}
