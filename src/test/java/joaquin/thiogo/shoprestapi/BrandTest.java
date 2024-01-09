package joaquin.thiogo.shoprestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepository;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.brand.BrandService;
import joaquin.thiogo.shoprestapi.service.brand.BrandServiceImpl;
import joaquin.thiogo.shoprestapi.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BrandTest {

    private final BrandRepository brandRepository = new BrandRepositoryImpl();

    private final BrandService brandService = new BrandServiceImpl(brandRepository);

    @Test
    void save() {
        Brand brand = new Brand();
        brand.setName("Test");

        brandRepository.save(brand);
    }

    @Test
    void findAll() {
        brandRepository.findAll().forEach(brand -> {
            System.out.println(brand.getId() + " : " + brand.getName());
        });
    }

    @Test
    void findById() {
        Brand brand = brandRepository.findById(4);
        Assertions.assertEquals("Xiaomi", brand.getName());
    }

    @Test
    void update() {
        Brand brand = new Brand();
        brand.setName("Xiaomi");

        brandRepository.update(brand, 4);
    }

    @Test
    void remove() {
        brandRepository.delete(10);
    }

    @Test
    void getAllBrands() throws JsonProcessingException {
        String allBrands = brandService.getAllBrands();

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(allBrands);
        System.out.println(s);
    }

    @Test
    void getBrandById() throws JsonProcessingException {
        brandService.getBrandById(9);
    }


}
