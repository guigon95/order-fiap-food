package br.com.fiapfood.order.domain.usecase;

import br.com.fiapfood.order.domain.model.Order;

import java.util.List;

public interface OrderUseCase {
    public List<Order> findAll();

    public Order findById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void orderConsumerQueue();
}
