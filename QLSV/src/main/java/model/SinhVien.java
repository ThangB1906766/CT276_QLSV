/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SinhVien {

    private String maSinhVien, hoVaTen, email, soDienThoai, diaChi;
    private int gioiTinh;
    private byte[] hinhDaiDien;

    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String hoVaTen, String email, String soDienThoai, String diaChi, int gioiTinh, byte[] hinhDaiDien) {
        this.maSinhVien = maSinhVien;
        this.hoVaTen = hoVaTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.hinhDaiDien = hinhDaiDien;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public byte[] getHinhDaiDien() {
        return hinhDaiDien;
    }

    public void setHinhDaiDien(byte[] hinhDaiDien) {
        this.hinhDaiDien = hinhDaiDien;
    }
    
    
}
