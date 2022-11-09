package m2s9_dsa_list.review.arraylist_class_method;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        } else if (index == size) {
            add(element);
        } else {
            ensureCapacity(size + 1);
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }
    }

    public E remove(int index) {
        E temp = null;
        if (index > 0 && index < size) {
            temp = (E) elements[index];
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            elements[size - 1] = null;
            size--;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> temp = new MyList<>();
        temp.elements = elements;
        temp.size = size;
        return temp;
    }

    public boolean contains(E o) {
        for (Object element : elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        E[] newElements = (E[]) new Object[minCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        } else {
            return elements[index];
        }
    }

    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}