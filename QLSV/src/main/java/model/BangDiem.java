/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class BangDiem {

    private int ma;
    private String maSinhVien;
    private float tiengAnh, tinHoc, theDuc;

    public BangDiem() {
    }

    public BangDiem(int ma, String maSinhVien, float tiengAnh, float tinHoc, float theDuc) {
        this.ma = ma;
        this.maSinhVien = maSinhVien;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.theDuc = theDuc;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int maKetQua) {
        this.ma = maKetQua;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public float getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(float tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public float getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(float tinHoc) {
        this.tinHoc = tinHoc;
    }

    public float getTheDuc() {
        return theDuc;
    }

    public void setTheDuc(float theDuc) {
        this.theDuc = theDuc;
    }
            
            
}
