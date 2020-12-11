package sk.kosisckaakademia.kkns.pexeso;

public class FieldSeen extends Field {

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
        String[][] f = getField();

        System.out.println();
        System.out.println("+-------------------------+" +"  "
                +"\u001B[34m" +player1.getName() +": " +player1.getScore() +" "
                +"\u001B[31m" +player2.getName() +": " +player2.getScore() +"\u001B[0m");
        System.out.print("| ");
        for(int j=0; j<f[0].length; j++) System.out.print(f[0][j]);
    }


}
