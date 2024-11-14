package org.example.eshopee.servlet;

import org.example.eshopee.model.Category;
import org.example.eshopee.storage.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;


@WebServlet("/editCategory")
public class EditCategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.getCategoryById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("editCategory.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int id = Integer.parseInt(req.getParameter("id"));
        categoryService.updateCategoryById(id, name);
        resp.sendRedirect("/category");
    }
}
