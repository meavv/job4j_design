package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;

    public T deleteFirst() {
        tail = head;
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            head = head.next;
            tail.next = null;
            return tail.value;
        }
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }


    /*
     * метод должен переставить элементы в обратном порядке
     */
    public boolean revert() {
        if (head != null && head.next != null) {
            tail = head;
            Node<T> temp = head.next;
            head.next = null;
            while (temp != null) {
                Node<T> next = temp.next;
                temp.next = head;
                head = temp;
                temp = next;
            }
            return true;
        }
        return false;
    }


    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}