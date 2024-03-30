package br.com.fiapfood.order.adapter.dto.response;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private Long id;

    private List<ItemOrderResponse> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private String client;

    private UUID paymentResponse;

    private LocalDateTime createdAt;

    private BigDecimal value;

    public String getCreatedAt() {
        return createdAt.toString();
    }

    public BigDecimal getValue() {

        return itemOrder.stream().map(itemOrderResponse ->
                itemOrderResponse.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(itemOrderResponse.getQuantity())))
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
