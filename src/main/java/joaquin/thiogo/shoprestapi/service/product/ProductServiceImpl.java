package joaquin.thiogo.shoprestapi.service.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.entity.Product;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepository;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.repository.product.ProductRepository;
import joaquin.thiogo.shoprestapi.util.JsonUtil;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private BrandRepository brandRepository = new BrandRepositoryImpl();

    private ObjectMapper objectMapper = JsonUtil.getObjectMapper();

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public String getAllProducts() throws JsonProcessingException {
        List<Product> products = productRepository.findAll();

        String json = objectMapper.writeValueAsString(products);
        return json;
    }

    @Override
    public String getProductById(Integer productId) throws JsonProcessingException {
        Product product = productRepository.findById(productId);

        if (product != null) {
            String json = objectMapper.writeValueAsString(product);

            return json;
        }

        String productNull = objectMapper.writeValueAsString(Map.of(
                "message", "Product is null"
        ));

        return productNull;
    }

    @Override
    public String insertProduct(Product product, Integer brandId) throws JsonProcessingException {

        Brand brand = brandRepository.findById(brandId);

        if (brand != null) {
            productRepository.save(product, brandId);

            String json = objectMapper.writeValueAsString(Map.of(
                    "id", product.getId(),
                    "name", product.getName(),
                    "description", product.getDescription(),
                    "brand", Map.of(
                            "id", brand.getId(),
                            "name", brand.getName()
                    )
            ));

            return json;
        }

        String nullJson = objectMapper.writeValueAsString(Map.of(
                "message", "Brand is not found"
        ));

        return nullJson;
    }

    @Override
    public String updateProduct(Product product, Integer productId) throws JsonProcessingException {
        Product isProduct = productRepository.findById(productId);

        if (isProduct != null) {
            productRepository.update(product, productId);
            Brand brand = brandRepository.findById(product.getBrand().getId());

            String json = objectMapper.writeValueAsString(Map.of(
                    "id", product.getId(),
                    "name", product.getName(),
                    "description", product.getDescription(),
                    "brand", Map.of(
                            "id", brand.getId(),
                            "name", brand.getName()
                    )
            ));

            return json;
        }

        String nullJson = objectMapper.writeValueAsString(Map.of(
                "message", "Product is null"
        ));

        return nullJson;
    }

    @Override
    public String deleteProduct(Integer productId) throws JsonProcessingException {
        Product isProduct = productRepository.findById(productId);

        if (isProduct != null) {
            productRepository.delete(productId);

            String json = objectMapper.writeValueAsString(Map.of(
                    "message", productId + " success deleted"
            ));

            return json;
        }

        String nullJson = objectMapper.writeValueAsString(Map.of(
                "message", "Product is null"
        ));

        return nullJson;
    }
}
