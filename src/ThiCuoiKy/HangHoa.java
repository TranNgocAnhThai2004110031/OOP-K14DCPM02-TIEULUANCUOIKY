/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    /**
     * 
     */
    public HangHoa() {
    }
    /**
     * @param maHang
     * @param tenHang
     * @param soLuongTon
     * @param donGia
     */
    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTon(soLuongTon);
        this.setDonGia(donGia);
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
     * @param maHang the maHang to set
     */
    private void setMaHang(String maHang) {
        if(maHang != null){
            this.maHang = maHang;
        }else{
            System.out.println("Ma hang hoa khong duoc de trong!!!!");
        }
    }
    /**
     * @param tenHang the tenHang to set
     */
    protected void setTenHang(String tenHang) {
        if (tenHang != null) {
            this.tenHang = tenHang;
        } else {
            System.out.println("Ten hang hoa khong duoc de trong!!!!");
        }
    }
    /**
     * @param soLuongTon the soLuongTon to set
     */
    protected void setSoLuongTon(int soLuongTon) {
        if (soLuongTon >= 0) {
            this.soLuongTon = soLuongTon;
        } else {
            System.out.println("So luong hang hoa ton kho phai lon hon hoac bang 0!!!!");
        }
    }
    /**
     * @param donGia the donGia to set
     */
    protected void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            System.out.println("Don gia cua hang hoa phai lon hon 0!!!!");
        }
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    
    @Override
    public String toString() {
        return "Ma hang: " + maHang +"\tTen hang: " + tenHang + "\tSo luong ton kho:" + soLuongTon +"\tDon gia: " + donGia;
    }
    
}
