package by.teachmeskills.mylist;

public interface MyList<E> {
    void add(E e);

    void addLast(E e);

    void addFirst(E e);

    int size();

    E remove(E e);

    E removeLast();

    E removeFirst();

    E removeByIndex(int index);

    E getElementByIndex(int index);

    E setElementByIndex(int index, E element);

    E getFirst();

    E getLast();

    boolean contains(E e);

    int getIndexElement(E e);

    void clear();
}
