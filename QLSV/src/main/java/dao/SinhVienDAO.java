/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import databaseHelper.ConnnectDatabase;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import model.NguoiDung;
import model.SinhVien;

/**
 *
 * @author admin
 */

/*
    Ngày 21/08/2022
    Chức năng; Thêm sinh viên vào bảng SinhVien bên SQL
    Lưu hình trực tiếp vào csdl bằng đối tượng "Blob hinh"
 */
public class SinhVienDAO {

    public boolean Them(SinhVien sv) throws Exception { // throws Exception không bắt ngoại lệ thư viện          
        String sql = " INSERT INTO dbo.SinhVien(maSinhVien, hoVaTen, email, soDienThoai, gioiTinh, diaChi, hinhDaiDien) "
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, sv.getMaSinhVien());
            pstmt.setString(2, sv.getHoVaTen());
            pstmt.setString(3, sv.getEmail());
            pstmt.setString(4, sv.getSoDienThoai());
            pstmt.setInt(5, sv.getGioiTinh());
            pstmt.setString(6, sv.getDiaChi());

            if (sv.getHinhDaiDien() != null) {
                Blob hinh = new SerialBlob(sv.getHinhDaiDien());
                pstmt.setBlob(7, hinh);
            } else {
                Blob hinh = null;
                pstmt.setBlob(7, hinh);
            }

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    public boolean CapNhat(SinhVien sv) throws Exception { // throws Exception không bắt ngoại lệ thư viện          
        String sql = "UPDATE dbo.SinhVien"
                + " SET hoVaTen = ?, email = ?, soDienThoai = ?, gioiTinh = ?, diaChi = ?, hinhDaiDien = ? "
                + " where maSinhVien = ? ;";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(7, sv.getMaSinhVien());
            pstmt.setString(1, sv.getHoVaTen());
            pstmt.setString(2, sv.getEmail());
            pstmt.setString(3, sv.getSoDienThoai());
            pstmt.setInt(4, sv.getGioiTinh());
            pstmt.setString(5, sv.getDiaChi());

            if (sv.getHinhDaiDien() != null) {
                Blob hinh = new SerialBlob(sv.getHinhDaiDien());
                pstmt.setBlob(6, hinh);
            } else {
                Blob hinh = null;
                pstmt.setBlob(6, hinh);
            }

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    public boolean Xoa(String maSinhVien) throws Exception { // throws Exception không bắt ngoại lệ thư viện          
        String sql = "DELETE FROM SinhVien "
                + " where maSinhVien = ? ;";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, maSinhVien);

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    public SinhVien TimKiemSinhVien(String maSinhVien) throws Exception { // throws Exception không bắt ngoại lệ thư viện          
        String sql = "SELECT *FROM SinhVien "
                + " where maSinhVien = ? ;";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, maSinhVien);

            try ( ResultSet rs = pstmt.executeQuery()) { // Asg. P5 1:03:23
                if (rs.next()) {
                    SinhVien sv = TaoSinhVien(rs);
                    return sv;
                }
            }
            return null;
        }
    }

    private SinhVien TaoSinhVien(final ResultSet rs) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSinhVien(rs.getString("maSinhVien"));
        sv.setHoVaTen(rs.getString("hoVaTen"));
        sv.setEmail(rs.getString("email"));
        sv.setSoDienThoai(rs.getString("soDienThoai"));
        sv.setDiaChi(rs.getString("diaChi"));
        sv.setGioiTinh(rs.getInt("gioiTinh"));
        Blob blob = rs.getBlob("hinhDaiDien");
        if (blob != null) {
            sv.setHinhDaiDien(blob.getBytes(1, (int) blob.length()));
        }
        return sv;
    }

    public List<SinhVien> TimKiemTatCaSinhVien() throws Exception { // throws Exception không bắt ngoại lệ thư viện          
        String sql = "SELECT *FROM SinhVien ";

        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery()) { // Asg. P5 1:03:23
                List<SinhVien> list = new ArrayList<>();
                while (rs.next()) {
                    SinhVien sv = TaoSinhVien(rs);

                    list.add(sv);
                }
                return list;
            }
        }
    }
}
