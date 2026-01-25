/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore;

import java.util.ArrayList;

/**
 *
 * @author Latitude E7470
 */
public class DSChiTietKhuyenMai {
    private ArrayList<ChiTietKhuyenMai> ds=new ArrayList<>();
    
    public DSChiTietKhuyenMai(){}
    public DSChiTietKhuyenMai(ArrayList<KhuyenMai> dsctkm){
        for(ChiTietKhuyenMai ctkm:ds)
            this.ds.add(new ChiTietKhuyenMai(ctkm));
    }
    public DSChiTietKhuyenMai(DSChiTietKhuyenMai dskm){
        this.ds=new ArrayList<>();
        for(ChiTietKhuyenMai ctkm:dskm.ds)
            this.ds.add(ctkm);
    }
    public ArrayList<ChiTietKhuyenMai> getDanhSach(){return ds;}
    
    public void them(ChiTietKhuyenMai ctkm){
        ds.add(ctkm);
    }
    public boolean xoa(String masp){
        return ds.removeIf(km -> masp.equals(km.getMaSP()));
    }
    public boolean sua(ChiTietKhuyenMai ctkm){
        for(int i=0;i<ds.size();i++)
            if(ds.get(i).getMaSP().equals(ctkm.getMaSP())){
                ds.set(i, ctkm); 
                return true;
            }
        return false;
    }
    public ChiTietKhuyenMai timTheoMaSP(String masp){
        for(ChiTietKhuyenMai ctkm:ds)
            if(masp.equals(ctkm.getMaSP()))
                return ctkm;
        return null;
    }
    public ArrayList<ChiTietKhuyenMai> timTheoPhanTram(int pt){
        ArrayList<ChiTietKhuyenMai> dsmoi=new ArrayList<>();
        if(pt<=0) return null;
        for(ChiTietKhuyenMai ctkm:ds)
            if(pt==ctkm.getPhanTram())
                dsmoi.add(ctkm);
        return ds;
    }
    
}
