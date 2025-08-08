/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.*;
import entity.receiptEntities;
import entity.receiptEntitiesA;
import ulti.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import entity.productEntity;
import java.sql.Timestamp;

/**
 *
 * @author chann
 */
public class ReceiptDAO {

    public List<receiptEntitiesA> getSpecifics(long ID) {
        List<receiptEntitiesA> receiptsA = new ArrayList();
        try {
            Connection database = ConnectDB.getConnect();
            String query = "select * from HoaDonDetailed where maHoaDon = ? ";
            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, ID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                receiptEntitiesA receiptA = new receiptEntitiesA(result.getInt("maChiTietHD"), result.getLong("maHoaDon"), result.getLong("maNoiThat"), result.getInt("soLuong"), result.getInt("donGia"));
                receiptsA.add(receiptA);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst retrieving receipt data: " + e + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
        return receiptsA;
    }

    public receiptEntities getSpecificReceipt(long ID) {
        receiptEntities receipt = null;
        try {
            Connection database = ConnectDB.getConnect();
            String query = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, ID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                receipt = new receiptEntities(
                        result.getLong("maHoaDon"),
                        result.getLong("maKhachHang"),
                        result.getLong("maTaiKhoan"),
                        result.getTimestamp("ngayTao").toString(), // assuming datetime is stored as string
                        result.getString("moTa"), // assuming "desc" maps to ghiChu
                        result.getInt("tongTien"),
                        result.getBoolean("trangThai"),
                        result.getLong("maVouch")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred while retrieving the receipt: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
        return receipt;
    }

    public void addItemRA(long receiptID, long productID, int amount, int price) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "INSERT INTO HoaDonDetailed (maHoaDon, maNoiThat, soLuong, donGia) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = database.prepareStatement(query);

            statement.setLong(1, receiptID);                // maHoaDon
            statement.setLong(2, productID);          // maNoiThat
            statement.setInt(3, amount);                    // soLuong
            statement.setInt(4, price);        // donGia (unit price)

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while adding item to receipt: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void createReceipt(long receiptID, long accountID) {
        try {
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);

            Connection database = ConnectDB.getConnect();
            String query = "INSERT INTO HoaDon (maTaiKhoan, maKhachHang, moTa, tongTien, trangThai, maVouch, ngayTao) "
                    + "VALUES (?, NULL, '', 0, 0, NULL, ?)";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, accountID);       // maTaiKhoan
            statement.setTimestamp(2, timestamp);

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred while creating the receipt: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }

    }

    public List<receiptEntities> getAllat() {
        List<receiptEntities> receipts = new ArrayList();
        try {
            Connection database = ConnectDB.getConnect();
            String query = "select * from HoaDon";
            PreparedStatement statement = database.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                receiptEntities receipt = new receiptEntities(result.getLong("maHoaDon"), result.getLong("maKhachHang"), result.getLong("maTaiKhoan"), result.getDate("ngayTao").toString(), result.getString("moTa"), result.getInt("tongTien"), result.getBoolean("trangThai"), result.getLong("maVouch"));
                receipts.add(receipt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst retrieving receipt data: " + e + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
        return receipts;
    }

    public List<receiptEntities> getAllByStatus(boolean status) {
        List<receiptEntities> receipts = new ArrayList<>();
        try {
            Connection database = ConnectDB.getConnect();
            String query = "SELECT * FROM HoaDon WHERE trangThai = ?";
            PreparedStatement statement = database.prepareStatement(query);
            statement.setBoolean(1, status);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                receiptEntities receipt = new receiptEntities(
                        result.getLong("maHoaDon"),
                        result.getLong("maKhachHang"),
                        result.getLong("maTaiKhoan"),
                        result.getDate("ngayTao").toString(),
                        result.getString("moTa"),
                        result.getInt("tongTien"),
                        result.getBoolean("trangThai"),
                        result.getLong("maVouch")
                );
                receipts.add(receipt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred whilst retrieving receipt data: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.",
                    "SQL Error", 0);
        }
        return receipts;
    }

    public List<receiptEntitiesA> getAllatA() {
        List<receiptEntitiesA> receiptsA = new ArrayList();
        try {
            Connection database = ConnectDB.getConnect();
            String query = "select * from HoaDonDetailed";
            PreparedStatement statement = database.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                receiptEntitiesA receiptA = new receiptEntitiesA(result.getInt("maChiTietHD"), result.getLong("maHoaDon"), result.getLong("maNoiThat"), result.getInt("soLuong"), result.getInt("donGia"));
                receiptsA.add(receiptA);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst retrieving extra receipt data: " + e + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
        return receiptsA;
    }

    public int[] getTotalAmountAndPrice() {
        int[] totals = new int[2]; // [0] = soLuong, [1] = donGia
        try {
            Connection database = ConnectDB.getConnect();
            String query = "SELECT SUM(soLuong) AS totalAmount, SUM(donGia) AS totalPrice FROM HoaDonDetailed";
            PreparedStatement statement = database.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                totals[0] = result.getInt("totalAmount");
                totals[1] = result.getInt("totalPrice");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "An error occurred whilst calculating totals: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
        return totals;
    }

    public void newReceiptA(receiptEntitiesA receiptA) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "insert into HoaDonDetailed (maHoaDon, maNoiThat, soLuong, donGia) values (?,?,?,?)";
            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, receiptA.getReceiptID());
            statement.setLong(2, receiptA.getFurnitureID());
            statement.setInt(3, receiptA.getAmount());
            statement.setInt(4, receiptA.getPrice());
            statement.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst adding extra receipt data: " + e + "\nHãy báo đến quản trị viên để được hỗ trợ.", "SQL Error", 0);
        }
    }

    public void updateReceipt(receiptEntities receipt) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "UPDATE HoaDon SET maTaiKhoan = ?, moTa = ?, tongTien = ?, trangThai = ?, maVouch = ?, maKhachHang = ? "
                    + "WHERE maHoaDon = ?";

            PreparedStatement statement = database.prepareStatement(query);

            statement.setLong(1, receipt.getAccountID());
            statement.setString(2, receipt.getDesc());
            statement.setInt(3, receipt.getTotal());
            statement.setBoolean(4, receipt.isStatus());
            statement.setLong(5, receipt.getVoucherID());
            statement.setLong(6, receipt.getCustomerID());
            statement.setLong(7, receipt.getID()); // Update by maHoaDon

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst updating receipt data: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void updateReceiptA(receiptEntitiesA receiptA) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "UPDATE HoaDonDetailed SET maNoiThat = ?, soLuong = ?, donGia = ? "
                    + "WHERE maHoaDon = ?";

            PreparedStatement statement = database.prepareStatement(query);

            statement.setLong(1, receiptA.getFurnitureID());
            statement.setInt(2, receiptA.getAmount());
            statement.setInt(3, receiptA.getPrice());
            statement.setLong(4, receiptA.getReceiptID());

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst updating extra receipt data: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void updateItemRA(receiptEntitiesA receiptA) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "UPDATE HoaDonDetailed SET soLuong = ?, donGia = ? "
                    + "WHERE maHoaDon = ? AND maNoiThat = ?";

            PreparedStatement statement = database.prepareStatement(query);

            statement.setInt(1, receiptA.getAmount());
            statement.setInt(2, receiptA.getPrice());
            statement.setLong(3, receiptA.getReceiptID());
            statement.setLong(4, receiptA.getFurnitureID());

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst updating specific receipt item: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void deleteReceipt(long receiptID) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "DELETE FROM HoaDon WHERE maKhachHang = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, receiptID);

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst deleting receipt data: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void deleteReceiptA(long receiptID) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "DELETE FROM HoaDonDetailed WHERE maHoaDon = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, receiptID);

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst deleting extra receipt data: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

    public void deleteItemRA(long receiptID) {
        try {
            Connection database = ConnectDB.getConnect();
            String query = "DELETE FROM HoaDonDetailed WHERE maChiTietHD = ?";

            PreparedStatement statement = database.prepareStatement(query);
            statement.setLong(1, receiptID);

            statement.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred whilst deleting specific receipt item: " + e
                    + "\nHãy báo đến quản trị viên để được hỗ trợ.");
        }
    }

}
