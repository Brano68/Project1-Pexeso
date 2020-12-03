package sk.kosisckaakademia.kkns.pexeso;

/*
it is a class Main for a main method, for creating objects and static methods
We are making a memory game with letters.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
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
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";


    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for(;;){ //menu of game an infinity loop
            String answer = askQuestions();
            if(answer.equals("1")){
                String choiceYourFighter = whoIsYourFighter();
                if(choiceYourFighter.equals("1")){
                    Player[] players = createTwoPlayers();
                    //a space for the rest code


                    //for testing a cup and a tie
                    drawVictory();
                    draw_A_Draw();
                }else{
                    //here is a space if a fighter is a PC
                    Player[] players = createPlayerAndPcPlayer();



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
        System.out.println();
        System.out.println(ANSI_PURPLE_BACKGROUND + "Do you have an opponent or you wanna play against PC? " + ANSI_RESET);
        System.out.println(ANSI_PURPLE_BACKGROUND + "If you want to play against another player, enter 1" + ANSI_RESET);
        System.out.println(ANSI_PURPLE_BACKGROUND + "If you don't, enter random key" + ANSI_RESET);
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
        System.out.println(ANSI_BLUE + "Player 1, enter your name: " + ANSI_RESET);
        String name1;
        name1 = sc.nextLine();
        Player1 player1 = new Player1(name1);
        players[0] = player1;

        System.out.println(ANSI_RED + "Player 2, enter your name: " + ANSI_RESET);
        String name2;
        name2 = sc.nextLine();
        Player2 player2 = new Player2(name2);
        players[1] = player2;

        return players;
    }

    //a method for creating one player and PCplayer
    private static Player[] createPlayerAndPcPlayer(){
        Player[] players = new Player[2];
        System.out.println(ANSI_BLUE +"Enter your name: " +ANSI_RESET);
        String name1 = sc.nextLine();
        Player1 player1 = new Player1(name1);
        players[0] = player1;

        String name2;
        do{name2 = generateNamePc();} while(name2.equals(name1));
        Player2 player2 = new Player2(name2);
        players[1] = player2;
        System.out.println(ANSI_RED +"Your opponent " +name2 +"(PC) stands ready. Enter random key to start the match ");
        sc.nextLine();

        return players;
    }

    //a method for generating name of PC
    private static String generateNamePc(){
        String[] names = new String[]{"Atom", "Zeus", "Mars", "PC-Friend", "Atlas", "Zolik", "Ludvik", "Spartakus", "Arnold"};
        int i= new Random().nextInt(names.length);
        return names[i];
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
        System.out.println("  "+ANSI_YELLOW_BACKGROUND+ANSI_PURPLE+"OOOOOOOOOOOOOO"+ANSI_RESET);
        System.out.println("   "+ANSI_YELLOW_BACKGROUND+"            "+ANSI_RESET);
        System.out.println("    "+ANSI_YELLOW_BACKGROUND+"          "+ANSI_RESET);
        System.out.println("     "+ANSI_YELLOW_BACKGROUND+"        "+ANSI_RESET);
        System.out.println("      "+ANSI_YELLOW_BACKGROUND+"      "+ANSI_RESET);
        System.out.println("       "+ANSI_YELLOW_BACKGROUND+"    "+ANSI_RESET);
        System.out.println("        "+ANSI_YELLOW_BACKGROUND+"OO"+ANSI_RESET);
        System.out.println("        "+ANSI_YELLOW_BACKGROUND+ANSI_PURPLE+"OO"+ANSI_RESET);
        System.out.println("        "+ANSI_YELLOW_BACKGROUND+"OO"+ANSI_RESET);
        System.out.println("     "+ANSI_YELLOW_BACKGROUND+"OOOOOOOO"+ANSI_RESET);
    }

    //a method for drawing a draw or tie, it happens when players have the same score or
    //their score is under 0
    private static void draw_A_Draw(){
        System.out.println("  "+ANSI_CYAN+"00000000000000000  00   00000000000000"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   00000000"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00   0000000000000"+ANSI_RESET);
    }



}
