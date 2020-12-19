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
                    FieldSeen fieldSeen = new FieldSeen();
                    FieldGenerated fieldGenerated = new FieldGenerated();


                    //only for testing it will be deleted when we finish the testing
                    fieldGenerated.paintGeneratedField();


                    Player winner = players1And2PlayTheGame((Player1) players[0], (Player2) players[1], fieldSeen, fieldGenerated);
                    if(winner == null){
                        System.out.println();
                        System.out.println("--------Tie!!!--------");
                        System.out.println();
                        draw_A_Draw();
                    }else if(winner == players[0]){
                        System.out.println();
                        System.out.println("\t" + ANSI_YELLOW_BACKGROUND + "----Congratulations!!!----" + ANSI_RESET);
                        System.out.println("\t" + ANSI_YELLOW_BACKGROUND + "A winner is: " + players[0].getName() + ANSI_RESET);
                        System.out.println();
                        drawVictory();
                    }else{
                        System.out.println();
                        System.out.println("\t" + ANSI_YELLOW_BACKGROUND + "----Congratulations!!!----" + ANSI_RESET);
                        System.out.println("\t" + ANSI_YELLOW_BACKGROUND + "A winner is: " + players[1].getName() + ANSI_RESET);
                        System.out.println();
                        drawVictory();
                    }
                    break;
                }else{
                    //here is a space if a fighter is a PC
                    Player[] players = createPlayerAndPcPlayer();

                    //test
                    FieldSeen fieldSeen = new FieldSeen();
                    FieldGenerated fieldGenerated = new FieldGenerated();
                    fieldSeen.paintField((Player1)players[0], (PcPlayer)players[1]);
                    //test-end

                    Player winner = playerAndPcPlayTheGame((Player1) players[0], (PcPlayer) players[1], fieldSeen, fieldGenerated);



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
        while(name2.equals(name1)){
            System.out.println(ANSI_RED +"The name is already taken by Player 1. Enter different name: " +ANSI_RESET);
            name2 = sc.nextLine();
        }
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

        String namePC;
        do{ namePC = generateNamePc(); }while(namePC.equals(name1));
        PcPlayer pcPlayer = new PcPlayer(namePC);
        players[1] = pcPlayer;
        System.out.println(ANSI_RED +"Your opponent " + namePC +" (PC) stands ready. Enter random key to continue." +ANSI_RESET);
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
        System.out.println("  "+ANSI_CYAN+" 0000000000000000  00  00000000000000"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  00000000"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  00"+ANSI_RESET);
        System.out.println("  "+ANSI_CYAN+"        00         00  0000000000000"+ANSI_RESET);
    }


    //a method for playing the game between player1 vs player2
    private static Player players1And2PlayTheGame(Player1 player1, Player2 player2, FieldSeen fieldSeen, FieldGenerated fieldGenerated){
        fieldSeen.paintField(player1, player2);
        //till the cards are available
        while(fieldGenerated.checkWhetherCardsAreAvailable()) {
            //player1
            System.out.println(ANSI_BLUE + "---" + player1.getName() + "---" + ANSI_RESET);
            String[] indexes = player1.chooseCards(fieldSeen);
            int index1 = Integer.parseInt(indexes[0]);
            int index2 = Integer.parseInt(indexes[1]);
            //
            int identity = fieldGenerated.checkCards(index1, index2, fieldSeen);
                //in case the choice was right
            if (identity == 1) {
                player1.setScore(2);
                fieldSeen.paintField(player1, player2);
                //in case the choice was && and &&
            } else if (identity == 2) {
                //
                player1.setScore(-6);
                fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                //
                timer();
                fieldSeen.paintField(player1,player2);
                //in case the choice was && and whatever else
            } else if (identity == 3) {
                player1.setScore(-3);
                fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                timer();
                fieldSeen.paintField(player1,player2);
                //in case the choice was whatever and &&
            } else if (identity == 4) {
                player1.setScore(-3);
                fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                timer();
                fieldSeen.paintField(player1,player2);
                //in case the cards are not the same
            } else {
                fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                timer();
                fieldSeen.paintField(player1,player2);
            }
                //check whether we have cards
            if (fieldGenerated.checkWhetherCardsAreAvailable() == false) {
                break;
            }
                //in case the player1 was right
            if (identity == 1) {
                System.out.println(ANSI_BLUE + "---Your choice has been right :) " + player1.getName() + " go one more time!!!---" + ANSI_RESET);
                continue;
            }


            //player2 - similar to a player1
            if (fieldGenerated.checkWhetherCardsAreAvailable() == false) {
                break;
            }

            while (true) {
                if (fieldGenerated.checkWhetherCardsAreAvailable() == false) {
                    break;
                }
                System.out.println(ANSI_RED + "---" + player2.getName() + "---" + ANSI_RESET);
                indexes = player2.chooseCards(fieldSeen);
                index1 = Integer.parseInt(indexes[0]);
                index2 = Integer.parseInt(indexes[1]);
                //
                identity = fieldGenerated.checkCards(index1, index2, fieldSeen);
                if (identity == 1) {
                    player2.setScore(2);
                    fieldSeen.paintField(player1, player2);
                    //
                } else if (identity == 2) {
                    //
                    player2.setScore(-6);
                    fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                    //
                    timer();
                    fieldSeen.paintField(player1,player2);
                } else if (identity == 3) {
                    player2.setScore(-3);
                    fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                    timer();
                    fieldSeen.paintField(player1,player2);
                } else if (identity == 4) {
                    player2.setScore(-3);
                    fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                    timer();
                    fieldSeen.paintField(player1,player2);
                } else {
                    fieldSeen.paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(player1, player2, index1, index2, fieldGenerated);
                    timer();
                    fieldSeen.paintField(player1,player2);
                }
                if (fieldGenerated.checkWhetherCardsAreAvailable() == false) {
                    break;
                }
                if(identity == 1){
                    System.out.println(ANSI_RED + "---Your choice has been right :) " + player2.getName() + " go one more time!!!---" + ANSI_RESET);
                    continue;
                }else {
                    break;
                }
            }

        }
        //return who is winner 1 - player1, 2 - player2 and null if nobody
        if((player1.getScore()>player2.getScore()) && (player1.getScore()>0)){
            return player1;
        }else if((player2.getScore()>player1.getScore()) && (player2.getScore()>0)){
            return player2;
        }else{
            return null;
        }
    }




    //a method for playing the game between player1 vs player2
    private static Player playerAndPcPlayTheGame(Player1 player1, PcPlayer player2, FieldSeen fieldSeen, FieldGenerated fieldGenerated){
        return null;
    }



}
