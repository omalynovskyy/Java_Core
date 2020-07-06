package ListImplementation;

import java.util.*;

public class MyLinkedList<E> implements List {

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
        Iterator<E> iterator = new Iterator<E>() {
            ListElement<E> currentElement = firstElement;
            @Override
            public boolean hasNext() {
                if (currentElement.nextElement == null) {return false;}
                return true;
            }

            @Override
            public E next() {
                currentElement = currentElement.nextElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {return currentElement.element;}
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
        ListElement newElement = new ListElement((E) o);
        if (this.size() == 0) {
            firstElement = newElement;
        } else {
            lastElement.nextElement = newElement;
            newElement.previousElement = lastElement;
        }
        lastElement = newElement;
        elements.add(newElement);

        return true;
    }

    @Override
    public boolean remove(Object o) {
        ListElement e = firstElement;
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
        return false;
    }

    // вот не уверен или такой подход правильный, но ты мне скажи )); альтернативой может бить объявление новой коллекции
    @Override
    public void clear() {
        for (ListElement e : elements) {
            elements.remove(e);
        }

    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public Object get(int index) {
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
    public Object remove(int index) {
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
    public ListIterator listIterator() {
        ListIterator<E> listIterator = new ListIterator<E>() {
            ListElement<E> currentElement = firstElement;
            E currentObject = currentElement.element;
            boolean removeAllowed = false;

            @Override
            public boolean hasNext() {
                if (currentElement.nextElement == null) {return false;}
                return true;
            }

            @Override
            public E next() {
                currentElement = currentElement.nextElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {
                    removeAllowed = true;
                    return currentElement.element;
                }
            }


            @Override
            public boolean hasPrevious() {
                if (currentElement.previousElement == null) {return false;}
                return true;
            }

            @Override
            public E previous() {
                currentElement = currentElement.previousElement;
                if (currentElement == null) {
                    throw new NoSuchElementException();
                } else {
                    removeAllowed = true;
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
                if (removeAllowed) {
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
                    removeAllowed = false;
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
        return listIterator;
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
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
