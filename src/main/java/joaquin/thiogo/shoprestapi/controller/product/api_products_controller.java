package joaquin.thiogo.shoprestapi.controller.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import joaquin.thiogo.shoprestapi.repository.product.ProductRepositoryImpl;
import joaquin.thiogo.shoprestapi.service.product.ProductService;
import joaquin.thiogo.shoprestapi.service.product.ProductServiceImpl;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/products")
public class api_products_controller extends HttpServlet {

    private ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = productService.getAllProducts();

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(json);
    }
}
