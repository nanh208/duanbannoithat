/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FurnitureAttributes;
import java.sql.*;
import ulti.ConnectDB;
import java.util.*;

public class ProductDAO {

    public List<FurnitureAttributes> getAllat() {
        List<FurnitureAttributes> furnitures = new ArrayList<>();
        try {
            Connection database = ConnectDB.getConnect();
            String SQL = "Select * from NoiThat";
            PreparedStatement query = database.prepareStatement(SQL);
            ResultSet result = query.executeQuery();
            while (result.next()) {
                FurnitureAttributes furniture = new FurnitureAttributes(result.getLong("maNoiThat"), result.getLong("maLoai"), result.getString("tenNoiThat"), result.getString("moTa"), result.getInt("gia"), result.getString("linkDenAnh"));
                furnitures.add(furniture);
            }
            return furnitures;
        } catch (Exception e) {
            System.out.println("An error occurred whilst retrieving furnitures: " + e);
            return null;
        }
    }

    public boolean addItem(FurnitureAttributes furniture) {
        try {
            Connection database = ConnectDB.getConnect();
            String SQL = "INSERT INTO NoiThat (maNoiThat, maLoai, tenNoiThat, moTa, gia, linkDenAnh) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement query = database.prepareStatement(SQL);

            query.setLong(1, furniture.getFurnID());
            query.setLong(2, furniture.getFurnType());
            query.setString(3, furniture.getFurnName());
            query.setString(4, furniture.getFurnDesc());
            query.setInt(5, furniture.getFurnPrice());
            query.setString(6, furniture.getImgPath());

            query.execute();
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred whilst adding furniture items: " + e);
            return false;
        }
    }

    public boolean updateInfo(FurnitureAttributes furniture) {
        try {
            Connection database = ConnectDB.getConnect();
            String SQL = "UPDATE NoiThat SET maLoai = ?, tenNoiThat = ?, moTa = ?, gia = ?, linkDenAnh = ? WHERE maNoiThat = ?;";
            PreparedStatement query = database.prepareStatement(SQL);

            query.setLong(6, furniture.getFurnID());
            query.setLong(1, furniture.getFurnType());
            query.setString(2, furniture.getFurnName());
            query.setString(3, furniture.getFurnDesc());
            query.setInt(4, furniture.getFurnPrice());
            query.setString(5, furniture.getImgPath());

            query.execute();
            return true;
        } catch (Exception e) {
            System.out.println("An error occurred whilst updating furniture data: " + e);
            return false;
        }
    }

    public boolean deleteItem(long furnID) {
        try {
            Connection database = ConnectDB.getConnect();
            String SQL = "DELETE FROM NoiThat WHERE maNoiThat = ?";
            PreparedStatement query = database.prepareStatement(SQL);
            query.setLong(1, furnID);
            query.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Unable to delete item. Reason: " + e);
            return false;
        }
    }
}
