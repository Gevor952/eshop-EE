package org.example.eshopee.servlet;

import org.example.eshopee.model.Category;
import org.example.eshopee.storage.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addCategory.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Category category = Category.builder()
                .name(name)
                .build();
        categoryService.add(category);
        resp.sendRedirect("/category");
    }
}
