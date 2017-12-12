package com.company;

public class SelectOperationException extends RuntimeException {
    private String operation;

    SelectOperationException(String operation) {
        super("Wrong operation selected");
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "SelectOperationException{" +
                "operation=" + operation +
                '}';
    }
}
