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
import model.BangDiem;
import model.SinhVien;

/**
 *
 * @author admin
 */
public class BangDiemDAO {

    public boolean Them(BangDiem bd) throws Exception { // throws Exception không bắt ngoại lệ thư viện

        String sql = " INSERT INTO [dbo].[BangDiem]([maSinhVien], [tiengAnh], [tinHoc], [theDuc]) "
                + " VALUES (?,?,?,?)";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, bd.getMaSinhVien());
            pstmt.setFloat(2, bd.getTiengAnh());
            pstmt.setFloat(3, bd.getTinHoc());
            pstmt.setFloat(4, bd.getTheDuc());

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    /*
        Ngày 22/08/2022
        Chức năng: Cập nhật, xóa, lấy điểm dựa trên mã sinh viên Asg.P6:
     */
    public boolean CapNhat(BangDiem bd) throws Exception { // throws Exception không bắt ngoại lệ thư viện

        String sql = "UPDATE [dbo].[BangDiem] SET [tiengAnh] = ?, [tinHoc] = ?, [theDuc] = ?"
                + " where [maSinhVien] = ? ";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(4, bd.getMaSinhVien());
            pstmt.setFloat(1, bd.getTiengAnh());
            pstmt.setFloat(2, bd.getTinHoc());
            pstmt.setFloat(3, bd.getTheDuc());

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    public boolean Xoa(String maSinhVien) throws Exception { // throws Exception không bắt ngoại lệ thư viện

        String sql = "DELETE FROM BangDiem "
                + " where [maSinhVien] = ? ";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, maSinhVien);

            return pstmt.executeUpdate() > 0; // Nếu trả về giá trị số bảng ghi đọc được > 0 thì đúng ngược lại error
        }
    }

    public BangDiem TimKiemBangDiem(String maSinhVien) throws Exception { // throws Exception không bắt ngoại lệ thư viện

        String sql = "SELECT *FROM BangDiem "
                + " where [maSinhVien] = ? ";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            pstmt.setString(1, maSinhVien);

            try ( ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    BangDiem bd = TaoBangDiem(rs);

                    return bd;
                }
            }
            return null;
        }
    }

    public List<BangDiem> TimKiemTatCaBangDiem() throws Exception { // trả về danh sách bảng điểm

        String sql = "SELECT *FROM BangDiem ";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<BangDiem> list = new ArrayList<>();
                while (rs.next()) {
                    BangDiem bd = TaoBangDiem(rs);

                    list.add(bd);
                }
                return list;
            }
        }
    }
    
     public List<BangDiem> TimKiemDiemCaoNhat(int top) throws Exception { // trả về danh sách bảng điểm

        String sql = "select top " +top+ " *, (tiengAnh + tinHoc + theDuc)/3 as DTB " +
                        " from BangDiem order by dtb desc;";
        try ( Connection con = ConnnectDatabase.openConnection();  PreparedStatement pstmt = con.prepareStatement(sql);) {

            try ( ResultSet rs = pstmt.executeQuery();) {
                List<BangDiem> list = new ArrayList<>();
                while (rs.next()) {
                    BangDiem bd = TaoBangDiem(rs);

                    list.add(bd);
                }
                return list;
            }
        }
    }

    private BangDiem TaoBangDiem(final ResultSet rs) throws SQLException {
        BangDiem bd = new BangDiem();
        bd.setMa(rs.getInt("ma"));
        bd.setMaSinhVien(rs.getString("maSinhVien"));
        bd.setTiengAnh(rs.getFloat("tiengAnh"));
        bd.setTinHoc(rs.getFloat("tinHoc"));
        bd.setTheDuc(rs.getFloat("theDuc"));
        return bd;
    }
    
}
