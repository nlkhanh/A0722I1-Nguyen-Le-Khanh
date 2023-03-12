package codegym.com;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common {
    public static List<Integer> getYears() {
        List<Integer> years = new ArrayList<>();
        int cYear = Year.now().getValue();
        for (int i = cYear; i >= (cYear - 100); i--) {
            years.add(i);
        }
        return years;
    }

    public static List<String> getGenders() {
        return Arrays.asList("Nam", "Nữ", "Khác");
    }

    public static List<String> getNationalities() {
        return Arrays.asList("Việt Nam", "Hàn Quốc", "Nhật Bản", "Mỹ", "Nga");
    }

    public static List<String> getMoveInfo() {
        return Arrays.asList("Tàu bay", "Tàu thuyền", "Ô ô", "Khác (ghi rõ)");
    }



}
