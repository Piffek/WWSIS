class ListStack implements Stack {
    private StackElement stackElement;
    private int size;

    @Override
    public void push(int value) {
        stackElement = new StackElement(value, stackElement);
        size++;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            size--;
            stackElement = stackElement.getNext();
        }
        return 0;
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return stackElement == null;
    }

    @Override
    public void print() {
        StackElement currentStackElement = stackElement;
        while (currentStackElement != null) {
            System.out.println(currentStackElement.getValue());
            currentStackElement = currentStackElement.getNext();
        }
    }
}