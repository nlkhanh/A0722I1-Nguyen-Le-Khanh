package service;

import model.GeneralRecord;
import model.MedicalRecord;
import model.VipRecord;
import util.NotFoundMedicalRecordException;
import util.ReadAndWriteCSV;
import util.Validate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordsServiceImpl implements MedicalRecordsService {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() throws Exception {
        MedicalRecord medicalRecord = null;
        int serial = getSerial();
        String medicalCode = getMedicalCode();
        String patientCode = getPatientCode();
        String patientName = getName();
        LocalDate inDate;
        LocalDate outDate;
        while (true) {
            inDate = getInDate();
            outDate = getOutDate();
            if (Validate.isInOutDateRight(inDate, outDate)) {
                break;
            } else {
                System.out.println("Ngày nhập viện lớn hơn ngày ra viện!");
            }
        }
        String reason = getReason();
        while (true) {
            try {
                System.out.println("Chọn loại bệnh án: ");
                System.out.println("1. Loại thường");
                System.out.println("2. Loại vip");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                switch (choice) {
                    case 1:
                        int fee = getFee();
                        medicalRecord = new GeneralRecord(serial, medicalCode, patientCode, patientName, inDate, outDate, reason, fee);
                        break;
                    case 2:
                        String type = getType();
                        LocalDate duration = getDuration();
                        medicalRecord = new VipRecord(serial, medicalCode, patientCode, patientName, inDate, outDate, reason, type, duration);
                        break;
                    default:
                        System.out.println("Phải chọn từ 1 hoặc 2!");
                }
                if (medicalRecord != null) {
                    List<MedicalRecord> medicalRecords = ReadAndWriteCSV.read();
                    medicalRecords.add(medicalRecord);
                    ReadAndWriteCSV.write(medicalRecords);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Phải chọn từ 1 đến 3!");
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException e) {
                throw new IOException();
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }

    @Override
    public void delete() throws Exception {
        while (true) {
            try {
                System.out.println("Nhập mã bệnh án bạn muốn xóa: ");
                String code = SCANNER.nextLine();
                if (Validate.isMedicalCodeRight(code)) {
                    List<MedicalRecord> medicalRecords = ReadAndWriteCSV.read();
                    if (medicalRecords.size() == 0) {
                        System.out.println("Không có bệnh án nào được lưu");
                        return;
                    } else {
                        for (MedicalRecord medicalRecord : medicalRecords) {
                            if (medicalRecord.getMedicalCode().equals(code)) {
                                while (true) {
                                    try {
                                        System.out.println("Bạn muốn xóa bệnh án");
                                        System.out.println("1. Yes");
                                        System.out.println("2. No");
                                        int choice = Integer.parseInt(SCANNER.nextLine());
                                        if (choice == 1) {
                                            medicalRecords.remove(medicalRecord);
                                            if (medicalRecords.size() == 0) {
                                                System.out.println("Không có bệnh án nào được lưu!");
                                            } else {
                                                for (int i = 0; i < medicalRecords.size(); i++) {
                                                    medicalRecords.get(i).setSerial(i + 1);
                                                    System.out.println(medicalRecords.get(i));
                                                }
                                                ReadAndWriteCSV.write(medicalRecords);
                                            }
                                            return;
                                        } else if (choice == 2) {
                                            return;
                                        } else {
                                            System.out.println("Bạn phải nhập 1 hoặc 2.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Bạn phải nhập 1 hoặc 2.");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    throw new NotFoundMedicalRecordException();
                }
            } catch (NotFoundMedicalRecordException e) {
                e.showMessage();
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            } catch (IOException e) {
                throw new IOException();
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }

    @Override
    public void displayAll() throws Exception {
        try {
            List<MedicalRecord> medicalRecords = ReadAndWriteCSV.read();
            if (medicalRecords.size() == 0) {
                System.out.println("Không có bệnh án nào được lưu!");
            } else {
                for (MedicalRecord medicalRecord : medicalRecords) {
                    System.out.println(medicalRecord);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private int getSerial() throws Exception {
        try {
            List<MedicalRecord> medicalRecords = ReadAndWriteCSV.read();
            if (medicalRecords.size() == 0) {
                return 1;
            } else {
                return medicalRecords.size() + 1;
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new IOException();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    private String getMedicalCode() {
        while (true) {
            System.out.println("Nhập mã bệnh án (BA-XXX, X là các chữ số): ");
            String code = SCANNER.nextLine();
            if (Validate.isMedicalCodeRight(code)) {
                return code;
            }
            System.out.println("Mã bệnh án phải có định dạng BA-XXX, X là các chữ số!");
        }
    }

    private String getPatientCode() {
        while (true) {
            System.out.println("Nhập mã bệnh nhân (BN-XXX, X là các chữ số): ");
            String code = SCANNER.nextLine();
            if (Validate.isPatientCodeRight(code)) {
                return code;
            }
            System.out.println("Mã bệnh nhân phải có định dạng BN-XXX, X là các chữ số!");
        }
    }

    private String getName() {
        System.out.println("Nhập tên bệnh nhân: ");
        return SCANNER.nextLine();
    }

    private LocalDate getInDate() {
        while (true) {
          try {
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
              System.out.println("Nhập ngày nhập viện (dd/mm/yyyy): ");
              String dateStr = SCANNER.nextLine();
              if (Validate.isDateRight(dateStr)) {
                  return LocalDate.parse(dateStr, formatter);
              }
              System.out.println("Bạn nhập sai ngày");
          } catch (Exception e) {
              System.out.println("Lỗi parse date");
          }
        }
    }

    private LocalDate getOutDate() {
        while (true) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Nhập ngày xuất viện (dd/mm/yyyy): ");
                String dateStr = SCANNER.nextLine();
                if (Validate.isDateRight(dateStr)) {
                    return LocalDate.parse(dateStr, formatter);
                }
                System.out.println("Bạn nhập sai ngày");
            } catch (Exception e) {
                System.out.println("Lỗi parse date");
            }
        }
    }

    private String getReason() {
        System.out.println("Nhập lý do nhập viện: ");
        return SCANNER.nextLine();
    }

    private int getFee() {
        while (true) {
            try {
                System.out.println("Nhập phí nằm viện: ");
                int fee = Integer.parseInt(SCANNER.nextLine());
                if (fee >  0) {
                    return fee;
                }
                System.out.println("Phí phải là số nguyên dương");
            } catch (NumberFormatException e) {
                System.out.println("Phí phải là số nguyên dương");
            }
        }
    }

    private String getType() {
        while (true) {
            try {
                System.out.println("Nhập loại vip: ");
                System.out.println("1. VIP I");
                System.out.println("2. VIP II");
                System.out.println("3. VIP III");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                switch (choice) {
                    case 1:
                        return "VIP I";
                    case 2:
                        return "VIP II";
                    case 3:
                        return "VIP III";
                    default:
                        System.out.println("Bạn phải chọn 1,2 hoặc 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải chọn 1,2 hoặc 3!");
            }
        }
    }

    private LocalDate getDuration() {
        while (true) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Nhập kỳ hạn vip (dd/mm/yyyy): ");
                String dateStr = SCANNER.nextLine();
                if (Validate.isDateRight(dateStr)) {
                    return LocalDate.parse(dateStr, formatter);
                }
                System.out.println("Bạn nhập sai ngày");
            } catch (Exception e) {
                System.out.println("Lỗi parse date");
            }
        }
    }
}
