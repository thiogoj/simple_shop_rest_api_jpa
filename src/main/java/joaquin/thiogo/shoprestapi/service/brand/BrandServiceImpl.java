package joaquin.thiogo.shoprestapi.service.brand;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepository;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.util.JsonUtil;

import java.util.List;
import java.util.Map;

public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    private final ObjectMapper objectMapper = JsonUtil.getObjectMapper();

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public String getAllBrands() throws JsonProcessingException {
        List<Brand> brands = brandRepository.findAll();
        String json = objectMapper.writeValueAsString(brands);

        return json;
    }

    @Override
    public String getBrandById(Integer brandId) throws JsonProcessingException {
        Brand brand = brandRepository.findById(brandId);

        if (brand != null) {
            String json = objectMapper.writeValueAsString(brand);

            return json;
        }

        String brandIsNull = objectMapper.writeValueAsString(Map.of(
                "message", "Brand is null"
        ));

        return brandIsNull;
    }

    @Override
    public String insertBrand(Brand brand) throws JsonProcessingException {
        brandRepository.save(brand);

        String json = objectMapper.writeValueAsString(Map.of(
                "id", brand.getId(),
                "name", brand.getName()
        ));

        return json;
    }

    @Override
    public String updateBrand(Brand brand, Integer brandId) throws JsonProcessingException {
        Brand isTrue = brandRepository.findById(brandId);

        if (isTrue != null) {
            brandRepository.update(brand, brandId);

            String json = objectMapper.writeValueAsString(Map.of(
                    "id", brandId,
                    "name", brand.getName()
            ));

            return json;
        }

        String brandIsNull = objectMapper.writeValueAsString(Map.of(
                "message", "Brand is null"
        ));

        return brandIsNull;
    }

    @Override
    public String deleteBrand(Integer brandId) throws JsonProcessingException {
        Brand isTrue = brandRepository.findById(brandId);

        if (isTrue != null) {
            brandRepository.delete(brandId);

            String json = objectMapper.writeValueAsString(Map.of(
                    "message", brandId + " success deleted"
            ));

            return json;
        }

        String brandIsNull = objectMapper.writeValueAsString(Map.of(
                "message", "Brand is null"
        ));

        return brandIsNull;
    }
}
