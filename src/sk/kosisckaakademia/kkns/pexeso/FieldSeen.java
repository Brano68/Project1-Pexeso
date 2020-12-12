package sk.kosisckaakademia.kkns.pexeso;

public class FieldSeen extends Field {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";


    //constructor
    public FieldSeen(){
        fillFieldWithNumbers();
    }


    //a method for filling a field with numbers from 0 to 55
    private void fillFieldWithNumbers(){
        int count=0;
        for(int i=0; i< field.length; i++)
            for(int j=0; j<field[0].length; j++)
                field[i][j]=String.valueOf(count++);
    }


    //a method for painting a gaming field player1 vs player2
    public void paintField1(Player1 player1, Player2 player2){

    }


    //a method for painting a gaming field player1 vs computer
    public void paintField2(Player1 player1, PcPlayer pcPlayer){

    }

    //test
    public <T extends Player> void paintField(Player1 player1, T player2){
/*
        String[][] f = getField();

        System.out.println();
        System.out.println("+-------------------------+" +"  "
                +"\u001B[34m" +player1.getName() +": " +player1.getScore() +" "
                +"\u001B[31m" +player2.getName() +": " +player2.getScore() +"\u001B[0m");
        System.out.print("| ");
        for(int j=0; j<f[0].length; j++) System.out.print(f[0][j]);



 */

        String border = "###########################";
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET + " " +
                ANSI_PURPLE + player1.getName() + " Score:" + player1.getScore() + ANSI_RESET + "\t" +
                ANSI_BLUE + player2.getName() + " Score:" + player2.getScore() + ANSI_RESET);
        for(int i = 0; i < field.length; i++){
            System.out.print("\t" + ANSI_GREEN_BACKGROUND + "#" + ANSI_RESET);
            System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
            for(int j = 0; j < field[0].length; j++){
                if(field[i][j].length() == 1){
                    System.out.print(" " + field[i][j]);
                    System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }else if(field[i][j].charAt(0) > '9'){
                    System.out.print(ANSI_YELLOW_BACKGROUND + field[i][j] + ANSI_RESET + ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }else{
                    System.out.print(field[i][j] + ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }
            }
            System.out.print(ANSI_GREEN_BACKGROUND + "#" + ANSI_RESET);
            System.out.println();
            //
            System.out.print("\t" +ANSI_GREEN_BACKGROUND + "#" + ANSI_RESET);
            System.out.print(ANSI_CYAN_BACKGROUND + "                         " + ANSI_RESET);
            System.out.print(ANSI_GREEN_BACKGROUND + "#" + ANSI_RESET);
            System.out.println();
        }
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET);
    }




}
