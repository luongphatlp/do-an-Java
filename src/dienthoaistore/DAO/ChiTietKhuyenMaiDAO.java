/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import dienthoaistore.DTO.ChiTietKhuyenMaiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietKhuyenMaiDAO {
    public ChiTietKhuyenMaiDAO(){}
    public void them(ChiTietKhuyenMaiDTO km){
        String qty="INSERT INTO chitietkhuyenmai(makm,masp,phantram) VALUES ("
                + "'" + km.getMaKM() +"',"
                + "'" + km.getMaSP() +"',"
                + "'" + km.getPhanTram() +"')";
        try(Connection conn=MyConnection.getConnection()){
            Statement st=conn.createStatement();
            st.executeUpdate(qty);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }        
    }
    public ArrayList<ChiTietKhuyenMaiDTO> docDS(String ma){
        String qty="SELECT * FROM chitietkhuyenmai WHERE MaKhuyenMai='"+ma+"'";
        ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
        try(Connection conn=MyConnection.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qty);
            while(rs.next()){
                ChiTietKhuyenMaiDTO km=new ChiTietKhuyenMaiDTO();
                km.setMaKM(rs.getString(1));
                km.setMaSP(rs.getString(2));
                km.setPhanTram(Integer.parseInt(rs.getString(3)));
                ds.add(km);
            }
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } 
        return ds;
    }
    
    public void xoa(String makm,String masp){
        String qry = "DELETE FROM chitietkhuyenmai "
                   + "WHERE MaKhuyenMai='" + makm + "' "
                   + "AND MaSanPham='" + masp + "'";
        try(Connection conn=MyConnection.getConnection()){
            Statement st=conn.createStatement();
            st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);   
        }
    }
    public void sua(ChiTietKhuyenMaiDTO km){
        String qry="Update FROM chitietkhuyenmai "
                +"PhanTram='"+km.getPhanTram()+"'"
                +"WHERE MaKhuyenMai='"+km.getMaKM()+"' AND MaSanPham='"+km.getMaSP()+"'";
        try(Connection conn=MyConnection.getConnection()){
            Statement st=conn.createStatement();
            st.executeUpdate(qry);
        }catch(SQLException ex){
            System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);            
        }
    }
}
