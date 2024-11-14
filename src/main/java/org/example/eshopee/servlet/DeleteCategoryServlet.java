package org.example.eshopee.servlet;

import org.example.eshopee.storage.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCategory")
public class DeleteCategoryServlet extends HttpServlet {

    CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        categoryService.deleteCategoryByID(id);
        resp.sendRedirect("/category");
    }
}
