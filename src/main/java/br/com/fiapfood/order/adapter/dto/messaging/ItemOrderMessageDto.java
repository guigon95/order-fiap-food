package br.com.fiapfood.order.adapter.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemOrderMessageDto {

    private ProductMessageDto product;
    private Integer quantity;
}
