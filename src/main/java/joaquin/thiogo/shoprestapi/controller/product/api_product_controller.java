package joaquin.thiogo.shoprestapi.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import joaquin.thiogo.shoprestapi.entity.Product;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepository;
import joaquin.thiogo.shoprestapi.repository.brand.BrandRepositoryImpl;
import joaquin.thiogo.shoprestapi.repository.product.ProductRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.product.ProductService;
import joaquin.thiogo.shoprestapi.service.product.ProductServiceImpl;
import joaquin.thiogo.shoprestapi.util.JsonUtil;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/api/product")
public class api_product_controller extends HttpServlet {

    private ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    private ObjectMapper objectMapper = JsonUtil.getObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");

        String json = productService.getProductById(Integer.parseInt(productId));

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product productJson = objectMapper.readValue(req.getReader(), Product.class);
        Integer brandId = Integer.parseInt(req.getParameter("brandId"));

        String json = productService.insertProduct(productJson, brandId);

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();

        Product productJson = objectMapper.readValue(req.getReader(), Product.class);

        product.setName(productJson.getName());
        product.setDescription(productJson.getDescription());
        product.setPrice(productJson.getPrice());
        product.setBrand(productJson.getBrand());

        String json = productService.updateProduct(productJson, productJson.getId());

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = productService.deleteProduct(Integer.parseInt(req.getParameter("productId")));

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }
}
