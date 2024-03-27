package br.com.fiapfood.order.adapter.dto.messaging;

import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductMessageDto {

    public String name;

    public String category;

    public String description;
    public BigDecimal price;
    public String images;
    public Status status;
}
