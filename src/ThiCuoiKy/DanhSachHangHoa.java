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

    public void duLieuMoi() throws ParseException {
        HangHoa hangThucPham1 = new HangThucPham("tp01", "Rau", 0, 10000, consoleInput.ngayVN.parse("01/01/2022"), consoleInput.ngayVN.parse("11/01/2022"), "CTTNHH ...");
        HangHoa hangThucPham2 = new HangThucPham("tp02", "Củ", 20, 20000, consoleInput.ngayVN.parse("02/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        HangHoa hangThucPham3 = new HangThucPham("tp03", "Quả", 30, 30000, consoleInput.ngayVN.parse("03/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        HangHoa hangThucPham4 = new HangThucPham("tp04", "Bột", 40, 10000, consoleInput.ngayVN.parse("04/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        HangHoa hangThucPham5 = new HangThucPham("tp05", "Gạo", 50, 20000, consoleInput.ngayVN.parse("05/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        
        HangHoa hangDienMay1 = new HangDienMay("dm01", "Nồi cơm điện", 2, 500_000, 12, 100);
        HangHoa hangDienMay2 = new HangDienMay("dm02", "Ấm đun", 1_000, 100_000, 6, 100);
        HangHoa hangDienMay3 = new HangDienMay("dm03", "Đèn", 1_000, 100_000, 6, 100);
        HangHoa hangDienMay4 = new HangDienMay("dm04", "Quạt", 1_000, 400_000, 12, 65);
        HangHoa hangDienMay5 = new HangDienMay("dm05", "Ổ cắm điện", 1_000, 100_000, 6, 50);
        

        HangHoa hangSanhSu1 = new HangSanhSu("ss01", "Chén", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("08/04/2022"));
        HangHoa hangSanhSu2 = new HangSanhSu("ss02", "Chén kiểu", 5, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        HangHoa hangSanhSu3 = new HangSanhSu("ss03", "Ly", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        HangHoa hangSanhSu4 = new HangSanhSu("ss04", "Tô", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        HangHoa hangSanhSu5 = new HangSanhSu("ss05", "Muỗng", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));

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
    }

    public void themHangHoa() {
        quanLyHangHoa.add(consoleInput.inputKhoHang());
    }  

    public boolean kiemTraMaHangHoa(String ma) {
        for (HangHoa hangHoa : quanLyHangHoa) {
            if (hangHoa.getMaHang().equalsIgnoreCase(ma)) {
                System.out.println("Mã hàng hóa đã bị trùng!!!");
                return false;
            }
        }
        return true;
    }

    public void themTruocMaHangHoa() {
        System.out.print("- Nhập mã hàng hoá cần cần thêm trước: ");
        String ma = consoleInput.input.nextLine();

        int viTri = timViTri(ma);

        if (viTri != -1) {
            quanLyHangHoa.add(viTri, consoleInput.inputKhoHang());
            System.out.println("Hàng hoá đã được thêm vào danh sách.");
        } else {
            System.out.println("Mã hàng hoá cần thêm trước không có trong danh sách!!!!");
        }
        return;
    }

    public void themSauMaHangHoa() {
        System.out.print("- Nhập mã hàng hoá cần cần thêm sau: ");
        String ma = consoleInput.input.nextLine();

        // hangHoa = timHangHoaTheoMa(ma);
        int viTri = timViTri(ma);

        if (viTri != -1) {
            quanLyHangHoa.add(viTri + 1, consoleInput.inputKhoHang());
            System.out.println("Hàng hoá đã được thêm vào danh sách.");
        } else {
            System.out.println("Mã hàng hoá cần thêm sau không có trong danh sách!!!!");
        }
        return;
    }

    public HangHoa timHangHoaTheoMa(String maHH) {
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getMaHang().toString().equalsIgnoreCase(maHH)) {
                hangHoa = hh;
            }
        }
        if (hangHoa == null) {
            System.out.println("Mã hàng hoá cần tìm không có trong danh sách!!!!");
        }
        return hangHoa;
    }

    public void xoaHangHoaTheoMa() {
        HangHoa hangHoa = null;
        System.out.print("- Nhập mã hàng hoá cần xoá: ");
        String ma = consoleInput.input.nextLine();

        hangHoa = timHangHoaTheoMa(ma);

        if (hangHoa != null) {
            quanLyHangHoa.remove(hangHoa);
            System.out.println("Hàng hoá đã được xoá khỏi danh sách.");
        } else {
            System.out.println("Mã hàng hoá cần xoá không có trong danh sách!!!!");
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
        System.out.print("- Nhập mã hàng hoá cần sửa: ");
        String ma = consoleInput.input.nextLine();

        hangHoa = timHangHoaTheoMa(ma);
        int viTri = timViTri(ma);

        if (hangHoa != null) {
            hangHoa = quanLyHangHoa.set(viTri, consoleInput.suaHangHoa(hangHoa));
            System.out.println("Hàng hoá đã được sửa.");
        } else {
            System.out.println("Mã hàng hoá cần sửa không có trong danh sách!!!!");
        }
        return;
    }

    public void timKiemTheoLoai() {
        int loai;
        System.out.print("- Bạn muốn tìm hàng hoá loại nào? \n- Hàng thực phẩm - 1, hàng điện máy - 2, hàng sành sứ - 3: ");
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
        System.out.print("- Nhập mã hàng hoá cần tìm: ");
        String maHH = consoleInput.input.nextLine();
        HangHoa hangHoa = null;
        hangHoa = timHangHoaTheoMa(maHH);
        if (hangHoa == null) {
            System.out.println("Mã hàng hoá cần tìm không có trong danh sách!!!!");
        } else {
            System.out.println(hangHoa);
        }
    }

    public void timKiemTheoTen() {
        System.out.print("- Nhập tên hàng hoá cần tìm: ");
        String tenHH = consoleInput.input.nextLine();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getTenHang().equalsIgnoreCase(tenHH)) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Tên hàng hoá cần tìm không có trong danh sách!!!!");
        }
    }

    public void timKiemTheoSoLuongTonKho() {
        System.out.print("- Nhập số lượng tồn kho của hàng hoá cần tìm: ");
        int soLuong = consoleInput.input.nextInt();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getSoLuongTon() == soLuong) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Số lượng hàng hoá tồn kho bạn cần tìm không có trong danh sách!!!!");
        }
    }

    public void timKiemTheoDonGia() {
        System.out.print("- Nhập đơn giá của hàng hoá cần tìm: ");
        double donGia = consoleInput.input.nextDouble();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (hh.getDonGia() == donGia) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Đơn giá bạn cần tìm không có trong danh sách!!!!");
        }
    }

    public void timKiemTheoKhoanGia() {
        System.out.print("- Nhập đơn giá của hàng hoá cần tìm từ: ");
        double giaNho = consoleInput.input.nextDouble();
        System.out.print("- Đến: ");
        double gaiLon = consoleInput.input.nextDouble();
        HangHoa hangHoa = null;
        for (HangHoa hh : quanLyHangHoa) {
            if (giaNho <= hh.getDonGia() && hh.getDonGia() <= gaiLon) {
                hangHoa = hh;
                System.out.println(hangHoa);
            }
        }
        if (hangHoa == null) {
            System.out.println("Đơn giá bạn cần tìm không có trong danh sách!!!!");
        }
    }

    public void sapXepTangDanTheoMa() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> o1.getMaHang().compareTo(o2.getMaHang()));
    }

    public void sapXepGiamDanTheoMa() {
        Collections.sort(quanLyHangHoa, (o1, o2) -> o2.getMaHang().compareTo(o1.getMaHang()));
    }

    public void ghiFile() {
        file.writingFile(quanLyHangHoa);
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
        
        for (HangHoa hangHoa : quanLyHangHoa) {
            if (hangHoa instanceof HangThucPham) {
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Khó bán")) {
                    strHTPKhoBan += hangHoa.getTenHang() + "\t";
                } else {
                    strHTP += hangHoa.getTenHang() + "\t";
                }
            } else if (hangHoa instanceof HangDienMay){
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Bán được")) {
                    strHDMBanDuoc += hangHoa.getTenHang() + "\t";
                } else {
                    strHDM += hangHoa.getTenHang() + "\t";
                }
            } else if (hangHoa instanceof HangSanhSu){
                if (hangHoa.danhGiaMDBB().equalsIgnoreCase("Bán chậm")) {
                    strHSSBanCham += hangHoa.getTenHang() + "\t";
                } else {
                    strHSS += hangHoa.getTenHang() + "\t";
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
        for (HangHoa hangHoa : quanLyHangHoa) {
            System.out.println(hangHoa);
        }
    }
}
