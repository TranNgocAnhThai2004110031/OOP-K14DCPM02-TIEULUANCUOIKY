/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

public class HangDienMay extends HangHoa{
    private int thoiGianBaoHanh;
    private int congSuat;
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     */
    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia) {
        super(maHang, tenHang, soLuongTon, donGia);
    }
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     * @param thoiGianBaoHanh
     * @param congSuat
     */
    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int thoiGianBaoHanh,
            Integer congSuat) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.setThoiGianBaoHanh(thoiGianBaoHanh);
        this.setCongSuat(congSuat);
    }
    /**
     * @return the thoiGianBaoHanh
     */
    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }
    /**
     * @param thoiGianBaoHanh the thoiGianBaoHanh to set
     */
    public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
        if (thoiGianBaoHanh >= 0) {
            this.thoiGianBaoHanh = thoiGianBaoHanh;
        } else {
            System.out.println("Thoi gian bao hanh phai lon hon hoac bang 0!!!!");
        }
    }
    /**
     * @return the congSuat
     */
    public int getCongSuat() {
        return congSuat;
    }
    /**
     * @param congSuat the congSuat to set
     */
    public void setCongSuat(int congSuat) {
        if (congSuat > 0) {
            this.congSuat = congSuat;
        } else {
            System.out.println("Cong suat phai lon hon 0!!!!");
        }
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
        if (this.getSoLuongTon() < 3) {
            str = "Ban duoc";
        } 
        return str;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return super.toString() + "\tThoi gian bao hanh(thang): " + thoiGianBaoHanh + "\tCong suat: " + congSuat  + "\tThue VAT: " + tinhVAT() + "\tDanh gia: " + danhGiaMDBB();
    }
}

