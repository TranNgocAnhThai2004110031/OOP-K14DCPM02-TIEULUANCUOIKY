/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HangSanhSu extends HangHoa{
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
    @Override
    public double tinhVAT() {
        double vat;
        vat = this.getDonGia() * 0.1;
        return vat;
    }
    @Override
    public String danhGiaMDBB() {
        String str = "Khong danh gia";
               
        if (this.getSoLuongTon() > 50 && tinhThoiGianLuuKho() > 10) {
            str = "Ban cham";
        }
        return str;
    }
    public int tinhThoiGianLuuKho() {
        Date ngayHienTai = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date ngayNhapHang = this.getNgayNhapKho();
        calendar.setTime(ngayNhapHang);
        int ngayNhap = calendar.get(Calendar.DATE);
        int thangNhap = calendar.get(Calendar.MONTH) + 1;
        int namNhap = calendar.get(Calendar.YEAR); 

        calendar2.setTime(ngayHienTai);
        int ngayHT = calendar2.get(Calendar.DATE);
        int thangHT = calendar2.get(Calendar.MONTH) + 1;
        int namHT = calendar2.get(Calendar.YEAR);
        int thoiGianLuuKho = 0;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (namHT == (namNhap + i)) {
                    if (thangHT == (thangNhap + j)) {
                        thoiGianLuuKho = ngayHT - ngayNhap;
                        thoiGianLuuKho += (j*30);
                        break;
                    } 
                    thoiGianLuuKho += (i*365);
                }                 
            }            
        }
        return thoiGianLuuKho;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return super.toString() + "\tNgay san xuat: " + nhaSanXuat + "\tNgay nhap kho: " + ngayVN.format(ngayNhapKho) + "\tThue VAT: " + tinhVAT() + "\tDanh gia: " + danhGiaMDBB();
    }
    
}
