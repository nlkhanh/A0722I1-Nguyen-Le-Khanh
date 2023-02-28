package util;

import model.GeneralRecord;
import model.MedicalRecord;
import model.VipRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCSV {
    private static final String FILE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_examination_2\\src\\data\\medical_records.csv";

    public static List<MedicalRecord> read() throws Exception {
        try (FileReader fileReader = new FileReader(FILE_PATH); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            List<MedicalRecord> medicalRecords = new ArrayList<>();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArr = line.split(",");
                if (lineArr.length == 8) {
                    medicalRecords.add(new GeneralRecord(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3], LocalDate.parse(lineArr[4], formatter),
                            LocalDate.parse(lineArr[5], formatter), lineArr[6], Integer.parseInt(lineArr[7])));
                } else {
                    medicalRecords.add(new VipRecord(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], lineArr[3], LocalDate.parse(lineArr[4], formatter),
                            LocalDate.parse(lineArr[5], formatter), lineArr[6], lineArr[7], LocalDate.parse(lineArr[8], formatter)));
                }
            }
            return medicalRecords;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (NumberFormatException e) {
            System.out.println("Lỗi đọc file");
            throw new NumberFormatException();
        } catch (IOException e) {
            throw new IOException();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public static void write(List<MedicalRecord> medicalRecords) throws Exception {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
            if (medicalRecords.size() > 0) {
                for (MedicalRecord medicalRecord : medicalRecords) {
                    bufferedWriter.write(medicalRecord.getInfo() + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (NumberFormatException e) {
            System.out.println("Lỗi ghi file");
            throw new NumberFormatException();
        } catch (IOException e) {
            throw new IOException();
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
