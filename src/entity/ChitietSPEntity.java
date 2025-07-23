/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author meoba
 */
public class ChitietSPEntity {
   private long maNoiThat;
    private long maLoai;
    private String tenNoiThat;
    private String moTa;
    private int gia;
    private String linkDenAnh;

    public ChitietSPEntity() {
    }

    public ChitietSPEntity(long maNoiThat, long maLoai, String tenNoiThat, String moTa, int gia, String linkDenAnh) {
        this.maNoiThat = maNoiThat;
        this.maLoai = maLoai;
        this.tenNoiThat = tenNoiThat;
        this.moTa = moTa;
        this.gia = gia;
        this.linkDenAnh = linkDenAnh;
    }

    public ChitietSPEntity(long maLoai, String tenNoiThat, String moTa, int gia, String linkDenAnh) {
        this.maLoai = maLoai;
        this.tenNoiThat = tenNoiThat;
        this.moTa = moTa;
        this.gia = gia;
        this.linkDenAnh = linkDenAnh;
    }

    public long getMaNoiThat() {
        return maNoiThat;
    }

    public void setMaNoiThat(long maNoiThat) {
        this.maNoiThat = maNoiThat;
    }

    public long getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(long maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenNoiThat() {
        return tenNoiThat;
    }

    public void setTenNoiThat(String tenNoiThat) {
        this.tenNoiThat = tenNoiThat;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getLinkDenAnh() {
        return linkDenAnh;
    }

    public void setLinkDenAnh(String linkDenAnh) {
        this.linkDenAnh = linkDenAnh;
    }
    
}
