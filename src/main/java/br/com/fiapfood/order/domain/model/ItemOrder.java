package br.com.fiapfood.order.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemOrder {

    private Product product;

    private Order order;

    private Integer quantity;
}
