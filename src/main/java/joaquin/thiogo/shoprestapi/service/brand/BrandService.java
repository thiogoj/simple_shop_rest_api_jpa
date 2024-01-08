package joaquin.thiogo.shoprestapi.service.brand;

import com.fasterxml.jackson.core.JsonProcessingException;
import joaquin.thiogo.shoprestapi.entity.Brand;

import java.util.List;

public interface BrandService {

    String getAllBrands() throws JsonProcessingException;

    String getBrandById(Integer brandid) throws JsonProcessingException;

    String insertBrand(Brand brand) throws JsonProcessingException;

    String updateBrand(Brand brand, Integer brandId) throws JsonProcessingException;

    String deleteBrand(Integer brandId) throws JsonProcessingException;

}
