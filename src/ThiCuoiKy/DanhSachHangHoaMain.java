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
        Scanner sc = new Scanner(System.in); 
 
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        try {
            danhSachHangHoa.duLieuMoi();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        GhiFile ghiFile = new GhiFile();
        // try {
        //     ghiFile.writingFile();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
       
        
        do {
            System.out.println("\n\t-------------------------------- Menu --------------------------------");
            System.out.println("\t1. Thêm hàng hoá.");
            System.out.println("\t2. Xoá hàng hoá.");
            System.out.println("\t3. Sửa hàng hoá.");
            System.out.println("\t4. Tìm kiếm hàng hoá.");
            System.out.println("\t5. In danh sách hàng hoá.");
            System.out.println("\t6. Thống kê kho hàng.");
            System.out.println("\t7. Báo cáo.");
            System.out.println("\t8. Ghi file.");
            System.out.println("\t9. Đọc file.");
            System.out.println("\t0. Thoát.");
            System.out.println("\t------------------------------------------------------------------------");
            System.out.print("\n- Vui lòng nhập lựa chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    danhSachHangHoa.themHangHoa();
                    break;
                case 2:
                    danhSachHangHoa.xoaHangHoaTheoMa();
                    break;
                case 3:
                    danhSachHangHoa.suaHangHoaTheoMa();
                case 4:
                    do {
                        System.out.println("\n\t-------------------------------- Menu --------------------------------");
                        System.out.println("\t1. Tìm hàng hoá theo loại hàng.");
                        System.out.println("\t2. Tìm kiếm hàng hoá theo mã hàng hoá.");
                        System.out.println("\t3. Tìm kiếm hàng hoá theo tên hàng hoá.");
                        System.out.println("\t4. Tìm kiếm hàng hoá theo số lượng tồn kho.");
                        System.out.println("\t0. Thoát.");
                        System.out.println("\t------------------------------------------------------------------------");
                        System.out.print("\n- Vui lòng nhập lựa chọn: ");
                        luaChon = sc.nextInt();
                        sc.nextLine();
                        switch (luaChon) {
                            case 0:
                                return;
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
                            default:
                                break;
                        }

                    } while (luaChon != 0);
                    break;
                case 5:
                    danhSachHangHoa.inDanhSach();
                    break;
                case 6:
                    danhSachHangHoa.thongKe();
                    break;
                case 7: 
                    danhSachHangHoa.baoCao();
                    break;
                case 8:
                    try {
                        ghiFile.writingFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        ghiFile.readingFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                default:
                    break;
            }
        } while (luaChon != 0);
    }
}
