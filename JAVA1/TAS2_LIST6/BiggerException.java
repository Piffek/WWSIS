package com.company;

public class BiggerException extends RuntimeException {

    BiggerException(int operation) {
        super("too much card");
    }
}