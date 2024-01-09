package joaquin.thiogo.shoprestapi.repository.product;

import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.entity.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product, Integer brandId);

    List<Product> findAll();

    Product findById(Integer productId);

    void update(Product product, Integer productId);

    void delete(Integer productId);

}
