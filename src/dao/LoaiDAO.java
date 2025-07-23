/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import ulti.ConnectDB;
/**
 *
 * @author meoba
 */
public class LoaiDAO {
    public List<Long> getAllMaLoai() {
        List<Long> list = new ArrayList<>();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "SELECT maLoai FROM Loai";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getLong("maLoai"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
