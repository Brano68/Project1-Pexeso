package sk.kosisckaakademia.kkns.pexeso;

/*
it is a class Main for a main method, for creating objects and static methods
We are making a memory game with letters.
 */

import java.util.Scanner;

public class Main {
    //Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_GREY = "\u001B[90m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {

        String answer = askQuestions();
        for(;;){ //menu of game an infinity loop

        }

    }

    //a method for asking what does the player want
    private static String askQuestions(){
        System.out.println();
        System.out.println(ANSI_BLUE +"Welcome to Memory Console Game. " +ANSI_RESET);
        System.out.println("---------------------------------");
        System.out.println("If you are eager to play, enter 1");
        System.out.println(ANSI_YELLOW +"To see the game rules, enter 2" +ANSI_RESET);
        System.out.println(ANSI_RED +"Exit the game via random key" +ANSI_RESET);
        System.out.println("---------------------------------");

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        switch (value) {
            case "1": System.out.println("Starting the game.."); return value;
            case "2": System.out.println(ANSI_YELLOW +"Viewing the game rules.." +ANSI_RESET); return value;
            default: System.out.println(ANSI_RED +"Quitting the game.." +ANSI_RESET); return value;
        }

    }

    //a method for printing rules
    private static void printRules(){

    }

    //a method for finding out who is your fighter
    private static String whoIsYourFighter(){

        return "";
    }

    //a method for creating two players
    private static Player[] createTwoPlayers(){
        Player[] players = new Player[2];

        return players;
    }

    //a method for creating one player and PCplayer
    private static Player[] createPlayerAndPcPlayer(){
        Player[] players = new Player[2];

        return players;
    }

    //a method for generating name of PC
    private static String generateNamePc(){
        String[] names = new String[]{"Atom", "Zeus", "Mars", "PC-Friend"};

        
        return "";
    }

    //a method timer for 1,5s
    private static void timer(){

    }

    //a method for drawing a gold cup
    private static void drawVictory(){

    }

    //a method for drawing a draw or tie, it happens when players have the same score or
    //their score is under 0
    private static void draw_A_Draw(){

    }

}
