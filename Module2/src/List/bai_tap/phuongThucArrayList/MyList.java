package List.bai_tap.phuongThucArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] element;

    public Object[] getElement() {
        return element;
    }

    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size, Object[] element) {
        this.size = size;
        this.element = new Object[element.length];
        for (int i = 0; i < element.length; i++) {
            this.element[i] = element[i];
        }
    }

    public void ensureCapa(int increase) {
        int newSize = element.length + increase;
        element = Arrays.copyOf(element, newSize);
    }

    public void add(int index, E e) {
        if (size == element.length) {
            ensureCapa(2);
        }
        for (int i = size - 1; i >= index; i--) {
            element[i + 1] = element[i];
        }

        element[index] = e;
        size++;
    }


    public void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");

    }

    public E remove(int index) {
        checkIndex(index);
        E e = (E) element[index];
        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> ml = new MyList<>(size, element);
        return ml;
    }

    public boolean contains(E o) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == (o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < element.length; i++) {
            if (element[i] == (o)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        if (size == element.length) {
            ensureCapa(2);
        }
        element[size] = e;
        size++;
        return true;
    }

    public E get(int i) {
        return (E) element[i];
    }
    public void clear(){
        element = new Object[DEFAULT_CAPACITY];
        size=0;
    }
}
