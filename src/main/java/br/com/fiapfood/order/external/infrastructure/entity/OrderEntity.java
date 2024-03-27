package br.com.fiapfood.order.external.infrastructure.entity;

import br.com.fiapfood.order.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<ItemOrderEntity> itemOrder;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "client_id")
    private String client;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
