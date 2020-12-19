package sk.kosisckaakademia.kkns.pexeso;

public class FieldSeen extends Field {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_RED = "\u001B[31m";
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
    //a method was replaced by a generic method
    public void paintField1(Player1 player1, Player2 player2){

    }


    //a method for painting a gaming field player1 vs computer
    //a method was replaced by a generic method
    public void paintField2(Player1 player1, PcPlayer pcPlayer){

    }

    //test a generic method
    public <T extends Player> void paintField(Player1 player1, T player2){
        String border = "+-------------------------+";
        System.out.println();
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET + " " +
                ANSI_BLUE + player1.getName() + ": " + player1.getScore() + ANSI_RESET + " | " +
                ANSI_RED + player2.getName() + ": " + player2.getScore() + ANSI_RESET);
        for(int i = 0; i < field.length; i++){
            System.out.print("\t" + ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
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
            System.out.print(ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.println();
            //
            System.out.print("\t" +ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.print(ANSI_CYAN_BACKGROUND + "                         " + ANSI_RESET);
            System.out.print(ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.println();
        }
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET);
    }



    //a method which is used in case the cards are not same and wrong cards
    //are in the red zone
    public <T extends Player> void paintFieldSeenInCaseBlackPetersOrCardsAreNotTheSame(Player1 player1, T player2, int index1, int index2, FieldGenerated fieldGenerated){
        int count=0;
        for(int i=0; i< field.length; i++){
            for(int j=0; j<field[0].length; j++){
                if(count==index1 || count==index2) field[i][j]=fieldGenerated.field[i][j];
                count++;
            }
        }

        String border = "+-------------------------+"; count=0;
        System.out.println();
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET + " " +
                ANSI_BLUE + player1.getName() + ": " + player1.getScore() + ANSI_RESET + " | " +
                ANSI_RED + player2.getName() + ": " + player2.getScore() + ANSI_RESET);
        for(int i = 0; i < field.length; i++){
            System.out.print("\t" + ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
            for(int j = 0; j < field[0].length; j++){
                if(field[i][j].length() == 1){
                    System.out.print(" " + field[i][j]);
                    System.out.print(ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }else if(field[i][j].charAt(0) > '9'){
                    if(index1==count || index2==count) //----
                        System.out.print(ANSI_RED_BACKGROUND +field[i][j] + ANSI_RESET + ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                    else System.out.print(ANSI_YELLOW_BACKGROUND + field[i][j] + ANSI_RESET + ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }else{
                    if(index1==count || index2==count)
                        System.out.print(ANSI_RED_BACKGROUND +field[i][j] +ANSI_RESET +ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                    else System.out.print(field[i][j] + ANSI_CYAN_BACKGROUND + " " + ANSI_RESET);
                }
                count++;
            }
            System.out.print(ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.println();
            //
            System.out.print("\t" +ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.print(ANSI_CYAN_BACKGROUND + "                         " + ANSI_RESET);
            System.out.print(ANSI_GREEN_BACKGROUND + "|" + ANSI_RESET);
            System.out.println();
        }
        System.out.println("\t" + ANSI_GREEN_BACKGROUND + border + ANSI_RESET);

        hideWrongCards(index1, index2);
    }




    //a method which is used for hiding (turning) wrong cards
    private void hideWrongCards(int index1, int index2){
        int number = 0;
        int counter = 0;
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[0].length; j++){
                if(counter == index1){
                    field[i][j] = String.valueOf(number);
                }
                if(counter == index2){
                    field[i][j] = String.valueOf(number);
                }
                counter++;
                number++;
            }
        }
    }


}
