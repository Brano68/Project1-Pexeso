package sk.kosisckaakademia.kkns.pexeso;


import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Player {
    private String name;
    private int score = 0;

    public Player(String name){
        this.name = name;
    }

    public int getScore(){
        return score;
    }

    public String getName() {
        return name;
    }

    public void setScore(int point) {
        this.score += point;
    }

    public String[] chooseCards(FieldSeen fieldseen){
        String[] indexes = new String[2];
        int a, b;

        System.out.print(Main.ANSI_CYAN +"Enter card number: " +Main.ANSI_RESET);
        while (1>0){
            try {
                Scanner sc = new Scanner(System.in); a = sc.nextInt();
                //if(a<=55 && a>=0){ indexes[0]=String.valueOf(a); break; }
                if(a<=55 && a>=0 && checkIfTheCardIsStillAvailable(fieldseen.getField(), a)){ indexes[0]=String.valueOf(a); break; }
                else { System.out.print(Main.ANSI_RED +"Card doesn't exist. Try again.. " +Main.ANSI_RESET); continue; }
            }catch(InputMismatchException nfe) { System.out.print(Main.ANSI_RED +"Card doesn't exist. Try again.. " +Main.ANSI_RESET); continue; }
        }

        System.out.print(Main.ANSI_CYAN +"Pick another card to match with the previous: " +Main.ANSI_RESET);
        while (1>0){
            try {
                Scanner sc = new Scanner(System.in); b = sc.nextInt();
                //if(b<=55 && b>=0 && b!=a){ indexes[1]=String.valueOf(b); break; }
                if(b<=55 && b>=0 && b!=a && checkIfTheCardIsStillAvailable(fieldseen.getField(), b)){ indexes[1]=String.valueOf(b); break; }
                else if(b==a){ System.out.print(Main.ANSI_RED +"You picked the same card. Pick another.. " +Main.ANSI_RESET); continue; }
                else { System.out.print(Main.ANSI_RED +"Card doesn't exist. Try again.. " +Main.ANSI_RESET); continue; }
            }catch(InputMismatchException nfe) { System.out.print(Main.ANSI_RED +"Card doesn't exist. Try again.. " +Main.ANSI_RESET); continue; }
        }


        return indexes;
    }

    //a method if the card is still available
    public boolean checkIfTheCardIsStillAvailable(String[][] fieldSeen, int index){
        int number;
        String value;
        for(int i = 0; i < fieldSeen.length; i++){
            for(int j = 0; j < fieldSeen[0].length; j++){
                value = fieldSeen[i][j];
                if(value.charAt(0) >= '0' && value.charAt(0) <= '9'){
                    number = Integer.valueOf(fieldSeen[i][j]);
                    if(number == index){
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
