package com.company;

class StackElement {

    private Object value;
    private StackElement next;

    public StackElement(Object value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    public Object getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }

    public void setNext(StackElement next) {
        this.next = next;
    }
}