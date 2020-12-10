package sk.kosisckaakademia.kkns.pexeso.trying;


import sk.kosisckaakademia.kkns.pexeso.Field;
import sk.kosisckaakademia.kkns.pexeso.FieldGenerated;

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


        /*
        //testujem generovanie cisel
        FieldGenerated fieldGenerated = new FieldGenerated();


        //vyzera ze funguju ako maju mozeme ich vymazat




        int[] arr = fieldGenerated.generateArrayRandomNumbersFrom0To55With52Numberss();
        String card = "Aa";

        System.out.println("Vygenerovany retazec");
        System.out.println("Dlzka pola je " + arr.length);
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        String[][] field = new String[8][7];

        for(int x=0; x<arr.length; x++) {
            int count=0;
            for (int i = 0; i < field.length; i++) {
                for (int j=0; j<field[0].length; j++) {
                    //count++;
                    if (count == arr[x]) {
                        field[i][j] = card;
                        card = String.valueOf((char)(card.charAt(0)+1)) + String.valueOf((char)(card.charAt(1)+1));
                    }
                    count++;
                    //if(card.equals("Zz")) card="Aa"; inak boli 3krat Aa a 3 krat Bb
                    if(card.charAt(0)>'Z') card = "Aa";
                }
            }
        }

        System.out.println("vypis pola");
        for (int i = 0; i < field.length; i++) {
            for (int j=0; j<field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }


        //objekt generovanej mapy

       // System.out.println("*******");
        //fieldGenerated.vykresliVygenerovanuMapu();


         */
        FieldGenerated fieldGenerated = new FieldGenerated();
        fieldGenerated.printGeneratedField();

    }
}
