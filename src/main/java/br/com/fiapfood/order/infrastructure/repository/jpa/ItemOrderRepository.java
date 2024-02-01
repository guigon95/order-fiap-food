package br.com.fiapfood.order.infrastructure.repository.jpa;

import br.com.fiapfood.order.infrastructure.entity.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ItemOrderRepository extends JpaRepository<ItemOrderEntity, UUID> {

    @Transactional
    @Modifying
    @Query("delete ItemOrderEntity i where i.order.id = ?1")
    void deleteByItemOrderId(@NonNull Long id);

    List<ItemOrderEntity> findByOrderId(Long id);
}
