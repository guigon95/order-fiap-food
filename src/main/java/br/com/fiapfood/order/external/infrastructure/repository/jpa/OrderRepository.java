package br.com.fiapfood.order.external.infrastructure.repository.jpa;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import br.com.fiapfood.order.external.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderStatus = ?1 WHERE o.id = ?2")
    void updateStatus(OrderStatus Status, Long orderId);
}
