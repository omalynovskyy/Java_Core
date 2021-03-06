package ListImplementation;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    Collection<ListElement<E>> elements;
    ListElement<E> firstElement;
    ListElement<E> lastElement;
    int size = this.size();

    ListElement<E> getByIndex(int index) {
        ListElement<E> e;
        if (index < this.size()/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        return e;
    }



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
        return size;
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
        ListElement<E> newElement = new ListElement<>((E) o);
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
        elements.remove(e);
        while (e != null){
            e.index--;
            e = e.nextElement;
        }

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

    @Override
    public boolean addAll(int index, Collection c) {
        ListElement<E> e;
        if (index < this.size/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        for (Object o : c) {
            ListElement<E> addedElement = new ListElement<>((E) o);
            addedElement.previousElement = e;
            addedElement.nextElement = e.nextElement;
            e.nextElement.previousElement = addedElement;
            e.nextElement = addedElement;
            addedElement.index = e.index + 1;
            e = addedElement;
        }
        while (e.nextElement != null) {
            e = e.nextElement;
            e.index = e.previousElement.index + 1;
        }
        
        return true;
    }

    // вот не уверен или такой подход правильный, но ты мне скажи )); альтернативой может бить объявление новой коллекции
    @Override
    public void clear() {
        for (ListElement<E> e : elements) {
            elements.remove(e);
        }

    }

    @Override
    public E get(int index) {
        ListElement<E> e;
        if (index < this.size/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        return e.element;
    }

    @Override
    public E set(int index, Object element) {
        ListElement<E> e;
        if (index < this.size/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        E previousElement = e.element;
        e.element = (E) element;
        return previousElement;
    }

    @Override
    public void add(int index, Object element) {
        ListElement<E> e;
        if (index < this.size/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
        }
        ListElement<E> addedElement = new ListElement<>((E) element);
        addedElement.previousElement = e;
        addedElement.nextElement = e.nextElement;
        e.nextElement.previousElement = addedElement;
        e.nextElement = addedElement;
        addedElement.index = e.index + 1;
        e = addedElement;

        while (e.nextElement != null) {
            e = e.nextElement;
            e.index = e.previousElement.index + 1;
        }

    }

    @Override
    public E remove(int index) {
        ListElement<E> e;
        if (index < this.size/2) {
            e = firstElement;
            while (e.index < index) {
                e = e.nextElement;
            }
        } else {
            e = lastElement;
            while (e.index > index) {
                e = e.previousElement;
            }
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
        ListElement<E> removedElement = e;
        while (e != null){
            e.index--;
            e = e.nextElement;
        }
        elements.remove(removedElement);
        return removedElement.element;
    }

    @Override
    public int indexOf(Object o) {
        ListElement<E> e = firstElement;
        while (!e.element.equals(o)){
            if (e.nextElement == null) {return -1;}
            e = e.nextElement;
        }
        return e.index;
    }

    @Override
    public int lastIndexOf(Object o) {
        ListElement<E> e = lastElement;
        while (!e.element.equals(o)){
            if (e.previousElement == null) {return -1;}
            e = e.previousElement;
        }
        return e.index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<>() {
            ListElement<E> currentElement = firstElement;
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

            @Override
            public int nextIndex() {
                return currentElement.index + 1;
            }

            @Override
            public int previousIndex() {
                return currentElement.index - 1;
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
                elements.add(newElement);

            }
        };
    }

    // учитывая что этот лист не содержит индексов то этот метод переопределать не нужно?
    @Override
    public ListIterator<E> listIterator(int index) {

        return new ListIterator<>() {

            //не уверен, правда, или так правильно вызвать метод из внешнего класса?
            ListElement<E> currentElement = MyLinkedList.this.getByIndex(index);

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

            @Override
            public int nextIndex() {
                return currentElement.index + 1;
            }

            @Override
            public int previousIndex() {
                return currentElement.index - 1;
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
                elements.add(newElement);

            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> sublist = new ArrayList<>(Collections.emptyList());
        ListElement<E> addedElement = this.getByIndex(fromIndex);
        sublist.add(addedElement.element);
        while (addedElement.index < toIndex) {
            addedElement = addedElement.nextElement;
            sublist.add(addedElement.element);
        }
        return sublist;
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
