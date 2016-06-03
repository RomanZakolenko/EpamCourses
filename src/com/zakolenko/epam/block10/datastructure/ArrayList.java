package com.zakolenko.epam.block10.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private Object[] elements = new Object[15];
    private int size;

    @Override
    public boolean add(T obj) {
        if (size == elements.length) {
            increaseElements();
        }
        elements[size++] = obj;
        return true;
    }

    @Override
    public void add(int index, T obj) {
        if (size == elements.length) {
            increaseElements();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = obj;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iter = c.iterator();
        while (iter.hasNext()) {
            this.add(iter.next());
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        Iterator<? extends T> iter = c.iterator();
        while (iter.hasNext()) {
            this.add(index++, iter.next());
        }
        return true;
    }

    @Override
    public void clear() {
        elements = new Object[15];
        size = 0;
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iter = c.iterator();
        boolean res = true;
        while (iter.hasNext() && res) {
            if (!this.contains(iter.next())) {
                res = false;
            }
        }
        return res;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }

    @Override
    public int indexOf(Object obj) {
        int res = -1;
        for (int i = 0; i < size && res == -1; i++) {
            if (elements[i].equals(obj)) {
                res = i;
            }
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public int lastIndexOf(Object obj) {
        int res = -1;
        for (int i = size - 1; i >= 0 && res == -1; i--) {
            if (elements[i].equals(obj)) {
                res = i;
            }
        }
        return res;
    }

    private class MyListIterator<T> implements ListIterator<T> {

        int index = -1;
        boolean next = false;
        boolean previous = false;

        MyListIterator() {
        }

        MyListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            next = true;
            return (T) elements[++index];
        }

        @Override
        public void remove() throws IllegalStateException {
            if (next || previous) {
                ArrayList.this.remove(index--);
                next = false;
                previous = false;
            } else {
                throw new IllegalStateException();
            }
        }

        @Override
        public void add(T obj) {
            if (size == elements.length) {
                increaseElements();
            }
            System.arraycopy(elements, index + 1, elements, index + 2, size - index - 1);
            elements[index + 1] = obj;
            size++;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public int nextIndex() {
            if (hasNext()) {
                return index + 1;
            } else {
                return size;
            }
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            previous = true;
            return (T) elements[--index];
        }

        @Override
        public int previousIndex() {
            if (hasPrevious()) {
                return index - 1;
            } else {
                return -1;
            }
        }

        @Override
        public void set(T obj) throws IllegalStateException {
            if (next || previous) {
                elements[index] = obj;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        } else {
            size--;
            System.arraycopy(elements, index + 1, elements, index, size - index + 1);
            return true;
        }
    }

    @Override
    public T remove(int index) {
        T res = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()) {
            res = this.remove(iter.next());
        }
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        ListIterator<T> iter = this.listIterator();
        boolean res = false;
        T temp;
        while (iter.hasNext()) {
            temp = iter.next();
            if (!c.contains(temp)) {
                res = this.remove(temp);
            }
        }
        return res;
    }

    @Override
    public T set(int index, T obj) {
        T res = (T) elements[index];
        elements[index] = obj;
        return res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> subList(int arg0, int arg1) {
        ArrayList<T> res = new ArrayList<T>();
        res.size = arg1 - arg0;
        Object[] subArray = new Object[res.size];
        System.arraycopy(this.elements, arg0, subArray, 0, res.size);
        res.elements = subArray;
        return res;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        System.arraycopy(elements, 0, res, 0, size);
        return res;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    private void increaseElements() {
        Object[] newElements = new Object[(int) Math.round(elements.length * 1.25)];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
