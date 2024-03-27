package br.com.fiapfood.order.external.gateway;

import br.com.fiapfood.order.domain.model.Order;

public interface OrderProducerGateway {

    void publishMessage(Order message);
}
