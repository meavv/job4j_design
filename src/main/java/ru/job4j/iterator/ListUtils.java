package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    /*
     * вставляет до индекса
     */
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    /*
     * вставляет после индекса
     */
    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator(list.size());
        while (i.hasPrevious()) {
            if (i.previousIndex() == index) {
                i.add(value);
                break;
            }
            i.previous();
        }
    }

    /*
     * удаляет все элементы, которые удовлетворяют предикату
     */
    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.remove();
            }
        }
    }

    /*
     * заменяет все элементы, которые удовлетворяют предикату
     */
    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (filter.test(i.next())) {
                i.set(value);
            }
        }
    }

    /*
     *  удаляет из списка те элементы, которые есть в elements
     */
    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> listIterator = list.listIterator();
        ListIterator<T> elementsIterator = elements.listIterator();
        while (listIterator.hasNext()) {
            T object = listIterator.next();
            while (elementsIterator.hasNext()) {
                if (object.equals(elementsIterator.next())) {
                    listIterator.remove();
                    break;
                }
            }
        }

    }
}
