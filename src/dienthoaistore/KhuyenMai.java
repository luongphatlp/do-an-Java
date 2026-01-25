/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoaistore;

/**
 *
 * @author Latitude E7470
 */
public class KhuyenMai {
    private String ma,ten,ngaybd,ngaykt,ghichu;
    
    public KhuyenMai(){}
    public KhuyenMai(String ma,String ten,String ngaybd,String ngaykt,String ghichu){
        this.ma=ma;
        this.ten=ten;
        this.ngaybd=ngaybd;
        this.ngaykt=ngaykt;
        this.ghichu=ghichu;
    }
    public KhuyenMai(KhuyenMai km){
        this.ma=km.ma;
        this.ten=km.ten;
        this.ngaybd=km.ngaybd;
        this.ngaykt=km.ngaykt;
        this.ghichu=km.ghichu;      
    }
    public String getMa() {return ma;}
    public void setMa(String ma) {this.ma = ma;}

    public String getTen() {return ten;}
    public void setTen(String ten) {this.ten = ten;}

    public String getNgayBD() {return ngaybd;}
    public void setNgayBD(String ngaybd) {this.ngaybd = ngaybd;}

    public String getNgayKT() {return ngaykt;}
    public void setNgayKT(String ngaykt) {this.ngaykt = ngaykt;}

    public String getGhiChu() {return ghichu;}
    public void setGhiChu(String ghichu) {this.ghichu = ghichu;}
    
}
