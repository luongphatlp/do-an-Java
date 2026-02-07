/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Latitude E7470
 */
public class MyConnection {
    private static final String URL="jdbc:mySQL://localhost:3309/dienthoai";
    private static final String USER="roof";
    private static final String PASSWORD="";
    
    public MyConnection(){}
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.getLogger(MyConnection.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }   
        return conn;
    }
}
