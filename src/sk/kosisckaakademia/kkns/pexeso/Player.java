package sk.kosisckaakademia.kkns.pexeso;


public abstract class Player {
    private String name;
    private int score = 0;

    public Player(String name){
        this.name = name;
    }

    public int getScore(){
        return score;
    }

}
