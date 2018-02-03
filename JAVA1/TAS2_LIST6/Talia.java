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
    public boolean add(T t){
        if (size() <= 52 && !array.contains(t)) {
            return array.add(t);
        }
            throw new BiggerException();

    }

    public void print(){
        for (T item : array)  System.out.print(item + " ");
    }

    public List<T> getOrdered(){

        //reference to compare
        Collections.sort(array, (o1, o2) -> {
            if (o1 instanceof Integer && o2 instanceof Integer) {
                return ((Integer) o1).compareTo((Integer) o2);
            }
            return 0;
        });
        return array;
    }

    public void shuffle(){
        Collections.shuffle(array);
    }

    public T dist(){
        if (size() >= 0){
            T internalItem = array.get(0);
            array.remove(0);
            return internalItem;
        }else {
            throw new EndCardException();
        }
    }
}