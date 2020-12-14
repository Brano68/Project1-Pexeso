package sk.kosisckaakademia.kkns.pexeso.trying;


import sk.kosisckaakademia.kkns.pexeso.Field;
import sk.kosisckaakademia.kkns.pexeso.FieldGenerated;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        //for testing methods

        //Ukazka testovania metodu si skopirujete vo FieldGenerated este raz ju vytvorite
        //premenujete ju aby neboli rovnake napriklad ja som dal na konci este jedno s
        //a date ju ako public aby ste sa k nej vedeli dostat
        //tu v maine si ju mozete testovat a ked je v poriadku mozete ju z tadialto
        //vymazat a taktiez aj z FieldGenerated
        //cize tento package ked budeme s konzolovou aplikaciou hotovy tak vymazeme
        //sluzi iba na skusanie metod napr tak jak som vyskusal tuto co je tu nemazal som
        //ju ale nechal ako som to myslel znazornene

        //testujem generovanie cisel
        FieldGenerated fieldGenerated = new FieldGenerated();
        fieldGenerated.paintGeneratedField();



        String[] indexes = new String[2];
        int a, b;

        System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_CYAN +"Enter card number: " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET);
        while (1>0){
            try {
                Scanner sc = new Scanner(System.in); a = sc.nextInt();
                if(a<=55 && a>=0){ indexes[0]=String.valueOf(a); break; }
                else { System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RED +"Card doesn't exist. Try again.. " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET); continue; }
            }catch(InputMismatchException nfe) { System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RED +"Card doesn't exist. Try again.. " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET); continue; }
        }

        System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_CYAN +"Pick another card to match with the previous: " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET);
        while (1>0){
            try {
                Scanner sc = new Scanner(System.in); b = sc.nextInt();
                if(b<=55 && b>=0 && b!=a){ indexes[1]=String.valueOf(b); break; }
                else if(b==a){ System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RED +"You picked the same card. Pick another.. " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET); continue; }
                else { System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RED +"Card doesn't exist. Try again.. " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET); continue; }
            }catch(InputMismatchException nfe) { System.out.print(sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RED +"Card doesn't exist. Try again.. " + sk.kosisckaakademia.kkns.pexeso.Main.ANSI_RESET); continue; }
        }


        System.out.println(indexes[0] +" " +indexes[1]);





    }
}
