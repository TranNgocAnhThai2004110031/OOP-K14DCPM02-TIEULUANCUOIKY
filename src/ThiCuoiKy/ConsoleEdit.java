package ThiCuoiKy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleEdit {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private int thoiGianBaoHanh;
    private int congSuat;
    private double donGia; 
    private Date ngaySanXuat;
    private Date ngayHetHan;
    private Date ngayNhapKho;
    public static Scanner input = new Scanner(System.in);
    SimpleDateFormat ngayVN = new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa suaHangHoa(HangHoa hangHoa){

        maHang = hangHoa.getMaHang();
        System.out.print("- Nhập tên hàng hoá: ");
        tenHang = input.nextLine();   
        try {
            System.out.print("- Nhập số lượng tồn kho: ");
            soLuongTon = input.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Bạn nhập đã bị lỗi!!!!");
            System.out.println("Bạn vui lòng nhập số nha!!!!");
            ex.printStackTrace();
            input.nextLine();
        }
        input.nextLine();
        System.out.print("- Nhập đơn giá: ");
        try {
            donGia = input.nextDouble();
        } catch (InputMismatchException ex) {
            System.out.println("Bạn nhập đã bị lỗi!!!!");
            ex.printStackTrace();
            input.nextLine();
        } 
        
        input.nextLine();
        System.out.print("- Bạn muốn nhập hàng hoá loại nào? \n- Hàng thực phẩm - 1, hàng điện máy - 2, hàng sành sứ - 3: ");
        int loai = input.nextInt();
        input.nextLine();
        
        if(loai == 1){
            System.out.print("- Nhập ngày sản xuất: ");
            try {
                ngaySanXuat = ngayVN.parse(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Bạn đã nhập sai kiểu định dạng ngày!!!!");
                System.out.println("Bạn vui lòng nhập theo đúng kiểu định dạng dd/MM/yyyy!!!!");
                e.printStackTrace();
                input.nextLine();
            } 
                       
            System.out.print("- Nhập ngày hết hạn: ");
            try {
                ngayHetHan = ngayVN.parse(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Bạn đã nhập sai kiểu định dạng ngày!!!!");
                System.out.println("Bạn vui lòng nhập theo đúng kiểu định dạng dd/MM/yyyy!!!!");
                e.printStackTrace();
                input.nextLine();
            }
             
            System.out.print("- Nhập nhà cung cấp: ");
            String nhaCungCap = input.nextLine();

            hangHoa  = new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
        } else if (loai == 2) {
            System.out.print("- Nhập thời gia bảo hành(tháng): ");
            try {
                thoiGianBaoHanh = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Bạn nhập đã bị lỗi!!!!");
                System.out.println("Bạn vui lòng nhập số nha!!!!");
                ex.printStackTrace();
                input.nextLine();
            }
            
            System.out.print("- Nhập công suất: ");
            try {
                congSuat = input.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Bạn nhập đã bị lỗi!!!!");
                System.out.println("Bạn vui lòng nhập số nha!!!!");
                ex.printStackTrace();
                input.nextLine();
            }

            hangHoa = new HangDienMay(maHang, tenHang, soLuongTon, donGia, thoiGianBaoHanh, congSuat);
        } else {
            System.out.print("- Nhập nhà sản xuất: ");
            String nhaSanXuat = input.nextLine();
            System.out.print("- Nhập ngày nhập kho: ");
            try {
                ngayNhapKho = ngayVN.parse(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Bạn đã nhập sai kiểu định dạng ngày!!!!");
                System.out.println("Bạn vui lòng nhập theo đúng kiểu định dạng dd/MM/yyyy!!!!");
                e.printStackTrace();
                input.nextLine();
            } 

            hangHoa = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSanXuat, ngayNhapKho);
        }
        return hangHoa;
    } 
}