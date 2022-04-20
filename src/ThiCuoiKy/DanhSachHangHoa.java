/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DanhSachHangHoa {
    private List<HangHoa> quanLyHangHoa = new ArrayList<>();
    ConsoleInput consoleInput = new ConsoleInput();  
    DocGhiFile file = new DocGhiFile();
    /**
     * 
     */
    public DanhSachHangHoa() {
    }

    /**
     * @param quanLyKhoHang
     */
    public DanhSachHangHoa(List<HangHoa> quanLyHangHoa) {
        this.quanLyHangHoa = quanLyHangHoa;
    }

    public void duLieuMoi(){
        try {
            HangHoa hangThucPham1 = new HangThucPham("tp01", "Rau", 0, 10000, consoleInput.ngayVN.parse("01/01/2022"), consoleInput.ngayVN.parse("11/01/2022"), "CT rau sach Da Lat GAP");
            HangHoa hangThucPham2 = new HangThucPham("tp02", "Dau", 20, 20000, consoleInput.ngayVN.parse("02/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CT rau sach Da Lat GAP");
            HangHoa hangThucPham3 = new HangThucPham("tp03", "Qua", 30, 30000, consoleInput.ngayVN.parse("03/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CT rau sach Da Lat GAP");
            HangHoa hangThucPham4 = new HangThucPham("tp04", "Bot mi", 40, 10000, consoleInput.ngayVN.parse("04/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH Co phan Tien Hung");
            HangHoa hangThucPham5 = new HangThucPham("tp05", "Gao", 50, 20000, consoleInput.ngayVN.parse("05/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH Vua Gao");
            
            HangHoa hangDienMay1 = new HangDienMay("dm01", "Noi com dien", 2, 500_000, 12, 100);
            HangHoa hangDienMay2 = new HangDienMay("dm02", "Am dun", 1_000, 100_000, 6, 100);
            HangHoa hangDienMay3 = new HangDienMay("dm03", "Dèn", 1_000, 100_000, 6, 100);
            HangHoa hangDienMay4 = new HangDienMay("dm04", "Quat", 1_000, 400_000, 12, 65);
            HangHoa hangDienMay5 = new HangDienMay("dm05", "O cam dien", 1_000, 100_000, 6, 50);
            

            HangHoa hangSanhSu1 = new HangSanhSu("ss01", "Chen", 5_000, 10_000, "CT san xuat to chen cao cap xuat khau Chau Au, My, Nhat", consoleInput.ngayVN.parse("08/04/2022"));
            HangHoa hangSanhSu2 = new HangSanhSu("ss02", "Chen kieu", 5, 10_000, "CT san xuat to chen cao cap xuat khau Chau Au, My, Nhat", consoleInput.ngayVN.parse("20/03/2022"));
            HangHoa hangSanhSu3 = new HangSanhSu("ss03", "Ly", 5_000, 10_000, "CT san xuat to chen cao cap xuat khau Chau Au, My, Nhat", consoleInput.ngayVN.parse("20/03/2022"));
            HangHoa hangSanhSu4 = new HangSanhSu("ss04", "To", 5_000, 5_000, "CT san xuat to chen cao cap xuat khau Chau Au, My, Nhat", consoleInput.ngayVN.parse("20/03/2022"));
            HangHoa hangSanhSu5 = new HangSanhSu("ss05", "Muong", 5_000, 5_000, "CT san xuat to chen cao cap xuat khau Chau Au, My, Nhat", consoleInput.ngayVN.parse("20/03/2022"));

            quanLyHangHoa.add(hangThucPham1);
            quanLyHangHoa.add(hangThucPham2);
            quanLyHangHoa.add(hangThucPham3);
            quanLyHangHoa.add(hangThucPham4);
            quanLyHangHoa.add(hangThucPham5);

            quanLyHangHoa.add(hangDienMay1);
            quanLyHangHoa.add(hangDienMay2);
            quanLyHangHoa.add(hangDienMay3);
            quanLyHangHoa.add(hangDienMay4);
            quanLyHangHoa.add(hangDienMay5);

            quanLyHangHoa.add(hangSanhSu1);
            quanLyHangHoa.add(hangSanhSu2);
            quanLyHangHoa.add(hangSanhSu3);
            quanLyHangHoa.add(hangSanhSu4);
            quanLyHangHoa.add(hangSanhSu5);
        } catch (ParseException e) {
            System.out.println("Loi roi ban oi!!!!");
            e.printStackTrace();
        }
        
    }

    public void themHangHoa() {
        while (true) {
            quanLyHangHoa.add(consoleInput.inputKhoHang(quanLyHangHoa));
            System.out.print("- Ban co muon tiep tuc them(Y/N): ");
            if (consoleInput.input.nextLine().equalsIgnoreCase("N")) {
                return;
            }
        }
    }  

    public void themTruocMaHangHoa() {
        System.out.print("- Nhap ma hang hoa can them truoc: ");
        String ma = consoleInput.input.nextLine();

        int viTri = timViTri(ma);

        if (viTri != -1) {
            quanLyHangHoa.add(viTri, consoleInput.inputKhoHang(quanLyHangHoa));
        } else {
            System.out.println("Ma hang hoa can them truoc khong co trong danh sach!!!!");
        }
        return;
    }

    public void themSauMaHangHoa() {
        System.out.print("- Nhap ma hang hoa can them sau: ");
        String ma = consoleInput.input.nextLine();

        int viTri = timViTri(ma);

        if (viTri != -1) {
            quanLyHangHoa.add(viTri + 1, consoleInput.inputKhoHang(quanLyHangHoa));
        } else {
            System.out.println("Ma hang hoa can them sau khong co trong danh sach!!!!");
        }
        return;
    }

    public HangHoa timHangHoaTheoMa(String maHH) {
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getMaHang().equalsIgnoreCase(maHH)) {
                hangHoa = hh;
            }
        }
        if (hangHoa == null) {
            System.out.println("Ma hang hoa can tim khong co trong danh sach!!!!");
        }
        return hangHoa;
    }

    public void xoaHangHoaTheoMa() {
        HangHoa hangHoa = null;
        System.out.print("- Nhap ma hang hoa can xoa: ");
        String ma = consoleInput.input.nextLine();

        hangHoa = timHangHoaTheoMa(ma);

        if (hangHoa != null) {
            quanLyHangHoa.remove(hangHoa);
            System.out.println("Hang hoa da duoc xoa khoi danh sach.");
        } else {
            System.out.println("Ma hang hoa can xoa khong co trong danh sach!!!!");
        }
    }

    public int timViTri(String maHH) {
        int viTri = -1;
        for (HangHoa hh : quanLyHangHoa) {
            viTri++;
            if (hh.getMaHang().equalsIgnoreCase(maHH)) {
                return viTri;
            }
        }
        return viTri;
    }

    public void suaHangHoaTheoMa(){
        HangHoa hangHoa = null;
        System.out.print("- Nhap ma hang hoa can sua: ");
        String ma = consoleInput.input.nextLine();

        hangHoa = timHangHoaTheoMa(ma);
        int viTri = timViTri(ma);

        if (hangHoa != null) {
            hangHoa = quanLyHangHoa.set(viTri, consoleInput.suaHangHoa(hangHoa));
            System.out.println("Hang hoa da duoc sua.");
        } else {
            System.out.println("Ma hang hoa can sua khong co trong danh sach!!!!");
        }
        return;
    }

    public void timKiemTheoLoai() {
        int loai;
        System.out.print("- Ban muon tim hang hoa loai nao? \n- Hang thuc pham - 1, hang dien may - 2, hang sanh su - 3: ");
        loai = consoleInput.input.nextInt();
        consoleInput.input.nextLine();
        for (HangHoa hangHoa : quanLyHangHoa) {
            if (loai == 1 && hangHoa instanceof HangThucPham) {
                System.out.println(hangHoa);
            } else if (loai == 2 && hangHoa instanceof HangDienMay) {
                System.out.println(hangHoa);
            } else if(loai == 3 && hangHoa instanceof HangSanhSu) {
                System.out.println(hangHoa);
            }
        }
    }
    
    public void timKiemTheoMa() {
        System.out.print("- Nhap ma hang hoa can tim: ");
        String maHH = consoleInput.input.nextLine();
        HangHoa hangHoa = null;
        hangHoa = timHangHoaTheoMa(maHH);
        if (hangHoa == null) {
            System.out.println("Ma hang hoa can tim khong co trong danh sach!!!!");
        } else {
            System.out.println(hangHoa);
        }
    }

    public void timKiemTheoTen() {
        System.out.print("- Nhap ten hang hoa can tim: ");
        String tenHH = consoleInput.input.nextLine();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getTenHang().equalsIgnoreCase(tenHH)) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Ten hang hoa can tim khong co trong danh sach!!!!");
        }
    }

    public void timKiemTheoSoLuongTonKho() {
        System.out.print("- Nhap so luong ton kho cua hang hoa can tim: ");
        int soLuong = consoleInput.input.nextInt();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getSoLuongTon() == soLuong) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("So luong hang hoa ton kho ban can tim khong co trong danh sach!!!!");
        }
    }

    public void timKiemTheoDonGia() {
        System.out.print("- Nhap don gia cua hang hoa can tim: ");
        double donGia = consoleInput.input.nextDouble();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getDonGia() == donGia) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Don gia ban can tim khong co trong danh sach!!!!");
        }
    }

    public void timKiemTheoKhoanGia() {
        System.out.print("- Nhap don gia cua hang hoa can tim tu: ");
        double giaNho = consoleInput.input.nextDouble();
        System.out.print("- Den: ");
        double gaiLon = consoleInput.input.nextDouble();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (giaNho <= hh.getDonGia() && hh.getDonGia() <= gaiLon) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Don gia ban can tim khong co trong danh sach!!!!");
        }
    }

    public void sapXepTangDanTheoMa() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> o1.getMaHang().compareToIgnoreCase(o2.getMaHang()));
    }

    public void sapXepGiamDanTheoMa() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> o2.getMaHang().compareToIgnoreCase(o1.getMaHang()));
    }

    public void sapXepTangDanTheoDonGia() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> sortDonGia(o1, o2));
    }
    
    public void sapXepGiamDanTheoDonGia() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> sortDonGia(o2, o1));
    }

    private int sortDonGia(HangHoa o1, HangHoa o2) {
        if (o1.getDonGia() > o2.getDonGia()) {
            return 1;
        } else if (o1.getDonGia() < o2.getDonGia()) {
            return -1;
        } else {
            return 0;
        }        
    }

    public void ghiFile() {
        file.writingFile(quanLyHangHoa);
    }

    public void docFile() {
        file.readingFile(quanLyHangHoa);
    }

    public void thongKe() {
        int tongSoLuongTonKhoHTP = 0;
        int tongSoLuongTonKhoHDM = 0;
        int tongSoLuongTonKhoHSS = 0;
        double donGiaHTP = 0;
        double donGiaHDM = 0;
        double donGiaHSS = 0;

        for (HangHoa hangHoa : quanLyHangHoa) {
            if (hangHoa instanceof HangThucPham) {
                tongSoLuongTonKhoHTP += hangHoa.getSoLuongTon();
                donGiaHTP += hangHoa.getDonGia();
            } else if (hangHoa instanceof HangDienMay) {
                tongSoLuongTonKhoHDM += hangHoa.getSoLuongTon();
                donGiaHDM += hangHoa.getDonGia();
            } else {
                tongSoLuongTonKhoHSS += hangHoa.getSoLuongTon();
                donGiaHSS += hangHoa.getDonGia();
            }
        }

        System.err.println("\t---------------Thong ke kho hang---------------");
        System.out.println("Tong so luong ton kho hang thuc pham: " + tongSoLuongTonKhoHTP);
        System.out.println("Tong so luong ton kho hang dien may: " + tongSoLuongTonKhoHDM);
        System.out.println("Tong so luong ton kho hang sanh su: " + tongSoLuongTonKhoHSS);
        System.out.println("Tong so luong ton kho cua kho hang: " + (tongSoLuongTonKhoHTP + tongSoLuongTonKhoHDM + tongSoLuongTonKhoHSS));
        System.out.println("Tong đon gia cua hang thuc pham: " + donGiaHTP);
        System.out.println("Tong đon gia cua hang dien may: " + donGiaHDM);
        System.out.println("Tong đon gia cua kho hang sanh su: " + donGiaHSS);
        System.out.println("Tong đon gia cua kho hang: " + (donGiaHTP + donGiaHDM + donGiaHSS));
    }

    public void baoCao() {
        String strHTP = "";
        String strHTPKhoBan = "";
        String strHDM = "";
        String strHDMBanDuoc = "";
        String strHSS = "";
        String strHSSBanCham = "";
        
        for (HangHoa hangHoa : quanLyHangHoa) {
            if (hangHoa instanceof HangThucPham) {
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Kho ban")) {
                    strHTPKhoBan += hangHoa.getTenHang() + "\t";
                } else {
                    strHTP += hangHoa.getTenHang() + "\t";
                }
            } else if (hangHoa instanceof HangDienMay){
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Ban duoc")) {
                    strHDMBanDuoc += hangHoa.getTenHang() + "\t";
                } else {
                    strHDM += hangHoa.getTenHang() + "\t";
                }
            } else if (hangHoa instanceof HangSanhSu){
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Ban cham")) {
                    strHSSBanCham += hangHoa.getTenHang() + "\t";
                } else {
                    strHSS += hangHoa.getTenHang() + "\t";
                }
            }
        }
        System.out.println("Nhung loai hang hoa duoc danh gia kho ban: " + strHTPKhoBan);
        System.out.println("Nhung loai hang hoa khong duoc danh gia: " + strHTP);
        System.out.println("Nhung loai hang hoa duoc danh gia ban duoc: " + strHDMBanDuoc);
        System.out.println("Nhung loai hang hoa khong duoc danh gia: " + strHDM);
        System.out.println("Nhung loai hang hoa duoc danh gia ban cham: " + strHSSBanCham);
        System.out.println("Nhung loai hang hoa khong duoc danh gia: " + strHSS);
    }
    public void inDanhSach() {
        for (HangHoa hangHoa : quanLyHangHoa) {
            System.out.println(hangHoa);
        }
    }
}
