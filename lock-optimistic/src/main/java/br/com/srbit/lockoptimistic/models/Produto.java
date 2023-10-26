package br.com.srbit.lockoptimistic.models;

import br.com.srbit.lockoptimistic.models.dto.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String descricao;
    private Double preco;
    private Integer quantidade;

    @Version
    private int codigoVrs;

    public Produto(ProdutoDTO produtoDTO){
        this.codigo = produtoDTO.getCodigo();
        this.descricao = produtoDTO.getDescricao();
        this.preco = produtoDTO.getPreco();
        this.quantidade = produtoDTO.getQuantidade();
        this.codigoVrs = produtoDTO.getCodigoVrs();
    }
}
