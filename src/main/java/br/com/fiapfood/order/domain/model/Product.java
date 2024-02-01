package br.com.fiapfood.order.domain.model;

import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@Builder
@Data
public class Product {
    private UUID id;
    private String name;
    private Category category;
    private String description;
    private BigDecimal price;
    private String images;
    private Status status;
}
