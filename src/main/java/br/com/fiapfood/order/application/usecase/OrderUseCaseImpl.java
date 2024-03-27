package br.com.fiapfood.order.application.usecase;

import br.com.fiapfood.order.domain.model.Order;
import br.com.fiapfood.order.domain.usecase.OrderUseCase;
import br.com.fiapfood.order.external.gateway.OrderConsumerGateway;
import br.com.fiapfood.order.external.gateway.OrderGateway;
import br.com.fiapfood.order.external.gateway.OrderProducerGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderGateway orderGateway;
    private final OrderConsumerGateway orderConsumerGateway;
    private final OrderProducerGateway orderProducerGateway;

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

    @Scheduled(fixedDelay = 5000)
    @Override
    @Transactional
    public void orderConsumerQueue() {

        String orderId = orderConsumerGateway.orderConsumer();

        if(orderId == null) return;

        Order order = orderGateway.findById(Long.parseLong(orderId));

        order.nextStatus();
        orderGateway.updateStatus(order);

        orderProducerGateway.publishMessage(order);

    }
}
