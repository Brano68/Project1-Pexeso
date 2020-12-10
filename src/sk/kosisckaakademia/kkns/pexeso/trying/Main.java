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

        //testujem generovanie cisel
        FieldGenerated fieldGenerated = new FieldGenerated();
        int[] array = fieldGenerated.generateArrayRandomNumbersFrom0To56With52Numberss();

        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        //po uspesnom teste ju z tadialto zmazem a aj v triede kde som vztvoril duplicitu

        System.out.println();
        //testujem naplnenie s medzerami
        String[][] array2 = fieldGenerated.fillFieldWithEmptySpacess();
        //vykreslim si pole ci su v nom isto medzery
        for(int i = 0; i < array2.length; i++){
            for(int j = 0; j < array2[0].length; j++){
                System.out.print(array2[i][j] + "_");
            }
            System.out.println();
        }

        //vyzera ze funguju ako maju mozeme ich vymazat




            int[] arr = array;
            String card = "Aa";

            String[][] field = fieldGenerated.getField();

            for(int x=0; x<arr.length; x++) {
                int count=0;
                for (int i = 0; i <field.length; i++) {
                    for (int j=0; j<field[0].length; j++) {
                        if (count == arr[x]) {
                            field[i][j] = card;
                            card = String.valueOf((char)(card.charAt(0)+1)) + String.valueOf((char)(card.charAt(1)+1));
                            if(card.equals("[{")) card="Aa";
                        }
                        count++;
                    }
                }
            }




            for(int i=0; i< field.length; i++){
                for(int j=0; j<field[0].length; j++){
                    System.out.print(field[i][j] +" ");
                }
            }







    }
}
