/*
* created date: Mar 28, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.text.ParseException;
import java.util.Scanner;

public class DanhSachHangHoaMain {
    public static void main(String[] args) {
        int luaChon;
        int key;
        Scanner sc = new Scanner(System.in); 
 
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        try {
            danhSachHangHoa.duLieuMoi();
        } catch (ParseException e) {
            e.printStackTrace();
        }       
        
        do {
            System.out.println("\n\t-------------------------------- Menu --------------------------------");
            System.out.println("\t1. Thêm hàng hoá.");
            System.out.println("\t2. Xoá hàng hoá.");
            System.out.println("\t3. Sửa hàng hoá.");
            System.out.println("\t4. In danh sách hàng hoá.");
            System.out.println("\t5. Tìm kiếm hàng hoá.");
            System.out.println("\t6. Thống kê kho hàng.");
            System.out.println("\t7. Báo cáo.");
            System.out.println("\t8. Sắp xếp hàng hóa.");
            System.out.println("\t9. Ghi file.");
            System.out.println("\t10. Đọc file.");
            System.out.println("\t0. Thoát.");
            System.out.println("\t------------------------------------------------------------------------");
            System.out.print("\n- Vui lòng nhập lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    do {
                        System.out.println("\n\t-------------------------------- Menu --------------------------------");
                        System.out.println("\t1. Thêm hàng hóa.");
                        System.out.println("\t2. Thêm hàng hóa trước mã hàng hóa.");
                        System.out.println("\t3. Thêm hàng hóa sau mã hàng hóa.");
                        System.out.println("\t0. Thoát.");
                        System.out.println("\t------------------------------------------------------------------------");
                        System.out.print("\n- Vui lòng nhập lựa chọn: ");
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
                        System.out.println("\n\t-------------------------------- Menu --------------------------------");
                        System.out.println("\t1. Tìm hàng hoá theo loại hàng.");
                        System.out.println("\t2. Tìm kiếm hàng hoá theo mã hàng hoá.");
                        System.out.println("\t3. Tìm kiếm hàng hoá theo tên hàng hoá.");
                        System.out.println("\t4. Tìm kiếm hàng hoá theo số lượng tồn kho.");
                        System.out.println("\t5. Tìm kiếm hàng hoá theo đơn giá.");
                        System.out.println("\t6. Tìm kiếm hàng hoá theo khoản đơn giá.");
                        System.out.println("\t0. Thoát.");
                        System.out.println("\t------------------------------------------------------------------------");
                        System.out.print("\n- Vui lòng nhập lựa chọn: ");
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
                        System.out.println("\n\t-------------------------------- Menu --------------------------------");
                        System.out.println("\t1. Sắp xếp hàng hóa tăng dần theo mã.");
                        System.out.println("\t2. Sắp xếp hàng hóa giảm dần theo mã.");
                        System.out.println("\t0. Thoát.");
                        System.out.println("\t------------------------------------------------------------------------");
                        System.out.print("\n- Vui lòng nhập lựa chọn: ");
                        key = sc.nextInt();
                        sc.nextLine();
                        switch (key) {
                            case 1:
                                danhSachHangHoa.sapXepTangDanTheoMa();
                                break;
                            case 2:
                                danhSachHangHoa.sapXepGiamDanTheoMa();
                                break;
                            
                            default:
                                break;
                        }
                    } while (key != 0);
                    break;
                case 9:
                    danhSachHangHoa.ghiFile();
                    break;
                case 10:
                    try {
                        // ghiFile.readingFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                default:
                    break;
            }
        } while (luaChon != 0);
    }
}
