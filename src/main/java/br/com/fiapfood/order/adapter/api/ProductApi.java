package br.com.fiapfood.order.adapter.api;

import br.com.fiapfood.order.adapter.controller.ProductController;
import br.com.fiapfood.order.adapter.dto.request.ProductRequest;
import br.com.fiapfood.order.adapter.dto.response.ProductResponse;
import br.com.fiapfood.order.adapter.mapper.ProductMapper;
import br.com.fiapfood.order.domain.enums.Category;
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
import java.util.UUID;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Access to product management")
public class ProductApi {

    private final ProductMapper productMapper;

    private final ProductController productController;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product Created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest productRequest) {
        return productController.saveProduct(productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product updated"),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<Void> deleteProduct(@PathVariable @Valid @org.hibernate.validator.constraints.UUID UUID id) {
        return productController.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable @Valid @org.hibernate.validator.constraints.UUID UUID id,
                                                         @RequestBody @Valid ProductRequest productRequest) {
        return productController.updateProduct(id, productRequest);
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search all products by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product get",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<List<ProductResponse>> findProductsByCategory(@PathVariable @Valid Category category) {
        return productController.findProductsByCategory(category);
    }

    @GetMapping("/category/{category}/status/active")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Search all products by category and status ACTIVE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product get",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponse.class))}),
            @ApiResponse(responseCode = "4xx", description = "Invalid data",
                    content = @Content),
            @ApiResponse(responseCode = "5xx", description = "Internal server error",
                    content = @Content)})
    public ResponseEntity<List<ProductResponse>> findProductsByCategoryAndActive(@PathVariable @Valid Category category) {
        return productController.findProductsByCategoryAndActive(category);
    }
}
