package br.com.srbit.lockoptimistic.models.dto;

import br.com.srbit.lockoptimistic.models.Pedido;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class PedidoDTO {
    private Long codigoItem;
    private Integer quantidade;
    private ProdutoDTO produto;

    public PedidoDTO(Pedido pedido) {
        this.codigoItem = pedido.getCodigoItem();
        this.quantidade = pedido.getQuantidade();
        this.produto = new ProdutoDTO(pedido.getProduto());
    }

}
