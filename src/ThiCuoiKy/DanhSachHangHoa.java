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
    private int tongSoLuongTonKhoHTP;
    private int tongSoLuongTonKhoHDM;
    private int tongSoLuongTonKhoHSS;
    private double donGiaHTP;
    private double donGiaHDM;
    private double donGiaHSS;

    private List<KhoHang> quanLyKhoHang = new ArrayList<>();
    ConsoleInput consoleInput = new ConsoleInput();  
    /**
     * 
     */
    public DanhSachHangHoa() {
    }

    /**
     * @param quanLyKhoHang
     */
    public DanhSachHangHoa(List<KhoHang> quanLyKhoHang) {
        this.quanLyKhoHang = quanLyKhoHang;
    }

    public void duLieuMoi() throws ParseException {
        KhoHang hangThucPham1 = new HangThucPham("tp01", "Rau", 0, 10000, consoleInput.ngayVN.parse("01/01/2022"), consoleInput.ngayVN.parse("11/01/2022"), "CTTNHH ...");
        KhoHang hangThucPham2 = new HangThucPham("tp02", "Củ", 20, 20000, consoleInput.ngayVN.parse("02/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        KhoHang hangThucPham3 = new HangThucPham("tp03", "Quả", 30, 30000, consoleInput.ngayVN.parse("03/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        KhoHang hangThucPham4 = new HangThucPham("tp04", "Bột", 40, 10000, consoleInput.ngayVN.parse("04/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        KhoHang hangThucPham5 = new HangThucPham("tp05", "Gạo", 50, 20000, consoleInput.ngayVN.parse("05/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        
        KhoHang hangDienMay1 = new HangDienMay("dm01", "Nồi cơm điện", 2, 500_000, 12, 100);
        KhoHang hangDienMay2 = new HangDienMay("dm02", "Ấm đun", 1_000, 100_000, 6, 100);
        KhoHang hangDienMay3 = new HangDienMay("dm03", "Đèn", 1_000, 100_000, 6, 100);
        KhoHang hangDienMay4 = new HangDienMay("dm04", "Quạt", 1_000, 400_000, 12, 65);
        KhoHang hangDienMay5 = new HangDienMay("dm05", "Ổ cắm điện", 1_000, 100_000, 6, 50);
        

        KhoHang hangSanhSu1 = new HangSanhSu("ss01", "Chén", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("08/04/2022"));
        KhoHang hangSanhSu2 = new HangSanhSu("ss02", "Chén kiểu", 5, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        KhoHang hangSanhSu3 = new HangSanhSu("ss03", "Ly", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        KhoHang hangSanhSu4 = new HangSanhSu("ss04", "Tô", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        KhoHang hangSanhSu5 = new HangSanhSu("ss05", "Muỗng", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));

        quanLyKhoHang.add(hangThucPham1);
        quanLyKhoHang.add(hangThucPham2);
        quanLyKhoHang.add(hangThucPham3);
        quanLyKhoHang.add(hangThucPham4);
        quanLyKhoHang.add(hangThucPham5);

        quanLyKhoHang.add(hangDienMay1);
        quanLyKhoHang.add(hangDienMay2);
        quanLyKhoHang.add(hangDienMay3);
        quanLyKhoHang.add(hangDienMay4);
        quanLyKhoHang.add(hangDienMay5);

        quanLyKhoHang.add(hangSanhSu1);
        quanLyKhoHang.add(hangSanhSu2);
        quanLyKhoHang.add(hangSanhSu3);
        quanLyKhoHang.add(hangSanhSu4);
        quanLyKhoHang.add(hangSanhSu5);
    }

    public void themHangHoa() {
        quanLyKhoHang.add(consoleInput.inputKhoHang());
    }  

    // timkiem
    public KhoHang timHangHoaTheoMa(String maHH) {
        KhoHang khoHang = null;
        for (KhoHang kh : quanLyKhoHang) {
            if (kh.getMaHang().toString().equalsIgnoreCase(maHH)) {
                khoHang = kh;
            }
        }
        if (khoHang == null) {
            System.out.println("Mã hàng hoá cần tìm không có trong danh sách!!!!");
        }
        return khoHang;
    }

    public void xoaHangHoaTheoMa() {
        KhoHang khoHang = null;
        System.out.print("- Nhập mã hàng hoá cần xoá: ");
        String ma = consoleInput.input.nextLine();

        khoHang = timHangHoaTheoMa(ma);

        if (khoHang != null) {
            quanLyKhoHang.remove(khoHang);
            System.out.println("Hàng hoá đã được xoá khỏi danh sách.");
        } else {
            System.out.println("Mã hàng hoá cần xoá không có trong danh sách!!!!");
        }
    }

    // public int timViTriHangHoa(KhoHang khoHang){
    //     int viTri = -1;
        
    //     viTri = quanLyKhoHang.indexOf(khoHang);
    //     for (KhoHang kh : quanLyKhoHang) {
    //         viTri++;
    //         if (kh == khoHang) {
    //             return viTri;
    //         }
    //     }
    //     return viTri;
    // }

    public int timViTri(String maHH) {
        int viTri = -1;
        for (KhoHang kh : quanLyKhoHang) {
            viTri++;
            if (kh.getMaHang().equalsIgnoreCase(maHH)) {
                return viTri;
            }
        }
        return viTri;
    }
    // sua
    public void suaHangHoa(int viTri, KhoHang khoHang) {
        khoHang = consoleInput.inputKhoHang();
        this.quanLyKhoHang.set(viTri, khoHang);
    }

    public void suaHangHoaTheoMa(){
        KhoHang khoHang = null;
        System.out.print("- Nhập mã hàng hoá cần sửa: ");
        String ma = consoleInput.input.nextLine();

        khoHang = timHangHoaTheoMa(ma);
        int viTri = timViTri(ma);

        if (khoHang != null) {
            khoHang = quanLyKhoHang.set(viTri, consoleInput.inputKhoHang());
            System.out.println("Hàng hoá đã được sửa.");
        } else {
            System.out.println("Mã hàng hoá cần sửa không có trong danh sách!!!!");
        }
    }
    // timkiem
    // public HangThucPham timHangHoaTheoHangThucPham(String maHH) {
    //     HangThucPham hangThucPham = null;
    //     for (KhoHang khoHang : quanLyKhoHang) {
    //         if (khoHang.getMaHang().toString().equalsIgnoreCase(maHH) && khoHang instanceof HangThucPham) {
    //             hangThucPham = (HangThucPham) khoHang;
    //         }
    //     }
    //     return hangThucPham;
    // }

    public void timKiemTheoLoai() {
        int loai;
        System.out.print("- Bạn muốn tìm hàng hoá loại nào? \n- Hàng thực phẩm - 1, hàng điện máy - 2, hàng sành sứ - 3: ");
        loai = consoleInput.input.nextInt();
        consoleInput.input.nextLine();
        for (KhoHang khoHang : quanLyKhoHang) {
            if (loai == 1 && khoHang instanceof HangThucPham) {
                System.out.println(khoHang);
            } else if (loai == 2 && khoHang instanceof HangDienMay) {
                System.out.println(khoHang);
            } else if(loai == 3 && khoHang instanceof HangSanhSu) {
                System.out.println(khoHang);
            }
        }
    }
    // theo mã
    public void timKiemTheoMa() {
        System.out.print("- Nhập mã hàng hoá cần tìm: ");
        String maHH = consoleInput.input.nextLine();
        KhoHang khoHang = null;
        khoHang = timHangHoaTheoMa(maHH);
        if (khoHang == null) {
            System.out.println("Mã hàng hoá cần tìm không có trong danh sách!!!!");
        } else {
            System.out.println(khoHang);
        }
    }

    public void timKiemTheoTen() {
        System.out.print("- Nhập tên hàng hoá cần tìm: ");
        String tenHH = consoleInput.input.nextLine();
        KhoHang khoHang = null;
        for (KhoHang khoHang2 : quanLyKhoHang) {
            if (khoHang2.getTenHang().equalsIgnoreCase(tenHH)) {
                khoHang = khoHang2;
                System.out.println(khoHang2);
            }
        }
        if (khoHang == null) {
            System.out.println("Tên hàng hoá cần tìm không có trong danh sách!!!!");
        }
    }

    public void timKiemTheoSoLuongTonKho() {
        System.out.print("- Nhập số lượng tồn kho của hàng hoá cần tìm: ");
        int soLuong = consoleInput.input.nextInt();
        KhoHang khoHang = null;
        for (KhoHang khoHang2 : quanLyKhoHang) {
            if (khoHang2.getSoLuongTon() == soLuong) {
                khoHang = khoHang2;
                System.out.println(khoHang2);
            }
        }
        if (khoHang == null) {
            System.out.println("Số lượng hàng hoá tồn kho bạn cần tìm không có trong danh sách!!!!");
        }
    }

    // public void timHangHoaVaInRaManHinh() {
    //     System.out.print("- Nhập mã hàng hoá cần tìm: ");
    //     String maHD = consoleInput.input.nextLine();
    //     KhoHang khoHang = null;
    //     for (KhoHang kh : quanLyKhoHang) {
    //         if (khoHang.getMaHang().toString().equalsIgnoreCase(maHD)) {
    //             khoHang = kh;
    //             System.out.println(khoHang);
    //         }
    //     }
    //     if (khoHang == null) {
    //         System.out.println("Mã hàng hoá cần tìm không có trong danh sách!!!!");
    //     }
    //     return;
    // }

    public void sapXepTangDanTheoMa() {
        Collections.sort(quanLyKhoHang, (o1, o2) -> o1.getMaHang().compareTo(o2.getMaHang()));
    }

    public void sapXepGiamDanTheoMa() {
        Collections.sort(quanLyKhoHang, (o1, o2) -> o2.getMaHang().compareTo(o1.getMaHang()));
    }

    public void thongKe() {
        for (KhoHang khoHang : quanLyKhoHang) {
            if (khoHang instanceof HangThucPham) {
                tongSoLuongTonKhoHTP += khoHang.getSoLuongTon();
                donGiaHTP += khoHang.getDonGia();
            } else if (khoHang instanceof HangDienMay) {
                tongSoLuongTonKhoHDM += khoHang.getSoLuongTon();
                donGiaHDM += khoHang.getDonGia();
            } else {
                tongSoLuongTonKhoHSS += khoHang.getSoLuongTon();
                donGiaHSS += khoHang.getDonGia();
            }
        }

        System.err.println("\t---------------Thống kê kho hàng---------------");
        System.out.println("Tổng số lượng tồn kho hàng thực phẩm: " + tongSoLuongTonKhoHTP);
        System.out.println("Tổng số lượng tồn kho hàng điện máy: " + tongSoLuongTonKhoHDM);
        System.out.println("Tổng số lượng tồn kho hàng sành sứ: " + tongSoLuongTonKhoHSS);
        System.out.println("Tổng số lượng tồn kho của kho hàng: " + (tongSoLuongTonKhoHTP + tongSoLuongTonKhoHDM + tongSoLuongTonKhoHSS));
        System.out.println("Tổng đơn giá của hàng thực phẩm: " + donGiaHTP);
        System.out.println("Tổng đơn giá của hàng điện máy: " + donGiaHDM);
        System.out.println("Tổng đơn giá của kho hàng sành sứ: " + donGiaHSS);
        System.out.println("Tổng đơn giá của kho hàng: " + (donGiaHTP + donGiaHDM + donGiaHSS));
    }

    public void baoCao() {
        String strHTP = "";
        String strHTPKhoBan = "";
        String strHDM = "";
        String strHDMBanDuoc = "";
        String strHSS = "";
        String strHSSBanCham = "";
        
        for (KhoHang khoHang : quanLyKhoHang) {
            if (khoHang instanceof HangThucPham) {
                if (khoHang.danhGiaMDBB().equalsIgnoreCase("Khó bán")) {
                    strHTPKhoBan += khoHang.getTenHang() + "\t";
                } else {
                    strHTP += khoHang.getTenHang() + "\t";
                }
            } else if (khoHang instanceof HangDienMay){
                if (khoHang.danhGiaMDBB().equalsIgnoreCase("Bán được")) {
                    strHDMBanDuoc += khoHang.getTenHang() + "\t";
                } else {
                    strHDM += khoHang.getTenHang() + "\t";
                }
            } else if (khoHang instanceof HangSanhSu){
                if (khoHang.danhGiaMDBB().equalsIgnoreCase("Bán chậm")) {
                    strHSSBanCham += khoHang.getTenHang() + "\t";
                } else {
                    strHSS += khoHang.getTenHang() + "\t";
                }
            }
        }
        System.out.println("Những loại hàng hoá được đánh giá khó bán: " + strHTPKhoBan);
        System.out.println("Những loại hàng hoá không được đánh giá: " + strHTP);
        System.out.println("Những loại hàng hoá được đánh giá bán được: " + strHDMBanDuoc);
        System.out.println("Những loại hàng hoá không được đánh giá: " + strHDM);
        System.out.println("Những loại hàng hoá được đánh giá bán chậm: " + strHSSBanCham);
        System.out.println("Những loại hàng hoá không được đánh giá: " + strHSS);
    }
    public void inDanhSach() {
        for (KhoHang khoHang : quanLyKhoHang) {
            System.out.println(khoHang);
        }
    }
}
