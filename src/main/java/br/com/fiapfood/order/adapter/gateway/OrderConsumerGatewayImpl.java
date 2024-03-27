package br.com.fiapfood.order.adapter.gateway;

import br.com.fiapfood.order.external.gateway.OrderConsumerGateway;
import br.com.fiapfood.order.external.infrastructure.messaging.OrderConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderConsumerGatewayImpl implements OrderConsumerGateway {

    private final OrderConsumer orderConsumer;

    @Override
    public String orderConsumer() {
        return orderConsumer.consumeMessages();
    }
}
