package com.company;

import java.util.Arrays;

public class ArrayStack implements Stack {

    int[] tab;
    int top;
    int maxSize;

    ArrayStack(int maxSize) {
        this.tab = new int[maxSize];
        this.top = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void push(int value) {
        this.tab[this.top] = value;
        this.top++;
    }

    @Override
    public int pop() {
        if (!this.isEmpty()) {
            int last = this.tab[this.top - 1];
            this.top --;
            return last;
        }
        return 0;
    }

    @Override
    public int size() {
        return this.top;
    }

    @Override
    public boolean isEmpty() {
        if (this.top == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i <= this.top; ++i) {
            System.out.println(this.tab[i]);
        }
    }

}