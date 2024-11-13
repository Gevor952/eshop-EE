package org.example.eshopee.servlet;

import org.example.eshopee.model.Product;
import org.example.eshopee.storage.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}
