package repository;

public interface Repository<T, C> {
    void add(T e);

    void set(T e);

    T find(String code);

    void displayAll();

    C read();

    void write(C list);
}
