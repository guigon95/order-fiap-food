package br.com.fiapfood.order.adapter.dto.messaging;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class OrderMessageDto {

    private Long id;

    private List<ItemOrderMessageDto> itemOrder;

    private OrderStatus orderStatus;

    private String client;

    private LocalDateTime createdAt;

}
