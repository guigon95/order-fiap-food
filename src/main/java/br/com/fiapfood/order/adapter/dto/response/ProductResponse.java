package br.com.fiapfood.order.adapter.dto.response;

import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductResponse {

    public UUID id;
    public String name;

    @Enumerated(EnumType.STRING)
    public Category category;

    public String description;
    public BigDecimal price;
    public String images;
    public Status status;
}
