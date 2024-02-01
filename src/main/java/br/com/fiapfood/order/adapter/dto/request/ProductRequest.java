package br.com.fiapfood.order.adapter.dto.request;

import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class ProductRequest {

    @NotEmpty(message = "The field name cannot be empty.")
    @Schema(description = "product name")
    public String name;
    @NotNull(message = "The field category cannot be empty.")
    @Enumerated(EnumType.STRING)
    @Schema(description = "product type")
    public Category category;
    @NotEmpty(message = "The field description cannot be empty.")
    @Schema(description = "short description about the product")
    public String description;
    @Min(value = 0, message = "The field price cannot be less than 0.")
    @Schema(description = "price of the product")
    public BigDecimal price;
    @NotEmpty(message = "The field status images be empty.")
    @Schema(description = "product images")
    public String images;
    @NotNull(message = "The field status cannot be null.")
    @Enumerated(EnumType.STRING)
    @Schema(description = "product status")
    public Status status;
}
