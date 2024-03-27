package br.com.fiapfood.order.adapter.gateway;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiapfood.order.adapter.mapper.ProductMapper;
import br.com.fiapfood.order.domain.enums.Category;
import br.com.fiapfood.order.domain.enums.Status;
import br.com.fiapfood.order.domain.model.Product;
import br.com.fiapfood.order.external.gateway.ProductGateway;
import br.com.fiapfood.order.external.infrastructure.entity.ProductEntity;
import br.com.fiapfood.order.external.infrastructure.repository.jpa.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        Product product = productGateway.save(getProduct(uuid));

        verify(productRepository, times(1)).save(productEntity);

        assertThat(product).isInstanceOf(Product.class).isNotNull();
        assertThat(product.getId()).isEqualTo(productEntity.getId());
        assertThat(product.getName()).isEqualTo(productEntity.getName());
        assertThat(product.getPrice()).isEqualTo(productEntity.getPrice());
        assertThat(product.getImages()).isEqualTo(productEntity.getImages());
        assertThat(product.getDescription()).isEqualTo(productEntity.getDescription());
        assertThat(product.getCategory()).isEqualTo(productEntity.getCategory());
        assertThat(product.getStatus()).isEqualTo(productEntity.getStatus());

    }

    private static Product getProduct(UUID uuid) {
        return new Product(uuid, "Produto 1", Category.DRINK, "Descricao produto 1", new BigDecimal("150.00"), "Imagem", Status.ACTIVE);
    }

    private static ProductEntity getProductEntity(UUID uuid) {
        return new ProductEntity(uuid, "Produto 1", Category.DRINK, null, "Descricao produto 1", new BigDecimal("150.00"), "Imagem", Status.ACTIVE);
    }

    @Test
    void whenProductDeletedShouldUpdateStatusToDesactive() {
        ProductEntity productEntity = getProductEntity(UUID.randomUUID());

        doNothing().when(productRepository).updateStatusById(Status.DESACTIVE, productEntity.getId());

        productGateway.delete(productEntity.getId());

        verify(productRepository, times(1)).updateStatusById(Status.DESACTIVE, productEntity.getId());
    }

    @Test
    void shouldUpdateProduct() {

        UUID uuid = UUID.randomUUID();
        ProductEntity productEntity = getProductEntity(uuid);
        productEntity.setName("Product 2");
        productEntity.setPrice(new BigDecimal("15.0"));

        Product oldProduct = getProduct(uuid);
        Product newProduct = getProduct(uuid);
        newProduct.setName("Product 2");
        newProduct.setPrice(new BigDecimal("15.0"));

        when(productRepository.save(any(ProductEntity.class))).thenReturn(productEntity);

        Product updated = productGateway.update(newProduct, oldProduct);

        verify(productRepository, times(1)).save(any(ProductEntity.class));

        assertThat(updated).isNotNull().isInstanceOf(Product.class);
        assertThat(updated.getId()).isEqualTo(uuid);
        assertThat(updated.getName()).isEqualTo(productEntity.getName());
        assertThat(updated.getImages()).isEqualTo(productEntity.getImages());
        assertThat(updated.getPrice()).isEqualTo(productEntity.getPrice());
        assertThat(updated.getDescription()).isEqualTo(productEntity.getDescription());
        assertThat(updated.getStatus()).isEqualTo(productEntity.getStatus());
        assertThat(updated.getCategory()).isEqualTo(productEntity.getCategory());
    }

    @Test
    void findAllByCategory() {

        ProductEntity productEntity = getProductEntity(UUID.randomUUID());
        ProductEntity productEntity2 = getProductEntity(UUID.randomUUID());
        productEntity2.setName("Product 2");
        productEntity2.setPrice(new BigDecimal("200.00"));

        when(productRepository.findAllByCategory(any(Category.class))).thenReturn(Arrays.asList(productEntity, productEntity2));

        List<Product> allByCategory = productGateway.findAllByCategory(Category.DRINK);

        verify(productRepository, times(1)).findAllByCategory(any(Category.class));

        assertThat(allByCategory).isNotNull().hasSize(2).containsExactlyInAnyOrder(productMapper.productEntityToProduct(productEntity), productMapper.productEntityToProduct(productEntity2));

    }

    @Test
    void findById() {

        UUID uuid = UUID.randomUUID();
        ProductEntity productEntity = getProductEntity(uuid);

        when(productRepository.findById(any(UUID.class))).thenReturn(Optional.of(productEntity));

        Product product = productGateway.findById(uuid);

        verify(productRepository, times(1)).findById(uuid);

        assertThat(product).isNotNull().isInstanceOf(Product.class);
        assertThat(product.getId()).isEqualTo(productEntity.getId());
        assertThat(product.getName()).isEqualTo(productEntity.getName());
        assertThat(product.getPrice()).isEqualTo(productEntity.getPrice());
        assertThat(product.getImages()).isEqualTo(productEntity.getImages());
        assertThat(product.getStatus()).isEqualTo(productEntity.getStatus());
        assertThat(product.getDescription()).isEqualTo(productEntity.getDescription());
        assertThat(product.getCategory()).isEqualTo(productEntity.getCategory());

    }

    @Test
    void findAllByCategoryAndStatus() {

        ProductEntity productEntity = getProductEntity(UUID.randomUUID());
        ProductEntity productEntity2 = getProductEntity(UUID.randomUUID());
        productEntity2.setName("Product 2");
        productEntity2.setPrice(new BigDecimal("200.00"));

        when(productRepository.findAllByCategoryAndStatus(any(Category.class), any(Status.class))).thenReturn(Arrays.asList(productEntity, productEntity2));

        List<Product> allByCategory = productGateway.findAllByCategoryAndStatus(Category.DRINK, Status.ACTIVE);

        verify(productRepository, times(1)).findAllByCategoryAndStatus(any(Category.class), any(Status.class));

        assertThat(allByCategory).isNotNull().hasSize(2).containsExactlyInAnyOrder(productMapper.productEntityToProduct(productEntity), productMapper.productEntityToProduct(productEntity2));


    }

    @Test
    void findByIdAndStatus() {

        UUID uuid = UUID.randomUUID();
        ProductEntity productEntity = getProductEntity(uuid);
        when(productRepository.findByIdAndStatus(uuid, Status.ACTIVE)).thenReturn(Optional.of(productEntity));

        Product product = productGateway.findByIdAndStatus(uuid, Status.ACTIVE);

        verify(productRepository, times(1)).findByIdAndStatus(any(UUID.class), any(Status.class));

        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(productEntity.getId());
        assertThat(product.getName()).isEqualTo(productEntity.getName());
        assertThat(product.getStatus()).isEqualTo(productEntity.getStatus());
        assertThat(product.getImages()).isEqualTo(productEntity.getImages());
        assertThat(product.getCategory()).isEqualTo(productEntity.getCategory());
        assertThat(product.getPrice()).isEqualTo(productEntity.getPrice());
        assertThat(product.getDescription()).isEqualTo(productEntity.getDescription());
    }
}