/*
* created date: Apr 04, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;

public class DocGhiFile {
    ConsoleInput consoleInput = new ConsoleInput();  
    public void readingFile(List<HangHoa> list) {        
        try {
            File f = new File("HangHoa.txt");
            FileReader fr = new FileReader(f);
            for (HangHoa hangHoa : list) {
                System.out.println(hangHoa.toString());
            }

            fr.close();
        } catch (Exception e) {
            System.out.println("Loi doc file roi ban oi!!!!!");
            e.printStackTrace();
        }  
    }

    public void writingFile(List<HangHoa> list) {
        File file = new File("HangHoa.txt");
        PrintWriter out;
        try {
            out = new PrintWriter(file);
            for (HangHoa hangHoa : list) {
                out.println(hangHoa.toString());
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loi ghi file roi ban oi!!!!!");
            e.printStackTrace();
        }
    }
}
