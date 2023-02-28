package util;

public class NotFoundMedicalRecordException extends Exception{
    public void showMessage() {
        System.out.println("NotFoundMedicalRecordException: Bệnh án không tồn tại!");
    }
}
