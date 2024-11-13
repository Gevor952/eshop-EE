package am.itspace.storage;

import am.itspace.db.DBConnectionProvider;
import am.itspace.model.Category;
import am.itspace.model.Product;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static final int CATEGORY_ID = 7;
    private static final int CATEGORY_NAME = 8;

    private static final Connection connection = DBConnectionProvider.getInstance().getConnection();

    public void add(Product product) {
        String sql = "INSERT INTO product(name, description, price, quantity, category_id) VALUES(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setInt(5, product.getCategory().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql =
                "SELECT * FROM product " +
                        "INNER JOIN category ON product.category_id = category.id";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Product product = Product.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .description(resultSet.getString("description"))
                        .price(resultSet.getDouble("price"))
                        .quantity(resultSet.getInt("quantity"))
                        .category(Category.builder()
                                .id(resultSet.getInt(CATEGORY_ID))
                                .name(resultSet.getString(CATEGORY_NAME))
                                .build())
                        .build();
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void printProducts() {
        List<Product> products = getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM product INNER JOIN category ON product.category_id = category.id WHERE product.id = " + id;
        Product product = new Product();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setCategory(Category.builder()
                        .id(resultSet.getInt(CATEGORY_ID))
                        .name(resultSet.getString(CATEGORY_NAME))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void updateProductById(int id, String name, String description, double price, int quantity, Category category) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.setInt(4, quantity);
            preparedStatement.setInt(5, category.getId());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProductById(int id) {
        String sql = "DELETE FROM product WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printSumOfProducts() {
        String sql = "SELECT SUM(quantity) FROM product";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                int quantity = resultSet.getInt(1);
                System.out.println(quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printMaxOfPriceProduct() {
        String sql = "SELECT MAX(price) FROM product";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                double price = resultSet.getDouble(1);
                System.out.println(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printMinOfPriceProduct() {
        String sql = "SELECT MIN(price) FROM product";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                double price = resultSet.getDouble(1);
                System.out.println(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAvgOfPriceProduct() {
        String sql = "SELECT AVG(price) FROM product";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                double price = resultSet.getDouble(1);
                System.out.println(price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
