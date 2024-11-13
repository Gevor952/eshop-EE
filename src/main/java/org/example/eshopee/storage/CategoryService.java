package org.example.eshopee.storage;


import org.example.eshopee.db.DBConnectionProvider;
import org.example.eshopee.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private static final Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Category category) {
        String sql = "INSERT INTO category(name) VALUES(?)";
        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, category.getName());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                category.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<Category> getCategories() {
        String sql = "SELECT * FROM category";
        List<Category> categories = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category = Category.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                categories.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void printCategories() {
        List<Category> categories = this.getCategories();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public Category getCategoryById(int id) {
        Category category = null;
        String sql = "SELECT * FROM category WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                category = Category.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }


    public  void updateCategoryById(int categoryId, String newCategoryName) {
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newCategoryName);
            preparedStatement.setInt(2, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCategoryByID(int id) {
        String sql = "DELETE FROM category WHERE id = " + id;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
