package codegym.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{

    private static final Map<String, String> DICT_MAP;

    static {
        DICT_MAP = new HashMap<>();
        DICT_MAP.put("weather", "thời tiết");
        DICT_MAP.put("hello", "xin chào");
        DICT_MAP.put("pneumonia", "viêm phổi");
        DICT_MAP.put("meningitis", "viêm màng não");
    }
    @Override
    public String findWord(String word) {
        if (DICT_MAP.containsKey(word)) {
            return DICT_MAP.get(word);
        }
        return "Không có từ bạn tìm!";
    }
}
