package by.teachmeskills.mylist;

import lombok.Getter;
import lombok.Setter;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    @Override
    public E getFirst() {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        return firstNode.item;
    }

    @Override
    public E getLast() {
        if (lastNode == null) {
            throw new NoSuchElementException();
        }
        return lastNode.item;
    }

    @Override
    public boolean contains(E e) {
        return getIndexElement(e) >= 0;
    }

    @Override
    public int getIndexElement(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> i = firstNode; i != null; i = getNextElement(i)) {
                if (i.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> i = firstNode; i != null; i = getNextElement(i)) {
                if (e.equals(i.item)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
    public void clear() {
        for (Node<E> i = firstNode; i != null; ) {
            Node<E> next = i.next;
            i.next = null;
            i.prev = null;
            i.item = null;
            i = next;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E remove(E e) {
        if (e == null) {
            for (Node<E> i = firstNode; i != null; i = getNextElement(i)) {
                if (i.item == null) {
                    return changeLink(i);
                }
            }
        } else {
            for (Node<E> i = firstNode; i != null; i = getNextElement(i)) {
                if (e.equals(i.item)) {
                    return changeLink(i);
                }
            }
        }
        return null;
    }

    private Node<E> node(int index) {
        Node<E> e;
        if (index < (size >> 1)) {
            e = firstNode;
            for (int i = 0; i < index; i++)
                e = e.next;
        } else {
            e = lastNode;
            for (int i = size - 1; i > index; i--)
                e = e.prev;
        }
        return e;
    }


    private E changeLink(Node<E> e) {
        E element = e.item;
        Node<E> next = e.next;
        Node<E> prev = e.prev;
        if (prev == null) {
            firstNode = next;
        } else {
            prev.next = next;
            e.prev = null;
        }
        if (next == null) {
            lastNode = prev;
        } else {
            next.prev = prev;
            e.next = null;
        }

        e.item = null;
        size--;
        return element;
    }

    @Override
    public void addLast(E e) {
        Node<E> last = lastNode;
        Node<E> newNode = new Node<>(last, e, null);
        lastNode = newNode;
        if (last == null) {
            firstNode = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> first = firstNode;
        Node<E> newNode = new Node<>(null, e, first);
        firstNode = newNode;
        if (first == null) {
            lastNode = newNode;
        } else {
            first.prev = newNode;
        }
        size++;
    }

    @Override
    public E getElementByIndex(int index) {
        Node<E> element = firstNode;
        for (int i = 0; i < index; i++) {
            element = getNextElement(element);
        }
        return element.getItem();
    }

    @Override
    public E setElementByIndex(int index, E element) {
        if (isElementIndex(index)) {
            Node<E> e = node(index);
            E oldItem = e.item;
            e.item = element;
            return oldItem;
        }
        return null;
    }

    private Node<E> getNextElement(Node<E> e) {
        return e.getNext();
    }

    private boolean isElementIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public E removeFirst() {
        Node<E> first = firstNode;
        E firstItem = firstNode.item;
        firstNode = null;
        firstNode = first.next;
        if (firstNode == null) {
            lastNode = null;
        }
        first = null;
        size--;
        return firstItem;
    }

    @Override
    public E removeByIndex(int index) {
        return remove(getElementByIndex(index));
    }


    public E removeLast() {
        Node<E> last = lastNode;
        E lastItem = lastNode.item;
        lastNode = null;
        lastNode = last.prev;
        if (lastNode == null) {
            firstNode = null;
        }
        last = null;
        size--;
        return lastItem;
    }

    public void add(E e) {
        addLast(e);
    }

    @Getter
    @Setter
    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
