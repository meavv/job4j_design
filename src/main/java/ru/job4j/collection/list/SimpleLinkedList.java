package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {
    private int modCount;
    private int size;
    private Node<E> last;
    private Node<E> first;

    public SimpleLinkedList() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null, null, last);
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public void setItem(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> temp = last;
        temp.setItem(value);
        last = new Node<E>(null, temp, null);
        temp.setNext(last);
        size++;
        modCount++;
    }


    @Override
    public E get(int index) {
        index = Objects.checkIndex(index, size);
        Node<E> rsl = first.getNext();
        for (int i = 0; i < index; i++) {
            rsl = rsl.getNext();
        }
        return rsl.getItem();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int it = 0;
            final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return it < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                var rsl = first.getNext();
                if (0 >= it) {
                    it++;
                    return rsl.getItem();
                } else {
                    it++;
                    rsl = rsl.getNext();
                    return rsl.getItem();
                }
            }
        };
    }
}