package br.com.fiapfood.order.adapter.dto.response;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
public class OrderResponse {

    private Long id;

    private List<ItemOrderResponse> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private UUID client;

    private UUID paymentResponse;

    private LocalDateTime createdAt;
}
