package br.com.fiapfood.order.adapter.gateway;

import br.com.fiapfood.order.adapter.mapper.OrderMapper;
import br.com.fiapfood.order.domain.model.Order;
import br.com.fiapfood.order.external.gateway.OrderProducerGateway;
import br.com.fiapfood.order.adapter.dto.messaging.OrderMessageDto;
import br.com.fiapfood.order.external.infrastructure.messaging.OrderProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderProducerGatewayImpl implements OrderProducerGateway {

    private final OrderProducer orderProducer;

    private final OrderMapper orderMapper;

    private final ObjectMapper objectMapper;

    @Override
    public void publishMessage(Order order) {
        OrderMessageDto orderMessageDto = orderMapper.orderToOrderMessageDto(order);
        orderProducer.publishMessage(orderMessageDto);
    }
}
