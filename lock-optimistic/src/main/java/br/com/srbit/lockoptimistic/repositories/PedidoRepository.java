package br.com.srbit.lockoptimistic.repositories;

import br.com.srbit.lockoptimistic.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
