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
public class DSKhuyenMai {
    private ArrayList<KhuyenMai> ds= new ArrayList<>();
    public DSKhuyenMai(){}
    public DSKhuyenMai(ArrayList<KhuyenMai> ds){
        for (KhuyenMai km : ds) 
            this.ds.add(new KhuyenMai(km));
    }
    public DSKhuyenMai(DSKhuyenMai dskm) {
        this.ds = new ArrayList<>();
        for (KhuyenMai km : dskm.ds) 
            this.ds.add(new KhuyenMai(km)); // deep copy
    }
    public void them(KhuyenMai km){
        ds.add(km);
    }
    public ArrayList<KhuyenMai> getDanhSach(){
        return ds;
    }
    public boolean xoa(String ma){
        return ds.removeIf(km -> km.getMa().equals(ma));
    }
    public boolean sua(KhuyenMai kmMoi) {
        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).getMa().equals(kmMoi.getMa())) {
                ds.set(i, kmMoi);
                return true;
            }
        }
        return false;
    }
    public KhuyenMai timTheoMa(String ma) {
        for (KhuyenMai km : ds) {
            if (km.getMa().equals(ma)) return km;
        }
        return null;
    }
    public ArrayList<KhuyenMai> timTheoTen(String ten){
        ArrayList<KhuyenMai> dstim=new ArrayList<>();
        if(ten==null) return dstim;
        String key = ten.trim().toLowerCase();
        for(KhuyenMai km:ds)
            if(km.getTen()!=null && key.toLowerCase().contains(km.getTen()))
                dstim.add(km);
        return dstim;
    }
    public boolean tonTaiMa(String ma) {
        return timTheoMa(ma) != null;
    }

    

}
