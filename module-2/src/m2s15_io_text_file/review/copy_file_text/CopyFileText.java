package m2s15_io_text_file.review.copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module-2\\src\\m2s15_io_text_file\\review\\copy_file_text\\source.csv";
    private static final String TARGET_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module-2\\src\\m2s15_io_text_file\\review\\copy_file_text\\target.csv";

    public static List<String> readCSV(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> list = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add(line);
        }
        bufferedReader.close();
        return list;
    }

    public static void writeCSV(String filePath, List<String> list) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        if (readCSV(filePath).size() == 0) {
            for (String item : list) {
                bufferedWriter.write(item + "\n");
            }
            bufferedWriter.close();
        } else {
            System.out.println("Target file is exist!");
        }
    }

    public static void main(String[] args) {
        List<String> list;
        try {
            list = readCSV(SOURCE_PATH);
            writeCSV(TARGET_PATH, list);
        } catch (IOException e) {
            System.out.println("Exception!");
        }
    }
}
