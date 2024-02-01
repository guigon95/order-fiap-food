package br.com.fiapfood.order.adapter.controller;

import br.com.fiapfood.order.adapter.dto.request.OrderRequest;
import br.com.fiapfood.order.adapter.dto.response.OrderResponse;
import br.com.fiapfood.order.adapter.mapper.OrderMapper;
import br.com.fiapfood.order.domain.usecase.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;

    private final OrderUseCase orderUseCase;


    public ResponseEntity<List<OrderResponse>> findAllOrders(){

        return ResponseEntity.ok(
                orderUseCase.findAll()
                        .stream()
                        .map(orderMapper::orderToOrderResponse).collect(Collectors.toList()));
    }


    public ResponseEntity<OrderResponse> getOrderById(Long id){
        return ResponseEntity.ok( orderMapper.orderToOrderResponse(orderUseCase.findById(id)));
    }


    public ResponseEntity<OrderResponse> saveOrder(OrderRequest orderRequest){
        var order = orderMapper.orderRequestToOrder(orderRequest);
        return ResponseEntity.ok(orderMapper.orderToOrderResponse(orderUseCase.createOrder(order)));
    }


    public ResponseEntity<OrderResponse> updateOrder(Long id, OrderRequest orderRequest){

        var order = orderMapper.orderRequestToOrder(orderRequest);
        order.setId(id);

        var updatedOrder = orderUseCase.updateOrder(order);
        return ResponseEntity.ok(orderMapper.orderToOrderResponse(updatedOrder));
    }
}
