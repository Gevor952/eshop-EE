package org.example.eshopee.servlet;

import org.example.eshopee.model.Category;
import org.example.eshopee.model.Product;
import org.example.eshopee.storage.CategoryService;
import org.example.eshopee.storage.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.getCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/addProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.getCategoryById(categoryId);
        System.out.println(category);



        Product product = Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .quantity(quantity)
                .category(category)
                .build();

        productService.add(product);
        resp.sendRedirect("/product");
    }
}
