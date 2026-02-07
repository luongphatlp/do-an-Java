/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore.BUS;

import dienthoaistore.DAO.KhuyenMaiDAO;
import dienthoaistore.DTO.KhuyenMaiDTO;
import java.util.ArrayList;

//heeloo
/**
 *
 * @author Latitude E7470
 */
public class KhuyenMaiBUS {
    private ArrayList<KhuyenMaiDTO> ds=new ArrayList<>();
    public KhuyenMaiBUS(){}
    public ArrayList<KhuyenMaiDTO> getDS(){return ds;}
    public void setDS(ArrayList<KhuyenMaiDTO> ds){this.ds=ds;}
    public void them(KhuyenMaiDTO km){
        KhuyenMaiDAO dao=new KhuyenMaiDAO();
        ds.add(km);
        dao.them(km);
    }
    public boolean xoa(String ma){
        if(ma.isEmpty()) return false;
        KhuyenMaiDAO dao=new KhuyenMaiDAO();       
        for(int i=0;i<ds.size();i++)
            if(ma.equals(ds.get(i).getMa())){
                ds.remove(i);
                dao.xoa(ma);
                return true;
            }
        return false;
    }
    public boolean sua(KhuyenMaiDTO km){
        if(km.getMa().isEmpty()) return false;
        KhuyenMaiDAO dao=new KhuyenMaiDAO();
        for(int i=0;i<ds.size();i++)
            if(km.getMa().equals(ds.get(i).getMa())){
                ds.set(i, km);
                dao.sua(km);
                return true;
            }
        return false;
    }
    public void docDS(){
        KhuyenMaiDAO dao=new KhuyenMaiDAO();
        ds=dao.docDS();
    }
}
