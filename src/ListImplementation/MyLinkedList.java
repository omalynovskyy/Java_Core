package ListImplementation;

import java.util.*;

public class MyLinkedList implements List {

    Collection<ListElement> elements;
    ListElement firstElement;
    ListElement lastElement;

    int size;

    private class ListElement<E> {
        E element;

        ListElement previousElement;
        ListElement nextElement;

        public ListElement(E element) {
            this.element = element;
        }
    }

    @Override
    public int size() {
        size = 0;
        if (firstElement == null) {
            return size;
        }
        ListElement e = firstElement;
        do {
            size++;
            e = e.nextElement;
        } while (e != null);
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (this.size() == 0) {return false;}
        ListElement e = firstElement;
        while (!e.element.equals(o)){
            if (e.nextElement == null) {return false;}
            e = e.nextElement;
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        Iterator<ListElement> iterator = new Iterator<>() {
            ListElement currentElement = firstElement;
            @Override
            public boolean hasNext() {
                if (currentElement.nextElement == null) {return false;}
                return true;
            }

            @Override
            public ListElement next() {
                currentElement = currentElement.nextElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {return currentElement;}
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int i = 0;
        ListElement e = firstElement;
        while (e != null) {
            array[i++] = e.element;
            e = e.nextElement;
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
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
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
