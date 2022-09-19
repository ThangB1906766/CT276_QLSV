/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author admin
 */
public class TestConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;database=QLSV;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            
            String username = "demo";
            String password = "14332";
            
            Connection con = DriverManager.getConnection(connectionUrl, username, password);
            
            System.out.println("Ðã ket noi---------------dasdsa-------------------------------asdsad");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
