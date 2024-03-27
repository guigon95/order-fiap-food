package br.com.fiapfood.order.adapter.mapper;

import br.com.fiapfood.order.adapter.dto.messaging.OrderMessageDto;
import br.com.fiapfood.order.adapter.dto.request.ItemOrderRequest;
import br.com.fiapfood.order.adapter.dto.request.OrderRequest;
import br.com.fiapfood.order.adapter.dto.response.OrderResponse;
import br.com.fiapfood.order.domain.model.ItemOrder;
import br.com.fiapfood.order.domain.model.Order;
import br.com.fiapfood.order.domain.model.Product;
import br.com.fiapfood.order.domain.usecase.ProductUseCase;
import br.com.fiapfood.order.external.infrastructure.entity.OrderEntity;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = ItemOrderMapper.class)
public abstract class OrderMapper {

    @Autowired
    private ProductUseCase productUseCase;

    public abstract Order orderEntityToOrder(OrderEntity orderEntity);

    public abstract OrderEntity orderToOrderEntity(Order order);

    @Mapping(target = "itemOrder", source = "itemOrder", qualifiedByName = "fromItemOrderRequestToItemOrder")
    public abstract Order orderRequestToOrder(OrderRequest orderRequest);


    @Named("fromItemOrderRequestToItemOrder")
    protected List<ItemOrder> fromItemOrderRequestToItemOrder(List<ItemOrderRequest> itemOrderRequest) {

        List<ItemOrder> itemOrders = new ArrayList<>();

        for (ItemOrderRequest itemOrderReq: itemOrderRequest) {
            Product product = productUseCase.findByIdAndStatusActive(itemOrderReq.productId);
            itemOrders.add(new ItemOrder(product, null, itemOrderReq.getQuantity()));
        }
        return itemOrders;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    public abstract void updateOrderEntityFromOrder(Order order, @MappingTarget OrderEntity orderEntity);

    public abstract OrderResponse orderToOrderResponse(Order order);

    public abstract OrderMessageDto orderToOrderMessageDto(Order order);
}
