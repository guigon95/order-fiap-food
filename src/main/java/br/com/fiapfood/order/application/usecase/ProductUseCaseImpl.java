package br.com.fiapfood.order.application.usecase;

import br.com.fiapfood.order.application.exception.ObjectNotFoundException;
import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import br.com.fiapfood.order.domain.model.Product;
import br.com.fiapfood.order.domain.usecase.ProductUseCase;
import br.com.fiapfood.order.external.gateway.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {

    private final ProductGateway productGateway;
    @Override
    public Product createProduct(Product product) {
        return productGateway.save(product);
    }

    @Override
    public void delete(UUID id) {
        productGateway.delete(id);
    }

    @Override
    public Product update(Product product) {
        Product productOld = Optional.of(productGateway.findById(product.getId())).
                orElseThrow(() -> new ObjectNotFoundException("Product not found"));

        return productGateway.update(product, productOld);

    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productGateway.findAllByCategory(category);
    }

    @Override
    public List<Product> findByCategoryAndStatusActive(Category category) {
        return productGateway.findAllByCategoryAndStatus(category, Status.ACTIVE);
    }

    @Override
    public Product findByIdAndStatusActive(UUID id) {
        Product product = productGateway.findByIdAndStatus(id, Status.ACTIVE);
        if (product == null) {
            throw new ObjectNotFoundException("Product not found id: "+id);
        }
        return product;
    }

    @Override
    public Product findById(UUID id) {
        Product product = productGateway.findById(id);
        if (product == null) {
            throw new ObjectNotFoundException("Product not found id: "+id);
        }
        return product;
    }
}
