package br.com.srbit.lockpessimistic.models.dto;

import br.com.srbit.lockpessimistic.models.Produto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ProdutoDTO {

    private Long codigo;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private int codigoVrs;

    public ProdutoDTO(Produto produto) {
        this.codigo = produto.getCodigo();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.codigoVrs = produto.getCodigoVrs();
    }
}
