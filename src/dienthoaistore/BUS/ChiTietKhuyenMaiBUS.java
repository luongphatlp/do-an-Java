/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore.BUS;

import dienthoaistore.DAO.ChiTietKhuyenMaiDAO;
import dienthoaistore.DTO.ChiTietKhuyenMaiDTO;
import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class ChiTietKhuyenMaiBUS {
    private ArrayList<ChiTietKhuyenMaiDTO> ds=new ArrayList<>();
    public ChiTietKhuyenMaiBUS(){}
    public void them(ChiTietKhuyenMaiDTO km){
        ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
        ds.add(km);
        dao.them(km);       
    }
    public boolean xoa(String makm,String masp){
        if(makm.isEmpty() || masp.isEmpty()) return false;
        ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
        for(int i=0;i<ds.size();i++)
            if(masp.equals(ds.get(i).getMaSP()) && makm.equals(ds.get(i).getMaKM())){
                ds.remove(i);
                dao.xoa(makm, masp);
                return true;
            }
        return false;
    }
    public void docDS(String ma){
        ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
        ds=dao.docDS(ma);
    }
    public boolean sua(ChiTietKhuyenMaiDTO km){
        if(km.getMaSP().isEmpty() || km.getMaKM().isEmpty()) return false;
        ChiTietKhuyenMaiDAO dao=new ChiTietKhuyenMaiDAO();
        for(int i=0;i<ds.size();i++)
            if(km.getMaSP().equals(ds.get(i).getMaSP()) && km.getMaKM().equals(ds.get(i).getMaKM())){
                ds.set(i,km);
                dao.sua(km);
                return true;
            }
        return false;
    }
}
