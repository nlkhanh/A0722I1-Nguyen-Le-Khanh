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

    public static List<Integer> getMonths() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
    }

    public static List<Integer> getDays() {
        List<Integer> days = new ArrayList<>();
        for (int i = 1; i <= 31; i++) {
            days.add(i);
        }
        return days;
    }


    public static List<String> getProvinces() {
        return Arrays.asList("Đà Nẵng", "Quảng Nam");
    }

    public static List<String> getDistricts() {
        return Arrays.asList("Cẩm Lệ", "Ngũ Hành Sơn", "Hội An", "Tiên Phước");
    }

    public static List<String> getWards() {
        return Arrays.asList("Khuê Trung", "Hòa Xuân", "Khuê Mỹ", "Mỹ An", "Cẩm Nam", "Cẩm Phô", "Tiên Kỳ", "Tiên Mỹ");
    }

    public static List<String> getGenders() {
        return Arrays.asList("Nam", "Nữ", "Khác");
    }

    public static List<String> getNationalities() {
        return Arrays.asList("Việt Nam", "Hàn Quốc", "Nhật Bản", "Mỹ", "Nga");
    }

    public static List<String> getMoveInfo() {
        return Arrays.asList("Tàu bay", "Tàu thuyền", "Ô tô", "Khác (ghi rõ)");
    }


}
