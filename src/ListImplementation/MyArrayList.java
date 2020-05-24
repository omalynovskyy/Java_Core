package ListImplementation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {

    private Object[] start = new Object[10];
    private E[] myArrayList = (E[]) start.clone();
    private int size;

    @Override
    public int size() {
        int i = 0;
        while (myArrayList[i] != null) {
            i++;
        } return i;
    }

    @Override
    public boolean isEmpty() {
        if(myArrayList[0] == null) {
            return true;
        } else {return false;}
    }

    @Override
    public boolean contains(Object o) {
        for(E e : myArrayList) {
            if(e.equals(o)) {return true;}
        } return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                if (myArrayList[i+1] == null) {
                return false;
                } else return true;
            }

            @Override
            public E next() {
                return myArrayList[++i];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] objects = myArrayList.clone();
        return objects;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            a = (T[]) myArrayList.clone();
        } catch (ClassCastException e) {
            throw new ArrayStoreException();
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        int i = 0;
        while (myArrayList[i] != null) {
            i++;
        };
        if ((((i + 1) / myArrayList.length) > 0.75)) {
            Object[] newArray = new Object[myArrayList.length * 2];
            E[] extendedArray = (E[]) newArray;
            extendedArray = myArrayList.clone();
            myArrayList = extendedArray;

//            может в этом месте есть смысл запустить GarbageCollector ?
        }
        myArrayList[i] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < myArrayList.length; i++){
            if(myArrayList[i] == o){
                for (int j = i; j < myArrayList.length ; j++) {
                    if (myArrayList[j+1] == null) {
                        myArrayList[j] = null;
                        return true;
                    } else {
                        myArrayList[j] = myArrayList[j+1];
                    }
                }
            }
        } return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
