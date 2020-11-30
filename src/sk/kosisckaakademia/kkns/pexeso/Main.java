package sk.kosisckaakademia.kkns.pexeso;

/*
it is a class Main for a main method, for creating objects and static methods
We are making a memory game with letters.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for(;;){ //menu of game an infinity loop
            String answer = askQuestions();
            if(answer.equals("1")){
                String choiceYourFighter = whoIsYourFighter();
                if(choiceYourFighter.equals("1")){
                    Player[] players = createTwoPlayers();
                    //a space for the rest code

                }else{
                    //here is a space if a fighter is a PC

                }
                break;
            }else if(answer.equals("2")){
                String choice = printRules();
                if(choice.equals("1")){
                    continue;
                }else{
                    continue;
                    //break; //if you want to quit the game instead of continue
                }
            }else {
                System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "You have just choosen  - Exit game!!!" + ANSI_RESET);
                System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Bye. I hope we will see you soon." + ANSI_RESET);
                break;
            }
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
    private static String printRules(){
        System.out.println();
        try{
            FileReader fr = new FileReader("resources/rules.txt");
            BufferedReader read = new BufferedReader(fr);
            String line = read.readLine();
            while(line!=null){
                System.out.println(line);
                line = read.readLine();
            }
            System.out.println();
            fr.close(); read.close();

            System.out.print(ANSI_RED +"Enter random key to continue.. ");
            String a = new Scanner(System.in).nextLine();
            return a;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    //a method for finding out who is your fighter
    private static String whoIsYourFighter(){
        System.out.println(ANSI_PURPLE_BACKGROUND + "Have you got a fighter or I will be your fighter?" + ANSI_RESET);
        System.out.println(ANSI_PURPLE_BACKGROUND + "In case you have the fighter press 1" + ANSI_RESET);
        System.out.println(ANSI_PURPLE_BACKGROUND + "If you do not have the fighter press any key." + ANSI_RESET);
        String result;
        result = sc.nextLine();
        if(result.equals("1")){
            return "1";
        }else{
            return "";
        }
    }

    //a method for creating two players
    private static Player[] createTwoPlayers(){
        Player[] players = new Player[2];
        System.out.println(ANSI_BLUE + "Player1 type your name: " + ANSI_RESET);
        String name1;
        name1 = sc.nextLine();
        Player1 player1 = new Player1(name1);
        players[0] = player1;

        System.out.println(ANSI_GREY + "Player2 type your name: " + ANSI_RESET);
        String name2;
        name2 = sc.nextLine();
        Player2 player2 = new Player2(name2);
        players[1] = player2;

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
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //a method for drawing a gold cup
    private static void drawVictory(){

    }

    //a method for drawing a draw or tie, it happens when players have the same score or
    //their score is under 0
    private static void draw_A_Draw(){

    }



}
