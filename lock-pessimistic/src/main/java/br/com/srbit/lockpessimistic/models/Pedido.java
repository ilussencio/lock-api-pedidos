package br.com.srbit.lockpessimistic.models;

import br.com.srbit.lockpessimistic.models.dto.PedidoDTO;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoItem;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Produto produto;

    public Pedido(PedidoDTO pedidoDTO) {
        this.codigoItem = pedidoDTO.getCodigoItem();
        this.quantidade = pedidoDTO.getQuantidade();
        this.produto = new Produto(pedidoDTO.getProduto());
    }
}
