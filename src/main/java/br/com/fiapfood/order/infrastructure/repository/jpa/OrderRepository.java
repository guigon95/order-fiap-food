package br.com.fiapfood.order.infrastructure.repository.jpa;

import br.com.fiapfood.order.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
