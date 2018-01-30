package com.company;

import java.util.*;

public class Talia<T> extends AbstractCollection<T> {

    private final List<T> array;

    Talia() {
        this.array = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }

    @Override
    public int size() {
        return array.size();
    }

    @Override
    public boolean add(T t) {
        if (size() <= 52 && !array.contains(t)) {
            return array.add(t);
        }else {
            throw new BiggerException(array.size());
        }
    }

    public void print(){
        for (T item : array)  System.out.print(item + " ");
    }

    //działa tylko dla int -> zwraca posortowaną liste
    public List<T> getOrdered(){
        List<T> internalArray = array;
        Collections.sort(internalArray, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) { //works only for integer :(
                    return ((Integer) o1).compareTo((Integer) o2);
                }
                return 0;
            }
        });
        return internalArray;
    }

    //tasowanie
    public void shuffle(){
        //metoda statyczna z klasy collections -> collections
        Collections.shuffle(array);
    }

    public T dist(){
        if (size() >= 0){
            T internalItem = array.get(0);
            array.remove(0);
            return internalItem;
        }else {
            //gdy się kończą karty do rozdawania
            throw new EndCardException(size());
        }
    }
}