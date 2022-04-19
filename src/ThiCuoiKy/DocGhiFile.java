/*
* created date: Apr 04, 2022
* author: cgm
*/
package ThiCuoiKy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
        // try {
        //     File file = new File("HangHoa.txt");

        //     if (!file.exists()) {
        //         file.createNewFile();
        //     }

        //     FileInputStream fileInputStream = new FileInputStream(file);

        //     fileInputStream.read();

        //     for (HangHoa hangHoa : list) {
        //         System.out.println(hangHoa.toString());
        //         fileInputStream.read();
        //     }
        //     fileInputStream.close();
        // } catch (Exception e) {
        //     System.out.println("Loi doc file!!!!!");
        //     e.printStackTrace();
        // }
        
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
