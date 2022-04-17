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
            System.out.println("Thời gian bảo hành phải lớn hơn hoặc bằng 0!!!!");
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
            System.out.println("Công suất phải lớn hơn 0!!!!");
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
        String str = "Không đánh giá";
        if (this.getSoLuongTon() < 3) {
            str = "Bán được";
        } 
        return str;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return super.toString() + "\tThời gian bảo hành(tháng): " + thoiGianBaoHanh + "\tCông suất: " + congSuat  + "\tThuế VAT: " + tinhVAT() + "\tĐánh giá: " + danhGiaMDBB();
    }
}

