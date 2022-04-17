/*
* created date: Apr 04, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFile {
    ConsoleInput consoleInput = new ConsoleInput();  
    public void readingFile(List<HangHoa> list) {
        try {
            FileInputStream inFile = new FileInputStream("htp.dat");
            ObjectInputStream objIn = new ObjectInputStream(inFile);
        } catch (Exception e) {
            System.out.println("Lỗi rồi bạn ơi!!!!");
            e.printStackTrace();
        }
        
       
        // List<HangHoa> list = (List) objIn.readObject();

        // chỉnh sửa, cập nhật thông tin của HangHoa

        for (HangHoa khoHang: list) {
            System.out.println(khoHang);
        }
    
    }

    public void writingFile(List<HangHoa> list) {
        // HangHoa hangThucPham1 = new HangThucPham("tp01", "Rau", 0, 10000, consoleInput.ngayVN.parse("01/01/2022"), consoleInput.ngayVN.parse("11/01/2022"), "CTTNHH ...");
        // HangHoa hangThucPham2 = new HangThucPham("tp02", "Củ", 20, 20000, consoleInput.ngayVN.parse("02/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        // HangHoa hangThucPham3 = new HangThucPham("tp03", "Quả", 30, 30000, consoleInput.ngayVN.parse("03/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        // HangHoa hangThucPham4 = new HangThucPham("tp04", "Bột", 40, 10000, consoleInput.ngayVN.parse("04/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        // HangHoa hangThucPham5 = new HangThucPham("tp05", "Gạo", 50, 20000, consoleInput.ngayVN.parse("05/03/2022"), consoleInput.ngayVN.parse("11/11/2022"), "CTTNHH ...");
        
        // HangHoa hangDienMay1 = new HangDienMay("dm01", "Nồi cơm điện", 2, 500_000, 12, 100);
        // HangHoa hangDienMay2 = new HangDienMay("dm02", "Ấm đun", 1_000, 100_000, 6, 100);
        // HangHoa hangDienMay3 = new HangDienMay("dm03", "Đèn", 1_000, 100_000, 6, 100);
        // HangHoa hangDienMay4 = new HangDienMay("dm04", "Quạt", 1_000, 400_000, 12, 65);
        // HangHoa hangDienMay5 = new HangDienMay("dm05", "Ổ cắm điện", 1_000, 100_000, 6, 50);
        

        // HangHoa hangSanhSu1 = new HangSanhSu("ss01", "Chén", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("01/03/2022"));
        // HangHoa hangSanhSu2 = new HangSanhSu("ss02", "Chén kiểu", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        // HangHoa hangSanhSu3 = new HangSanhSu("ss03", "Ly", 5_000, 10_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        // HangHoa hangSanhSu4 = new HangSanhSu("ss04", "Tô", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));
        // HangHoa hangSanhSu5 = new HangSanhSu("ss05", "Muỗng", 5_000, 5_000, "CTTNHH ...", consoleInput.ngayVN.parse("20/03/2022"));

        // List<HangHoa> list = new ArrayList<>();
        // list.add(hangThucPham1);
        // list.add(hangThucPham2);
        // list.add(hangThucPham3);
        // list.add(hangThucPham4);
        // list.add(hangThucPham5);

        // list.add(hangDienMay1);
        // list.add(hangDienMay2);
        // list.add(hangDienMay3);
        // list.add(hangDienMay4);
        // list.add(hangDienMay5);

        // list.add(hangSanhSu1);
        // list.add(hangSanhSu2);
        // list.add(hangSanhSu3);
        // list.add(hangSanhSu4);
        // list.add(hangSanhSu5);
        // List<DanhSachHangHoa> list2 = new ArrayList<>();
        
        // ghi vào 1 file cụ thể
        // ObjectOutputStream objOut;
        // try {
        //     FileOutputStream outFile = new FileOutputStream("htp.dat");
        // // chuyển đối tượng sang dạng trung gian
        //     objOut = new ObjectOutputStream(outFile);
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }
        
        // // tiến hành ghi
        // objOut.writeObject(list);
        // objOut.close();
        File file = new File("htp.dat");//File
        PrintWriter out;
        try {
            out = new PrintWriter(file);
            out.println(list);
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Sai rồi bạn ơi!");
            e.printStackTrace();
        }
    }
}
