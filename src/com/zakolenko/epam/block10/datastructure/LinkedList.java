package com.zakolenko.epam.block10.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements List<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private int modCount;

    public LinkedList() {
    }

    public LinkedList(Collection<? extends T> c) {
        addAll(c);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private void setFirst(T t) {
        Node<T> f = first;
        first = new Node<>(null, t, f);
        if (f != null) {
            f.previous = first;
        } else {
            last = first;
        }
        size++;
        modCount++;
    }

    private void setLast(T t) {
        if (last == null) {

        } else {
        }
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;

        Node(Node<T> previous, T value, Node<T> next) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }
}
