package joaquin.thiogo.shoprestapi.repository.brand;

import joaquin.thiogo.shoprestapi.entity.Brand;

import java.util.List;

public interface BrandRepository {

    void save(Brand brand);

    List<Brand> findAll();

    Brand findById(Integer id);

    void update(Brand brand, Integer id);

    void delete(Integer id);

}
