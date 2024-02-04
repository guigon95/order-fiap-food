package br.com.fiapfood.order.adapter.gateway;

import br.com.fiapfood.order.adapter.mapper.OrderMapper;
import br.com.fiapfood.order.adapter.mapper.ProductMapper;
import br.com.fiapfood.order.external.gateway.OrderGateway;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class OrderGatewayImplTest {

    private OrderGateway orderGateway;

    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    void shouldFindAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }
}