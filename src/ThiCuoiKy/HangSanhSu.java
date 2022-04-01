/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HangSanhSu extends KhoHang{
    private String nhaSanXuat;
    private Date ngayNhapKho;
    
    SimpleDateFormat ngayVN = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     */
    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia) {
        super(maHang, tenHang, soLuongTon, donGia);
    }
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     * @param nhaSanXuat
     * @param ngayNhapKho
     */
    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }
    /**
     * @return the nhaSanXuat
     */
    public String getNhaSanXuat() {
        return nhaSanXuat;
    }
    /**
     * @param nhaSanXuat the nhaSanXuat to set
     */
    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    /**
     * @return the ngayNhapKho
     */
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    /**
     * @param ngayNhapKho the ngayNhapKho to set
     */
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return super.toString() + "\tNgày sản xuất: " + nhaSanXuat + "\tNgày nhập kho: " + ngayVN.format(ngayNhapKho) + "\tThuế VAT: " + tinhVAT() + "\tĐánh giá: " + danhGiaMDBB();
    }
    @Override
    public double tinhVAT() {
        double vat;
        vat = this.getDonGia() * 0.1;
        return vat;
    }
    @Override
    public String danhGiaMDBB() {
        String str = "Không đánh giá";
        Date ngayHienTai = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date ngayNhapHang = this.getNgayNhapKho();
        calendar.setTime(ngayNhapHang);
        int ngayNhap = calendar.get(Calendar.DATE);

        calendar2.setTime(ngayHienTai);
        int thoiGianLuuKho = calendar2.get(Calendar.DATE) - ngayNhap;
        if (this.getSoLuongTon() > 50 && thoiGianLuuKho > 10) {
            str = "Bán chậm";
        }
        return str;
    }
}
