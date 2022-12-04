package services;

public interface Service<T> {
    void displayAll();
    void add();
    void set();
    T find(String code);
}
