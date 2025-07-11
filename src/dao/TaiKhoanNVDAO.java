/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVienEntity;
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
public class TaiKhoanNVDAO {
        public List<NhanVienEntity> getAll() {
        List<NhanVienEntity> list = new ArrayList();
        try {
            Connection con = ConnectDB.getConnect();
            String sql = "select * from Ban";
            PreparedStatement statement  = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                NhanVienEntity ban = new NhanVienEntity(result.getLong("maTaiKhoan"),
                    result.getLong("password"),
                    result.getString("tenTaiKhoan"),
                    result.getString("Email"),
                    result.getString("permission"),
                    result.getInt("SDT"),
                    result.getDate("namSinh"));
                list.add(ban);
            }
        } catch (Exception e) {
            
            System.out.println("Lỗi get all Bàn" + e.getMessage());
        }
        return list;
    }
        
}
