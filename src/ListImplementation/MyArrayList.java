package ListImplementation;

import java.util.*;

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
            private int i = -1;

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
            if(myArrayList[i].equals(o)){
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
        boolean result = true;
        for (int i = 0; i < c.size(); i++) {
            E check = myArrayList[i];
            result &= c.stream().anyMatch(el -> el.equals(check));
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int i = 0;
        while (myArrayList[i] != null) {
            i++;
        }
        if (myArrayList.length <= c.size()) {
            Object[] newArray = new Object[c.size() * 2];
            E[] extendedArray = (E[]) newArray;
            extendedArray = myArrayList.clone();
            myArrayList = extendedArray;
        } else if ((c.size() + i) / myArrayList.length >= 0.75) {
            Object[] newArray = new Object[myArrayList.length * 2];
            E[] extendedArray = (E[]) newArray;
            extendedArray = myArrayList.clone();
            myArrayList = extendedArray;
        }
        for (E e : c){
            myArrayList[++i] = e;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        int i = 0;
        while (myArrayList[i] != null) {
            i++;
        }
        Object[] newArray;
        if (myArrayList.length <= c.size()) {
            newArray = new Object[c.size() * 2];
        } else if ((c.size() + i) / myArrayList.length >= 0.75) {
            newArray = new Object[myArrayList.length * 2];
        } else {newArray = new Object[myArrayList.length];}
        E[] extendedArray = (E[]) newArray;
        for (int j = 0; j < index; j++) {
            extendedArray[j] = myArrayList[j];
        }
        for (E e : c){
            extendedArray[index++] = e;
        }
        for (int j = index; j < i + c.size(); j++) {
            extendedArray[j] = myArrayList[j - c.size()];
        }
        myArrayList = extendedArray;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = false;
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            for(int i = 0; i < myArrayList.length; i++){
                if(myArrayList[i].equals(iterator.next())){
                    for (int j = i; j < myArrayList.length ; j++) {
                        if (myArrayList[j+1] == null) {
                            myArrayList[j] = null;
                        } else {
                            myArrayList[j] = myArrayList[j+1];
                        }
                    } result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = false;
        Object[] start = new Object[myArrayList.length];
        E[] newArray = (E[]) start;
        int k = 0;
        for (Object o : c) {
            for (int i = 0; i < myArrayList.length; i++) {
                if (myArrayList[i].equals(o)) {
                    newArray[k++] = myArrayList[i];
                    result = true;
                }
            }
        } myArrayList = newArray;
        return result;
    }

    @Override
    public void clear() {
        Object[] start = new Object[10];
        myArrayList = (E[]) start;

    }

    @Override
    public E get(int index) {
        return myArrayList[index];
    }

    @Override
    public E set(int index, E element) {
        return myArrayList[index] = element;
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
