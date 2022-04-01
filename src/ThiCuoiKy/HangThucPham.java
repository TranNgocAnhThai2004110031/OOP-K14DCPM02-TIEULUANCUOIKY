/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham extends KhoHang{
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private String nhaCungCap;

    SimpleDateFormat ngayVN = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     */
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia) {
        super(maHang, tenHang, soLuongTon, donGia);
    }
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     * @param ngaySanXuat
     * @param ngayHetHan
     * @param nhaCungCap
     */
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Date ngaySanXuat, Date ngayHetHan,
            String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.setNgayHetHan(ngayHetHan);
        this.nhaCungCap = nhaCungCap;
    }
    /**
     * @return the ngaySanXuat
     */
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }
    /**
     * @param ngaySanXuat the ngaySanXuat to set
     */
    public void setNgaySanXuat(Date ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }
    /**
     * @return the ngayHetHan
     */
    public Date getNgayHetHan() {
        return ngayHetHan;
    }
    /**
     * @param ngayHetHan the ngayHetHan to set
     */
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan.after(ngaySanXuat) || ngayHetHan.compareTo(ngaySanXuat) == 0) {
            this.ngayHetHan = ngayHetHan;
        } else {
            System.out.println("Ngày hết hạn phải sau hoặc là ngày sản xuất không được trước ngày sản xuất!!!!");
        }
    }
    /**
     * @return the nhaCungCap
     */
    public String getNhaCungCap() {
        return nhaCungCap;
    }
    /**
     * @param nhaCungCap the nhaCungCap to set
     */
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public boolean kiemTraHSD(){
        return this.tinhHSD();
    }

    private boolean tinhHSD(){
        boolean isHetHan = false;
        Date ngayHienTai = new Date();
        if(this.ngayHetHan.before(ngayHienTai)){
            isHetHan = true;
        }
        return isHetHan;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return super.toString() + "\tNgày sản xuất: " + ngayVN.format(ngaySanXuat) + "\tNgày hết hạn: "+ ngayVN.format(ngayHetHan) + "\tNhà cung cấp: " + nhaCungCap + "\tThuế VAT: " + tinhVAT() + "\tĐánh giá: " + danhGiaMDBB();
    }

    @Override
    public double tinhVAT() {
        double vat;
        vat = this.getDonGia() * 0.05;
        return vat;
    }

    @Override
    public String danhGiaMDBB() {
        String str = "Không đánh giá";
        if (this.getSoLuongTon() > 0 && tinhHSD()) {
            str = "Khó bán";
        }
        return str;
    }
}