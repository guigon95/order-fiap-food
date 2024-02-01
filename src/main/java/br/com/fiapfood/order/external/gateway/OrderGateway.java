package br.com.fiapfood.order.external.gateway;

import br.com.fiapfood.order.domain.model.Order;

import java.util.List;

public interface OrderGateway {

    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);
    Order update(Order order);
}
