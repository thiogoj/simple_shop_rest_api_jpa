package joaquin.thiogo.shoprestapi.service.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.entity.Product;

public interface ProductService {
    String getAllProducts() throws JsonProcessingException;

    String getProductById(Integer productId) throws JsonProcessingException;

    String insertProduct(Product product, Integer brandId) throws JsonProcessingException;

    String updateProduct(Product product, Integer productId) throws JsonProcessingException;

    String deleteProduct(Integer productId) throws JsonProcessingException;
}
