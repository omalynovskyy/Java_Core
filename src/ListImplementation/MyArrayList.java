package ListImplementation;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private Object[] start = new Object[10];
    private E[] myArrayList = (E[]) start.clone();
    private int localSize = this.size();

    @Override
    public int size() {
        int i = 0;
        for (int j = 0; j < myArrayList.length; j++) {
            if(myArrayList != null) {
                i++;
            }
        } return i;
    }

    @Override
    public boolean isEmpty() {
        if(this.size() == 0) {
            return true;
        } return false;
    }

    @Override
    public boolean contains(Object o) {
        for(E e : myArrayList) {
            if(e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = -1;

            @Override
            public boolean hasNext() {
                try {
                    if (myArrayList[i+1] == null) {
                        return false;
                    } else return true;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            @Override
            public E next() {
                return myArrayList[++i];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return (Object[]) Arrays.copyOf(myArrayList,myArrayList.length);
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
        if (!(this.size() < myArrayList.length)) {
            myArrayList = Arrays.copyOf(myArrayList, this.size() * 2);
        }
        myArrayList[this.size() + 1] = e;
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

        for (Object o : c) {
            if(!this.contains(o)) {
                return false;
            }
        } return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int i = this.size();
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
        int s = this.size();
        if((s + 1) / myArrayList.length > 0.75) {
            Object[] newArray = new Object[myArrayList.length * 2];
            newArray = myArrayList.clone();
            myArrayList = (E[]) newArray;
        }
        for (int i = s + 1; i > index ;) {
            myArrayList[i] = myArrayList[--i];
        }
        myArrayList[index] = element;
    }



    @Override
    public E remove(int index) {
        E element = myArrayList[index];
        for (int i = index; i < this.size();) {
            myArrayList[i] = myArrayList[++i];
        }
        return element;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < myArrayList.length; i++) {
            if(myArrayList[i].equals(o)){return i;}
        } return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < myArrayList.length; i++) {
            if(myArrayList[i].equals(o)){index = i;}
        } return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        ListIterator<E> listIterator = new ListIterator<>() {
            private int i = -1;
            private boolean changeAllowed = false;

            @Override
            public boolean hasNext() {
                if (myArrayList[i + 1] == null) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                changeAllowed = true;
                return myArrayList[++i];
            }

            @Override
            public boolean hasPrevious() {
                try {
                    if (myArrayList[i - 1] == null) {
                        return false;
                    }
                    return true;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }

            @Override
            public E previous() {
                if (this.hasPrevious()) {
                    changeAllowed = true;
                    return myArrayList[--i];
                }
                throw new NoSuchElementException();
            }


            @Override

            public int nextIndex() {
                if(i >= localSize) {return localSize;}
                return i + 1;
            }

            @Override
            public int previousIndex() {
                if(i <= 0) {return -1;}
                return i - 1;
            }

            @Override
            public void remove() {
                if(changeAllowed) {
                    for (int j = i; j < localSize;) {
                        myArrayList[i] = myArrayList[++i];
                    } changeAllowed = false;
                } throw new IllegalStateException();
            }

            @Override
            public void set(E e) {
                if(changeAllowed) {
                    myArrayList[i] = e;
                    changeAllowed = false;
                } throw new IllegalStateException();
            }


            @Override
            public void add(E e) {
                if((localSize + 1) / myArrayList.length > 0.75) {
                    Object[] newArray;
                    newArray = Arrays.copyOf(myArrayList, 2 * myArrayList.length);
                    myArrayList = (E[]) newArray;
                }
                for (int j = localSize + 1; j > i;) {
                    myArrayList[i] = myArrayList[--i];
                }
                myArrayList[i] = e;
                i++;
            }
        }; return listIterator;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // это тоже то и предыдущий только стартовый интекс примет переданное знаение
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> newList = null;
        for (int i = fromIndex; i < toIndex; i++) {
            newList.add(this.get(i));
        }
        return newList;
    }
}
