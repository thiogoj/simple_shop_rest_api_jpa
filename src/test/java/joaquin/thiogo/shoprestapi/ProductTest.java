package joaquin.thiogo.shoprestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.entity.Product;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepository;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.repository.product.ProductRepository;
import joaquin.thiogo.shoprestapi.repository.product.ProductRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.brand.BrandService;
import joaquin.thiogo.shoprestapi.service.brand.BrandServiceImpl;
import joaquin.thiogo.shoprestapi.service.product.ProductService;
import joaquin.thiogo.shoprestapi.service.product.ProductServiceImpl;
import joaquin.thiogo.shoprestapi.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductTest {

    private ProductRepository productRepository = new ProductRepositoryImpl();
    private BrandRepository brandRepository = new BrandRepositoryImpl();
    private ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());


    @Test
    void insert() {
        Product product = new Product();
        product.setName("Xiaomi Updated");
        product.setPrice(1_000_000L);
        productRepository.save(product, 4);
    }

    @Test
    void update() {
        Product product = new Product();
        product.setName("Xiaomi Updated");
        product.setPrice(5_000_000L);

        Brand brand = brandRepository.findById(4);
        product.setBrand(brand);

        productRepository.update(product, 3);
    }

    @Test
    void findAll() throws JsonProcessingException {
        String products = productService.getAllProducts();

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(products);

        System.out.println(valueAsString);
    }

    @Test
    void findById() throws JsonProcessingException {
        String productById = productService.getProductById(16);
        System.out.println(productById);
    }

    @Test
    void delete() {
        productRepository.delete(6);
    }
}


