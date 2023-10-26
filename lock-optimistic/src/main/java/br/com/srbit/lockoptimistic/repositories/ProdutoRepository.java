package br.com.srbit.lockoptimistic.repositories;

import br.com.srbit.lockoptimistic.models.Produto;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("select p from Produto p where p.codigo = :codigo")
    Optional<Produto> findByCodigoLock(@Param("codigo") Long codigo);
}
