package br.com.fiapfood.order.application.usecase;

import br.com.fiapfood.order.domain.model.Order;
import br.com.fiapfood.order.domain.usecase.OrderUseCase;
import br.com.fiapfood.order.external.gateway.OrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderGateway orderGateway;

    @Override
    public List<Order> findAll() {
        return orderGateway.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderGateway.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return orderGateway.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderGateway.update(order);
    }
}
