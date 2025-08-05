/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.productEntity;
import ulti.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

public class ProductDAO {
    // CREATE (Add new product)

    public void addProduct(productEntity product) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "INSERT INTO NoiThat (maLoai, tenNoiThat, moTa, gia) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, product.getType());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDesc());
            statement.setInt(4, product.getPrice());

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while adding product: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public productEntity getProductByID(long productID) {
        productEntity product = null;
        try {
            Connection database = ConnectDB.getConnect();
            String query = "SELECT * FROM NoiThat WHERE maNoiThat = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, productID);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                product = new productEntity(
                        result.getLong("maNoiThat"),
                        result.getLong("maLoai"),
                        result.getString("tenNoiThat"),
                        result.getString("moTa"),
                        result.getInt("gia")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while retrieving product by ID: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
        return product;
    }

    // READ (Get all products)
    public List<productEntity> getAllProducts() {
        List<productEntity> products = new ArrayList<>();
        try {
            Connection database = ConnectDB.getConnect();
            String query = "SELECT * FROM NoiThat";
            PreparedStatement statement = database.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                productEntity product = new productEntity(
                        result.getLong("maNoiThat"),
                        result.getLong("maLoai"),
                        result.getString("tenNoiThat"),
                        result.getString("moTa"),
                        result.getInt("gia")
                );
                products.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while retrieving products: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
        return products;
    }

    // UPDATE (Edit existing product)
    public void updateProduct(productEntity product) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "UPDATE NoiThat SET maLoai = ?, tenNoiThat = ?, moTa = ?, gia = ? WHERE maNoiThat = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, product.getType());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDesc());
            statement.setInt(4, product.getPrice());
            statement.setLong(5, product.getID());

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating product: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    // DELETE (Remove product)
    public void deleteProduct(long productID) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "DELETE FROM NoiThat WHERE maNoiThat = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, productID);

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while deleting product: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }
}
