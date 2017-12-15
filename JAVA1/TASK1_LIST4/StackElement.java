class StackElement {

    private int value;
    private StackElement next;

    public StackElement(int value, StackElement next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + "";
    }

    public int getValue() {
        return value;
    }

    public StackElement getNext() {
        return next;
    }

    public void setNext(StackElement next) {
        this.next = next;
    }
}