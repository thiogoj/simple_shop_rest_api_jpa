package joaquin.thiogo.shoprestapi.controller.brand;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.brand.BrandService;
import joaquin.thiogo.shoprestapi.service.brand.BrandServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/brands")
public class api_brands_controller extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl(new BrandRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = brandService.getAllBrands();

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }
}
