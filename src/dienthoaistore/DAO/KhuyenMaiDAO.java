/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore.DAO;
import dienthoaistore.DTO.KhuyenMaiDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class KhuyenMaiDAO {
    
    public KhuyenMaiDAO(){}
    public void them(KhuyenMaiDTO km){   
        try(Connection conn=MyConnection.getConnection()){
            String qry = "INSERT INTO khuyenmai(Ma,Ten,NgayBatDau,NgayKetThuc,GhiChu) VALUES ("
            + "'"+km.getMa()+"'"
            + ",'"+km.getTen()+"'"
            + ",'"+km.getNgayBD()+"'"
            + ",'"+km.getNgayKT()+"'"
            + ",'"+km.getGhiChu()+"')";
            Statement st=conn.createStatement();
            st.executeUpdate(qry);
        }catch (SQLException ex) {
                System.getLogger(KhuyenMaiDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    public void xoa(String ma){
        String qry="Delete from khuyenmai where Ma='"+ma+"'";
        try(Connection conn=MyConnection.getConnection()) {
            Statement st=conn.createStatement();
            st=conn.createStatement();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }      
    }
    public void sua(KhuyenMaiDTO km){
        String qry="Update khuyenmai Set";
        qry+=" "+"Ten="+"'"+km.getTen()+"'";
        qry+=","+"NgayBatDau="+"'"+km.getNgayBD()+"'";
        qry+=","+"NgayKetThuc="+"'"+km.getNgayKT()+"'";
        qry+=","+"Ghichu="+"'"+km.getGhiChu()+"'";
        qry+=" WHERE Ma='"+km.getMa()+"'";
        try(Connection conn=MyConnection.getConnection()) {
            Statement st=conn.createStatement();
            st.executeUpdate(qry);
        } catch (SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    public ArrayList<KhuyenMaiDTO>  docDS(){
        ArrayList<KhuyenMaiDTO> ds=new ArrayList<>();
        String qry="Select * from sinhvien";
        try(Connection conn=MyConnection.getConnection()){
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            while(rs.next()){
                KhuyenMaiDTO km=new KhuyenMaiDTO();
                km.setMa(rs.getString(1));
                km.setTen(rs.getString(2));
                km.setNgayBD(rs.getString(3));
                km.setNgayKT(rs.getString(4));
                km.setGhiChu(rs.getString(5));
            }
        }catch(SQLException ex) {
            System.getLogger(KhuyenMaiDTO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return ds;
    }
}
