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

    //a method for generating 52numbers without repeating
    private int[] generateArrayRandomNumbersFrom0To55With52Numbers(){
        int[] arr = new int[52];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            for(;;){
                int num = new Random().nextInt(56);
                if(set.add(num)==true){ arr[i]=num; break; }
            }
        }

        return arr;
    }


    //a method for filling the field with alphabet
    private void fillFieldWithAlphabet(){
        int[] arr = generateArrayRandomNumbersFrom0To55With52Numbers();
        String card = "Aa";

        for(int x=0; x<arr.length; x++) {
            int count=0;
            for (int i = 0; i < field.length; i++) {
                for (int j=0; j<field[i].length; j++) {
                    if (count == arr[x]) {
                        field[i][j] = card;
                        card = String.valueOf((char)(card.charAt(0)+1)) + String.valueOf((char)(card.charAt(1)+1));
                        if(card.equals("[{")) card="Aa";
                    }
                    count++;
                }
            }
        }


    }

    //a method for filling the field with black Peters &&
    private void fillFieldWithBlackPeters(){
        String blackPeter = "&&";
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                if(field[i][j].equals(" ")){
                    field[i][j] = blackPeter;
                }
            }
        }
    }

    //a testing method for drawing a generated field
    public void paintGeneratedField(){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }


    //a method which contols if we have cards
    public boolean checkWhetherCardsAreAvailable(){
        for(int i=0; i< field.length; i++){
            for(int j=0; j<field[0].length; j++){
                String check="Aa";
                while(check.charAt(0)<='Z'){
                    if(field[i][j].equals(check)) return true;
                    check=String.valueOf((char)(check.charAt(0)+1)) + String.valueOf((char)(check.charAt(1)+1));
                }
            }
        }

        return false;
    }


    //a method for a comparing cards and if cards are the same filling with them
    public int checkCards(int index1, int index2, FieldSeen fieldSeen){
        int counter = 0;
        String card1 = "";
        String card2 = "";
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                if(counter == index1){
                    card1 = field[i][j];
                    i1 = i;
                    j1 = j;
                }
                if(counter == index2){
                    card2 = field[i][j];
                    i2 = i;
                    j2 = j;
                }
                counter++;
            }
        }

            //in case cards are the same for example Aa - Aa
        if(card1.equals(card2) && (card1.equals("&&") == false)){
            fieldSeen.getField()[i1][j1] = field[i1][j1];
            fieldSeen.getField()[i2][j2] = field[i2][j2];
            field[i1][j1] = " ";
            field[i2][j2] = " ";
            return 1;
            //in case cards are Black Peters && - &&
        }else if(card1.equals(card2)){
            return 2;
            //in case that the first card is Black Peter
        }else if(card1.equals("&&")){
            return 3;
            //in case that the second card is Black Peter
        }else if(card2.equals("&&")){
            return 4;
        }
            //in case that the cards are not the same
        else{
            return 5;
        }
    }

}
