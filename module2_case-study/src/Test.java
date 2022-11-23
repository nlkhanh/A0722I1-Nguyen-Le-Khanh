import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse("08/10/1997", formatter);
        LocalDate currentDate = LocalDate.parse("07/10/2022", formatter);
        System.out.println(Period.between(birthDate, currentDate).getYears());
    }
}
