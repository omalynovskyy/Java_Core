package ListImplementation;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    Collection<ListElement<E>> elements;
    ListElement<E> firstElement;
    ListElement<E> lastElement;
    int size = 0;



    private static class ListElement<E> {
        E element;

        ListElement<E> previousElement;
        ListElement<E> nextElement;
        int index = 0;

        public ListElement(E element) {
            this.element = element;
        }
    }

    @Override
    public int size() {
//        int size = 0;
//        if (firstElement == null) {
//            return size;
//        }
//        ListElement<E> e = firstElement;
//        do {
//            size++;
//            e = e.nextElement;
//        } while (e != null);
        return lastElement.index + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (this.size() == 0) {return false;}
        ListElement<E> e = firstElement;
        while (!e.element.equals(o)){
            if (e.nextElement == null) {return false;}
            e = e.nextElement;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            ListElement<E> currentElement = firstElement;

            @Override
            public boolean hasNext() {
                return currentElement.nextElement != null;
            }

            @Override
            public E next() {
                currentElement = currentElement.nextElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {
                    return currentElement.element;
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        int i = 0;
        ListElement<E> e = firstElement;
        while (e != null) {
            array[i++] = e.element;
            e = e.nextElement;
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        ListElement<E> newElement = new ListElement<E>((E) o);
        if (this.size() == 0) {
            firstElement = newElement;
        } else {
            lastElement.nextElement = newElement;
            newElement.previousElement = lastElement;
            newElement.index = newElement.previousElement.index + 1;
        }
        lastElement = newElement;
        elements.add(newElement);


        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListElement<E> e = firstElement;
        while (!e.element.equals(o)){
            if (e.nextElement == null) {return false;}
            e = e.nextElement;
        }
        if (e == firstElement) {
            firstElement = e.nextElement;
            e.nextElement.previousElement = null;
        } else if (e == lastElement) {
            lastElement = e.previousElement;
            e.previousElement.nextElement = null;
        } else {
        e.previousElement.nextElement = e.nextElement;
        e.nextElement.previousElement = e.previousElement;
        }
        while (e != null){
            e.index--;
            e = e.nextElement;
        }
        // не уверен или так можно: "e.nextElement.previousElement", тогда альтернативой наверное через промежуточные переменные?
        elements.remove(e);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean result = false;
        for (Object o : c) {
            result = this.add(o);
        }
        return result;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public boolean addAll(int index, Collection c) {
        ListElement<E> e = firstElement;
        if (index < this.size/2) {
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        
        return false;
    }

    // вот не уверен или такой подход правильный, но ты мне скажи )); альтернативой может бить объявление новой коллекции
    @Override
    public void clear() {
        for (ListElement<E> e : elements) {
            elements.remove(e);
        }

    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public E get(int index) {
        return null;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public Object set(int index, Object element) {
        return null;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public void add(int index, Object element) {

    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public E remove(int index) {
        return null;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<>() {
            ListElement<E> currentElement = firstElement;
            E currentObject = currentElement.element;
            boolean modifyAllowed = false;

            @Override
            public boolean hasNext() {
                return currentElement.nextElement != null;
            }

            @Override
            public E next() {
                currentElement = currentElement.nextElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {
                    modifyAllowed = true;
                    return currentElement.element;
                }
            }

            @Override
            public boolean hasPrevious() {
                return currentElement.previousElement != null;
            }

            @Override
            public E previous() {
                currentElement = currentElement.previousElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {
                    modifyAllowed = true;
                    return currentElement.element;
                }
            }

            // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
            @Override
            public int nextIndex() {
                return 0;
            }

            // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {
                if (modifyAllowed) {
                    if (currentElement == firstElement) {
                        firstElement = currentElement.nextElement;
                        currentElement.nextElement.previousElement = null;
                        currentElement = firstElement;
                    } else if (currentElement == lastElement) {
                        lastElement = currentElement.previousElement;
                        currentElement.previousElement.nextElement = null;
                        currentElement = lastElement;
                    } else {
                        currentElement.previousElement.nextElement = currentElement.nextElement;
                        currentElement.nextElement.previousElement = currentElement.previousElement;
                        currentElement = currentElement.nextElement;
                    }
                    elements.remove(currentElement);
                    modifyAllowed = false;
                }

            }

            @Override
            public void set(E e) {
                currentElement.element = e;
            }

            @Override
            public void add(E e) {
                ListElement<E> newElement = new ListElement<>(e);
                currentElement.previousElement.nextElement = newElement;
                newElement.previousElement = currentElement.previousElement;
                newElement.nextElement = currentElement;
                currentElement.previousElement = newElement;

            }
        };
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean result = false;
        for (Object o : c) {
            if (!this.contains(o)) {
                this.remove(o);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean result = false;
        for (Object o : c) {
            if (this.contains(o)) {
                this.remove(o);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < this.size()) {
            a = new Object[this.size()];
        }
        int i = 0;
        Iterator<E> itr = this.iterator();
        do {
            a[i++] = itr.next();
        } while (itr.hasNext());
        for (int j = this.size(); j < a.length; j++) {
            a[i] = null;
        }
        return a;
    }
}
