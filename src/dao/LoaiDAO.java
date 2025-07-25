/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.LoaiEntity;
import java.sql.*;
import java.util.*;
import ulti.ConnectDB;
/**
 *
 * @author meoba
 */
public class LoaiDAO {
    public List<LoaiEntity> getAll() {
        List<LoaiEntity> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT * FROM Loai";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiEntity loai = new LoaiEntity(
                rs.getLong("maLoai"),
                rs.getString("ten"),
                rs.getString("loaiSanPham")
                );
                list.add(loai);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void insert(LoaiEntity ct) {
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "INSERT INTO LOAI (maLoai, ten, loaiSanPham) "
                    + "VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, ct.getMaLoai());
            statement.setString(2, ct.getTen());
            statement.setString(3, ct.getLoaiSP());
            
            statement.executeUpdate();

        }catch(Exception e) {
            System.out.println("Lỗi Insert loại: " + e.getMessage());
        }
    } 
    
    public void update(LoaiEntity ct) {
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "UPDATE Loai SET maLoai = ?, ten = ?, loaiSanPham = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, ct.getMaLoai());
            statement.setString(2, ct.getTen());
            statement.setString(3, ct.getLoaiSP());
            
            statement.execute();
        }catch(Exception e) {
            System.out.println("lỖI UPDATE Loại: " + e.getMessage());
        }
    }
    public void delete(long maLoai) {
        try{
            Connection con = ConnectDB.getConnect();
            String sql = "delete from Loai where maLoai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setLong(1, maLoai);
            statement.execute();
        }catch (Exception e) {
            System.out.println("Lỗi delete Loại: " + e.getMessage());
        }
    }
}
