package joaquin.thiogo.shoprestapi;

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
import joaquin.thiogo.shoprestapi.util.JpaUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductTest {

    private ProductRepository productRepository = new ProductRepositoryImpl();
    private BrandRepository brandRepository = new BrandRepositoryImpl();

    @Test
    void insert() {
        Product product = new Product();
        product.setName("Untuk dihapus");
        product.setPrice(1_000_000L);

        Brand brand = brandRepository.findById(5);
        product.setBrand(brand);
        productRepository.save(product);
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
    void findAll() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println("Brand " + product.getBrand().getName());
            System.out.println("Product " + product.getName());
            System.out.println("Price " + product.getPrice());
        }
    }

    @Test
    void findById() {
        Product product = productRepository.findById(1);
        Assertions.assertEquals("Xiaomi", product.getBrand().getName());
    }

    @Test
    void delete() {
        productRepository.delete(6);
    }
}


