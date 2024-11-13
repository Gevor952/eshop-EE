package org.example.eshopee.servlet;

import org.example.eshopee.model.Category;
import org.example.eshopee.storage.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> arrCat = categoryService.getCategories();
        System.out.println(arrCat);
        req.setAttribute("categories", arrCat);
        req.getRequestDispatcher("/category.jsp").forward(req, resp);

    }
}
