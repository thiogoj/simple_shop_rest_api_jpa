package joaquin.thiogo.shoprestapi.service.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import joaquin.thiogo.shoprestapi.entity.Brand;

public interface ProductService {
    String getAllProducts() throws JsonProcessingException;

    String getProductById(Integer brandid) throws JsonProcessingException;

    String insertProduct(Brand brand) throws JsonProcessingException;

    String updateProduct(Brand brand, Integer brandId) throws JsonProcessingException;

    String deleteProduct(Integer brandId) throws JsonProcessingException;
}
