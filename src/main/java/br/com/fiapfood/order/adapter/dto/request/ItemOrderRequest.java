package br.com.fiapfood.order.adapter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class ItemOrderRequest {


    @NotNull(message = "The field product_id cannot be empty.")
    @JsonProperty("product_id")
    @Schema(description = "id from product")
    public UUID productId;

    @NotNull(message = "The field quantity cannot be empty.")
    @Min(value = 1, message = "The field quantity cannot be less than 1.")
    @JsonProperty("quantity")
    @Schema(description = "quantity of products requested")
    public Integer quantity;
}
