package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //liczby od 1 do 30
        Talia<Integer> talia = setup();

        System.out.print("Talia: ");
        talia.print();
        talia.shuffle();

        Talia<Integer> player1 = new Talia<>();
        Talia<Integer> player2 = new Talia<>();
        Talia<Integer> player3 = new Talia<>();

        //Rozdawanie kart
        for (int i=0; i<5; i++){
            try{
                player1.add(talia.dist());
                player2.add(talia.dist());
                player3.add(talia.dist());
            }catch(EndCardException e){
                System.out.print(e);
            }catch(BiggerException e){
                System.out.print(e);
            }
        }


        System.out.print("\nPlayer 1: ");
        player1.print();
        System.out.print("\nPlayer 2: ");
        player2.print();
        System.out.print("\nPlayer 3: ");
        player3.print();
        System.out.print("\nW talii po rozdaniu: ");
        talia.print();
    }

    private static Talia<Integer> setup(){
        Talia<Integer> items = new Talia<>();
        for (int i = 1; i<= 55; i++){
            items.add(i);
        }
        return items;
    }
}