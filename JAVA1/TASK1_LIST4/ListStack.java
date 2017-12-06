package com.company;

import java.util.ArrayList;
import java.util.List;

class ListStack implements Stack {
    List<StackElement> listStack;
    int counter;

    public ListStack() {
        listStack = new ArrayList<>();
    }

    @Override
    public void push(int value) {
        if (listStack.size() > 0) {
            listStack.add(0, new StackElement(value, listStack.get(0)));
        } else {
            listStack.add(0, new StackElement(value, null));
        }
    }

    @Override
    public int pop() {
        if (!this.isEmpty()) {
            this.listStack.remove(0).getValue();
            System.out.println(" ");
        }
        return 0;
    }

    @Override
    public int size() {
        return this.listStack.size();
    }

    @Override
    public boolean isEmpty() {
        return this.listStack.size() == 0;
    }

    @Override
    public void print() {
        for (StackElement item : listStack) {
            System.out.println(item);
        }

    }

}