package br.com.fiapfood.order.adapter.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemOrderResponse {

    public ProductResponse product;

    public Integer quantity;
}
