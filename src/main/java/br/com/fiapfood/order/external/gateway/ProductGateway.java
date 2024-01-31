package br.com.fiapfood.order.external.gateway;

import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import br.com.fiapfood.order.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductGateway {

    Product save(Product product);
    void delete(UUID id);
    Product update(Product product, Product productOld );

    List<Product> findAllByCategory(Category category);

    Product findById(UUID id);
    List<Product> findAllByCategoryAndStatus(Category category, Status status);

    Product findByIdAndStatus(UUID id, Status status);
}
