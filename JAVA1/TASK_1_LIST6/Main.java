package com.company;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Person person = new Person("Patryk", "Piwko");
        Person personTwo = new Person("CosTwoName", "CosTwoLastName");
        Person personThree = new Person("CosThreeName", "CosThreeLastName");


        ListStack lists = new ListStack();
        lists.push(person);
        lists.push(personTwo);
        lists.push(personThree);

        lists.print();
    }
}