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

    //a method for filling the field with alphabet
    private void fillFieldWithAlphabet(){
        int[] arr = generateArrayRandomNumbersFrom0To56With52Numbers();
        String card = "Aa";


    }

    //a method for filling the field with black Peters &&
    private void fillFieldWithBlackPeters(){

    }

}
