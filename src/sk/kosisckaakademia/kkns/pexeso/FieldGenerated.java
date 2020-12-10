package sk.kosisckaakademia.kkns.pexeso;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FieldGenerated extends Field{

    //constructor
    public FieldGenerated(){
        fillFieldWithEmptySpaces();
        fillFieldWithAlphabet();
        fillFieldWithBlackPeters();
    }

    //a method which is used for filling an array with white spaces
    private void fillFieldWithEmptySpaces(){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = " ";
            }
        }
    }

    //ukazka testovania metoda sa zmaze sluzi iba na testing
    public String[][] fillFieldWithEmptySpacess(){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                field[i][j] = " ";
            }
        }
        return field;
    }

    //a method for generating 52numbers without repeating
    private int[] generateArrayRandomNumbersFrom0To56With52Numbers(){
        int[] arr = new int[52];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(;;){
                int num = new Random().nextInt(57);
                if(set.add(num)==true){ arr[i]=num; break; }
            }
        }

        return arr;
    }

    //ukazka testovania metoda sa zmaze sluzi iba na testing
    public int[] generateArrayRandomNumbersFrom0To56With52Numberss(){
        int[] arr = new int[52];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(;;){
                int num = new Random().nextInt(57);
                if(set.add(num)==true){ arr[i]=num; break; }
            }
        }

        return arr;
    }


    //a method for filling the field with alphabet
    private void fillFieldWithAlphabet(){
        int[] arr = generateArrayRandomNumbersFrom0To56With52Numbers();
        String card = "Aa";

        for(int x=0; x<arr.length; x++) {
            int count=0;
            for (int i = 0; i < field.length; i++) {
                for (int j=0; j<field[i].length; j++) {
                    count++;
                    if (count == arr[x]) {
                        field[i][j] = card;
                        card = String.valueOf((char)(card.charAt(0)+1)) + String.valueOf((char)(card.charAt(1)+1));
                    }
                    if(card.equals("Zz")) card="Aa";
                }
            }
        }


    }

    //a method for filling the field with black Peters &&
    private void fillFieldWithBlackPeters(){

    }

}
