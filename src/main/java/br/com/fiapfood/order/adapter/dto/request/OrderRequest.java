package br.com.fiapfood.order.adapter.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class OrderRequest {

    @NotEmpty(message = "The field item_order cannot be empty.")
    @JsonProperty("item_order")
    @Valid
    @Schema(description = "list the of products with quantity")
    public List<ItemOrderRequest> itemOrder;

    @CPF(message = "The field cpf has be document.")
    @Schema (description = "client identifier")
    public String client;
}
