package br.com.fiapfood.order.adapter.api;

import br.com.fiapfood.order.adapter.controller.OrderController;
import br.com.fiapfood.order.adapter.dto.request.OrderRequest;
import br.com.fiapfood.order.adapter.dto.response.OrderResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Tag(name = "Orders", description  = "Access to order management")
public class OrderApi {

    private final OrderController orderController;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List All Orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders Listed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<List<OrderResponse>> findAllOrders() {
        return orderController.findAllOrders();
    }

    @Operation(summary = "Find a order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class))}),
            @ApiResponse(responseCode = "404", description = "Order not found",
                    content = @Content),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable @Schema(description = "order id") Long id) {
        return orderController.getOrderById(id);
    }

    @Operation(summary = "Create a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    @PostMapping
    public ResponseEntity<OrderResponse> saveOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderController.saveOrder(orderRequest);
    }

    @Operation(summary = "update a order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OrderResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable @Schema(description = "order id") Long id, @Valid @RequestBody OrderRequest orderRequest) {
        return orderController.updateOrder(id, orderRequest);
    }
}
