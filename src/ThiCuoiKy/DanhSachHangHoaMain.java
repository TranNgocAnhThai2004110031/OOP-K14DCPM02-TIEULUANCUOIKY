/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.util.Scanner;

public class DanhSachHangHoaMain {
    public static void main(String[] args) {
        int luaChon;
        int key;
        Scanner sc = new Scanner(System.in); 
 
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        
        danhSachHangHoa.duLieuMoi();

        do {
            System.out.println("\n\t---------------- Menu ----------------");
            System.out.println("\t1. Them hang hoa.");
            System.out.println("\t2. Xoa hang hoa.");
            System.out.println("\t3. Sua hang hoa.");
            System.out.println("\t4. In danh sach hang hoa.");
            System.out.println("\t5. Tim kiem hang hoa.");
            System.out.println("\t6. Thong ke kho hang.");
            System.out.println("\t7. Bao cao.");
            System.out.println("\t8. Sap xep hang hoa.");
            System.out.println("\t9. Ghi file.");
            System.out.println("\t10. Doc file.");
            System.out.println("\t0. Thoat.");
            System.out.println("\t----------------------------------------");
            System.out.print("\n- Vui long nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    do {
                        System.out.println("\n\t---------- Menu them hang hoa ----------");
                        System.out.println("\t1. Them hang hoa.");
                        System.out.println("\t2. Them hang hoa truoc ma hang hoa.");
                        System.out.println("\t3. Them hang hoa sau ma hang hoa.");
                        System.out.println("\t0. Thoat.");
                        System.out.println("\t------------------------------------------");
                        System.out.print("\n- Vui long nhap lua chon: ");
                        key = sc.nextInt();
                        sc.nextLine();
                        switch (key) {
                            case 1:
                                danhSachHangHoa.themHangHoa();
                                break;
                            case 2:
                                danhSachHangHoa.themTruocMaHangHoa();
                                break;
                            case 3:
                                danhSachHangHoa.themSauMaHangHoa();
                                break;
                            default:
                                break;
                        }
                    } while (key != 0);
                    break;
                case 2:
                    danhSachHangHoa.xoaHangHoaTheoMa();
                    break;
                case 3:
                    danhSachHangHoa.suaHangHoaTheoMa();
                    break;
                case 4:
                    danhSachHangHoa.inDanhSach();
                    break;
                case 5:
                    do {
                        System.out.println("\n\t------------ Menu tim kiem hang ho--------------");
                        System.out.println("\t1. Tim kiem hang hoa theo loai hang.");
                        System.out.println("\t2. Tim kiem hang hoa theo ma hang hoa.");
                        System.out.println("\t3. Tim kiem hang hoa theo ten hang hoa.");
                        System.out.println("\t4. Tim kiem hang hoa theo so luong ton kho.");
                        System.out.println("\t5. Tim kiem hang hoa theo don gia.");
                        System.out.println("\t6. Tim kiem hang hoa theo khoan don gia.");
                        System.out.println("\t0. Thoat.");
                        System.out.println("\t--------------------------------------------------");
                        System.out.print("\n- Vui long nhap lua chon: ");
                        key = sc.nextInt();
                        sc.nextLine();
                        switch (key) {
                            case 1:
                                danhSachHangHoa.timKiemTheoLoai();
                                break;
                            case 2:
                                danhSachHangHoa.timKiemTheoMa();
                                break;
                            case 3:
                                danhSachHangHoa.timKiemTheoTen();
                                break;
                            case 4:
                                danhSachHangHoa.timKiemTheoSoLuongTonKho();
                                break;
                            case 5:
                                danhSachHangHoa.timKiemTheoDonGia();
                                break;
                            case 6:
                                danhSachHangHoa.timKiemTheoKhoanGia();
                                break;
                            default:
                                break;
                        }
                    } while (key != 0);
                    break;
                case 6:
                    danhSachHangHoa.thongKe();
                    break;
                case 7: 
                    danhSachHangHoa.baoCao();
                    break;
                case 8:
                    do {
                        System.out.println("\n\t----------- Menu sap xep hang hoa -------------");
                        System.out.println("\t1. Sap xep hang hoa tang dan theo ma.");
                        System.out.println("\t2. Sap xep hang hoa giam dan theo ma.");
                        System.out.println("\t3. Sap xep hang hoa tang dan theo don gia.");
                        System.out.println("\t4. Sap xep hang hoa giam dan theo don gia.");
                        System.out.println("\t0. Thoat.");
                        System.out.println("\t-------------------------------------------------");
                        System.out.print("\n- Vui long nhap lua chon: ");
                        key = sc.nextInt();
                        sc.nextLine();
                        switch (key) {
                            case 1:
                                danhSachHangHoa.sapXepTangDanTheoMa();
                                danhSachHangHoa.inDanhSach();
                                break;
                            case 2:
                                danhSachHangHoa.sapXepGiamDanTheoMa();
                                danhSachHangHoa.inDanhSach();
                                break;
                            case 3:
                                danhSachHangHoa.sapXepTangDanTheoDonGia();
                                danhSachHangHoa.inDanhSach();
                            case 4:
                                danhSachHangHoa.sapXepGiamDanTheoDonGia();
                                danhSachHangHoa.inDanhSach();
                            default:
                                break;
                        }
                    } while (key != 0);
                    break;
                case 9:
                    danhSachHangHoa.ghiFile();                    
                    break;
                case 10:
                    danhSachHangHoa.docFile();
                default:
                    break;
            }
        } while (luaChon != 0);
    }
    
}
