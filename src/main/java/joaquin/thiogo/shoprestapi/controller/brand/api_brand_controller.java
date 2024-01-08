package joaquin.thiogo.shoprestapi.controller.brand;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import joaquin.thiogo.shoprestapi.entity.Brand;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.brand.BrandService;
import joaquin.thiogo.shoprestapi.service.brand.BrandServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/brand")
public class api_brand_controller extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl(new BrandRepositoryImpl());

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String json = brandService.getBrandById(Integer.parseInt(id));

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Brand brand = new Brand();

        Brand brandJson = objectMapper.readValue(req.getReader(), Brand.class);
        brand.setName(brandJson.getName());

        String json = brandService.insertBrand(brand);

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Brand brand = new Brand();

        Brand brandJson = objectMapper.readValue(req.getReader(), Brand.class);
        brand.setName(brandJson.getName());

        String json = brandService.updateBrand(brand, brandJson.getId());

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Brand brandJson = objectMapper.readValue(req.getReader(), Brand.class);

        String json = brandService.deleteBrand(brandJson.getId());

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }
}
