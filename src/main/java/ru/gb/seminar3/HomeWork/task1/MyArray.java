package ru.gb.seminar3.HomeWork.task1;
/*
Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.
 */

import java.util.Arrays;
import java.util.Iterator;

public class MyArray<T> {
    private Object[] objects;
    private ArrayIterator arrayIterator;
    int size;

    MyArray() {
        size = 0;
        objects = new Object[10];
        arrayIterator = new ArrayIterator<>(objects);
    }

    public void add(T t) {
        if (size >= objects.length) {
            Object[] objects1 = new Object[objects.length * 2];
            System.arraycopy(objects, 0, objects1, 0, objects.length);
            objects = objects1;
        }
        objects[size++] = t;
        arrayIterator = new ArrayIterator<>(objects);
    }

    public void remove(T t) {
        Integer index = find(t);
        if (index != null) {
            Object[] objects1 = new Object[objects.length - 1];
            for (int i = 0; i < index; i++) {
                objects1[i] = objects[i];
            }
            for (int i = index; i < objects.length - 1; i++) {
                objects1[i] = objects[i + 1];
            }
            objects = objects1;
        }
        arrayIterator = new ArrayIterator<>(objects);
    }

    public Integer find(T t) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(t)) return i;
        }
        return null;
    }

    public String print() {
        return Arrays.toString(objects);
    }

    public ArrayIterator<T> getArrayIterator() {
        return arrayIterator;
    }

    public class ArrayIterator <T> implements Iterator<T>, Iterable<T> {
        T[] objects;
        private Integer index = 0;

        ArrayIterator(T[] objects) {
            this.objects = objects;
        }

        @Override
        public boolean hasNext() {
            return (objects.length > index);
        }

        @Override
        public T next() {
            if (hasNext()) {
                return objects[index++];
            }
            return null;
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }
    }
}
