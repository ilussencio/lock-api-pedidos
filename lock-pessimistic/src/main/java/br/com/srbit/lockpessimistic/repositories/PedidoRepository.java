package br.com.srbit.lockpessimistic.repositories;

import br.com.srbit.lockpessimistic.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
