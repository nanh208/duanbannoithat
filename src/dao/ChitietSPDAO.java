/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.ChitietSPEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ulti.ConnectDB;

/**
 *
 * @author meoba
 */
public class ChitietSPDAO {
    public List<ChitietSPEntity> getAll() {
        List<ChitietSPEntity> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM NoiThat";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ChitietSPEntity ct = new ChitietSPEntity(
                        result.getLong("maNoiThat"),
                        result.getLong("maLoai"),
                        result.getString("tenNoiThat"),
                        result.getString("moTa"),
                        result.getInt("gia"),
                        result.getString("linkDenAnh")
                );
                list.add(ct);
            }
        } catch (Exception e) {
            System.out.println("Lỗi lấy dữ liệu chiTietSP: " + e.getMessage());
        }
        return list;
    }
    public void insert(ChitietSPEntity ct) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO NoiThat (maLoai, tenNoiThat, moTa, gia, linkDenAnh) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, ct.getMaLoai());
            statement.setString(2, ct.getTenNoiThat());
            statement.setString(3, ct.getMoTa());
            statement.setInt(4, ct.getGia());
            statement.setString(5, ct.getLinkDenAnh());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi insert NoiThat: " + e.getMessage());
        }
    }
    public void update(ChitietSPEntity ct) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE NoiThat SET maLoai = ?, tenNoiThat = ?, moTa = ?, gia = ?, linkDenAnh = ? WHERE maNoiThat = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, ct.getMaLoai());
            statement.setString(2, ct.getTenNoiThat());
            statement.setString(3, ct.getMoTa());
            statement.setInt(4, ct.getGia());
            statement.setString(5, ct.getLinkDenAnh());
            statement.setLong(6, ct.getMaNoiThat());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi update chiTietSP: " + e.getMessage());
        }
    }
    public void delete(long maNoiThat) {
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "DELETE FROM NoiThat WHERE maNoiThat = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, maNoiThat);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi delete chiTietSP: " + e.getMessage());
        }
    }
}
