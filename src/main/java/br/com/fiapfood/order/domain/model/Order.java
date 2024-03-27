package br.com.fiapfood.order.domain.model;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    private Long id;

    private List<ItemOrder> itemOrder;

    private OrderStatus orderStatus;

    private String client;

    private LocalDateTime createdAt;

    public void nextStatus(){
        if(OrderStatus.RECEIVED.equals(this.orderStatus)){
            this.orderStatus = OrderStatus.IN_PROGRESS;
        }
        else if (OrderStatus.IN_PROGRESS.equals(this.orderStatus)){
            this.orderStatus = OrderStatus.READY;
        }
        else if (OrderStatus.READY.equals(this.orderStatus)){
            this.orderStatus = OrderStatus.FINISHED;
        }

    }
}
