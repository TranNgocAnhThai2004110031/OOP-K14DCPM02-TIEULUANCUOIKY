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
        String str = "Không đánh giá";
               
        if (this.getSoLuongTon() > 50 && tinhThoiGianLuuKho() > 10) {
            str = "Bán chậm";
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
        return super.toString() + "\tNgày sản xuất: " + nhaSanXuat + "\tNgày nhập kho: " + ngayVN.format(ngayNhapKho) + "\tThuế VAT: " + tinhVAT() + "\tĐánh giá: " + danhGiaMDBB();
    }
    // public int tinhThoiGianLuuKho() {
    //     Date ngayHienTai = new Date();
    //     Calendar calendar = Calendar.getInstance();
    //     Calendar calendar2 = Calendar.getInstance();
    //     Date ngayNhapHang = this.getNgayNhapKho();
    //     calendar.setTime(ngayNhapHang);
    //     int ngayNhap = calendar.get(Calendar.DATE);
    //     int thangNhap = calendar.get(Calendar.MONTH) + 1;
    //     int namNhap = calendar.get(Calendar.YEAR); 

    //     calendar2.setTime(ngayHienTai);
    //     int ngayHT = calendar2.get(Calendar.DATE);
    //     int thangHT = calendar2.get(Calendar.MONTH) + 1;
    //     int namHT = calendar2.get(Calendar.YEAR);
    //     int thoiGianLuuKho = 0;
        
    //     for (int i = 0; i < 10; i++) {
    //         for (int j = 0; j < 12; j++) {
    //             if (namHT == (namNhap + i)) {
    //                 if (thangHT == (thangNhap + j)) {
    //                     switch (thangNhap) {
    //                         case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
    //                             thoiGianLuuKho = ngayHT - ngayNhap;
    //                             thoiGianLuuKho += (j*31);
    //                             break;
    //                         case 4: case 6: case 9: case 11:
    //                             thoiGianLuuKho = ngayHT - ngayNhap; // bình thường
    //                             thoiGianLuuKho += (j*30);
    //                             break;
    //                         case 2:
    //                             if (namNhap%400 == 0 || (namNhap%4 == 0 && namNhap%100 != 0)) {
    //                                 thoiGianLuuKho = ngayHT - ngayNhap;
    //                                 thoiGianLuuKho += (j*29);
    //                             } else {
    //                                 thoiGianLuuKho = ngayHT - ngayNhap;
    //                                 thoiGianLuuKho += (j*28);
    //                             }
    //                             break;
    //                         default:
    //                             break;
    //                     }
    //                     if (namNhap%400 == 0 || (namNhap%4 == 0 && namNhap%100 != 0)) {
    //                         thoiGianLuuKho += (i*366);
    //                     } else {
    //                         thoiGianLuuKho += (i*365);
    //                     }
    //                     // thoiGianLuuKho += (i*365); bình thường
    //                     break;
    //                 } 
    //             }                 
    //         }            
    //     }
}
