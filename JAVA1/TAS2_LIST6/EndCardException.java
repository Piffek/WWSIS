package com.company;

public class EndCardException extends RuntimeException {

    EndCardException(int operation) {
        super("no more card");
    }
}