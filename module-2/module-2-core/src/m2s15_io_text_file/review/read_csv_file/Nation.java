package m2s15_io_text_file.review.read_csv_file;

public class Nation {
    private int id;
    private String code;
    private String name;

    public Nation() {
    }

    public Nation(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
