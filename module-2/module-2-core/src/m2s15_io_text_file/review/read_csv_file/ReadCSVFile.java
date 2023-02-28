package m2s15_io_text_file.review.read_csv_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module-2\\src\\m2s15_io_text_file\\review\\read_csv_file\\nations.csv";

    public static List<Nation> readCSV(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Nation> list = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] nationProperties = line.split(",");
            int id = Integer.parseInt(nationProperties[0]);
            String code = nationProperties[1];
            String name = nationProperties[2];
            list.add(new Nation(id, code, name));
        }
        bufferedReader.close();
        return list;
    }

    public static void main(String[] args) {
        try {
            List<Nation> nations = readCSV(SOURCE_PATH);
            for (Nation nation : nations) {
                System.out.println(nation);
            }
        } catch (IOException e) {
            System.out.println("Exception!");
        }
    }
}
