package com.company;

class StackElement {

    private Person value;
    private StackElement next;

    public StackElement(Person value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " ";
    }

    public Person getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }

    public void setNext(StackElement next) {
        this.next = next;
    }
}