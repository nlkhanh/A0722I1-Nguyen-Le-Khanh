package codegym.vn.repository;

import codegym.vn.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final Map<String, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put("SV001", new Student("SV001", "Toàn", 22, "Đà Nẵng"));
        studentMap.put("SV002", new Student("SV002", "Khánh", 21, "Quảng Nam"));
        studentMap.put("SV003", new Student("SV003", "Vân", 20, "Đà Nẵng"));
        studentMap.put("SV004", new Student("SV004", "Thảo", 19, "Huế"));
        studentMap.put("SV005", new Student("SV005", "Hùng", 20, "Quảng Ngãi"));
    }

    @Override
    public void createOrUpdate(Student s) {
            studentMap.put(s.getId(), s);
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void deleteById(String id) {
        studentMap.remove(id);
    }
}
