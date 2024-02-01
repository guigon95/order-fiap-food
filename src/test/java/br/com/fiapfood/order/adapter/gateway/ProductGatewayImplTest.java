package br.com.fiapfood.order.adapter.gateway;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiapfood.order.adapter.mapper.ProductMapper;
import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import br.com.fiapfood.order.domain.model.Product;
import br.com.fiapfood.order.external.gateway.ProductGateway;
import br.com.fiapfood.order.infrastructure.entity.ItemOrderEntity;
import br.com.fiapfood.order.infrastructure.entity.ProductEntity;
import br.com.fiapfood.order.infrastructure.repository.jpa.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductGatewayImplTest {

    private ProductGateway productGateway;

    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);
    @Mock
    private ProductRepository productRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        productGateway = new ProductGatewayImpl(productRepository, productMapper);

    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void shouldSaveProduct() {

        UUID uuid = UUID.randomUUID();
        ProductEntity productEntity = getProductEntity(uuid);
        when(productRepository.save(any(ProductEntity.class))).thenAnswer(i -> i.getArgument(0));

        Product product = productGateway.save(new Product(uuid, "Produto 1", Category.DRINK, "Descricao produto 1", new BigDecimal("150.00"), "Imagem", Status.ACTIVE));

        assertThat(product).isInstanceOf(Product.class).isNotNull();
        assertThat(product.getId()).isEqualTo(productEntity.getId());
        assertThat(product.getName()).isEqualTo(productEntity.getName());
        assertThat(product.getPrice()).isEqualTo(productEntity.getPrice());
        assertThat(product.getImages()).isEqualTo(productEntity.getImages());
        assertThat(product.getDescription()).isEqualTo(productEntity.getDescription());
        assertThat(product.getCategory()).isEqualTo(productEntity.getCategory());
        assertThat(product.getStatus()).isEqualTo(productEntity.getStatus());

    }

    private static ProductEntity getProductEntity(UUID uuid) {
        return new ProductEntity(uuid, "Produto 1", Category.DRINK, null, "Descricao produto 1", new BigDecimal("150.00"), "Imagem", Status.ACTIVE);
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void findAllByCategory() {
    }

    @Test
    void findById() {
    }

    @Test
    void findAllByCategoryAndStatus() {
    }

    @Test
    void findByIdAndStatus() {
    }
}