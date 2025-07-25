/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thinhdzaingatngay
 */
public class LoaiEntity {
    private long maLoai;
    private String ten;
    private String LoaiSP;

    public LoaiEntity(long maLoai, String ten, String LoaiSP) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.LoaiSP = LoaiSP;
    }

    public LoaiEntity() {
    }

    public LoaiEntity(String ten, String LoaiSP) {
        this.ten = ten;
        this.LoaiSP = LoaiSP;
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

    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }
    
}
