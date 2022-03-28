/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

public abstract class KhoHang {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private static int soLuongHangHoa;
    /**
     * 
     */
    public KhoHang() {
    }
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     */
    public KhoHang(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTon(soLuongTon);
        this.setDonGia(donGia);
        this.tangSLHH();
    }
    public abstract String danhGiaMDBB();
    public abstract double tinhVAT();
    /**
     * @return the maHang
     */
    protected String getMaHang() {
        return maHang;
    }
    /**
     * @return the tenHang
     */
    protected String getTenHang() {
        return tenHang;
    }
    /**
     * @return the soLuongTon
     */
    protected int getSoLuongTon() {
        return soLuongTon;
    }
    /**
     * @return the donGia
     */
    protected double getDonGia() {
        return donGia;
    }
    /**
     * @return the soLuongHangHoa
     */
    protected static int getSoLuongHangHoa() {
        return soLuongHangHoa;
    }
    /**
     * @param maHang the maHang to set
     */
    private void setMaHang(String maHang) {
        if(maHang != null){
            this.maHang = maHang;
        }else{
            System.out.println("Mã hàng hoá không được để trống!!!!");
        }
    }
    /**
     * @param tenHang the tenHang to set
     */
    protected void setTenHang(String tenHang) {
        if (tenHang != null) {
            this.tenHang = tenHang;
        } else {
            System.out.println("Tên hàng hoá không được để trống!!!!");
        }
    }
    /**
     * @param soLuongTon the soLuongTon to set
     */
    protected void setSoLuongTon(int soLuongTon) {
        if (soLuongTon >= 0) {
            this.soLuongTon = soLuongTon;
        } else {
            System.out.println("Số lượng hàng hoá tồn kho phải lớn hơn hoặc bằng 0!!!!");
        }
    }
    /**
     * @param donGia the donGia to set
     */
    protected void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Đơn giá của hàng hoá phải lớn hơn 0!!!!");
        }
    }
    private void tangSLHH(){
        soLuongHangHoa++;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Mã hàng: " + maHang +"\tTên hàng: " + tenHang + "\tSố lượng tồn kho:" + soLuongTon +"\tĐơn giá: " + donGia;
    }
}
