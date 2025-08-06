/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
/**
 *
 * @author Thinhdzaingatngay
 */
public class LoaiEntity1 {
    private long maLoai;
    private String ten;
    private String loaiSanPham;

    public LoaiEntity1(long maLoai, String ten, String loaiSanPham) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.loaiSanPham = loaiSanPham;
    }

    public LoaiEntity1(String ten, String loaiSanPham) {
        this.ten = ten;
        this.loaiSanPham = loaiSanPham;
    }

    public long getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(long maLoai) {
        this.maLoai = maLoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }
    
}
