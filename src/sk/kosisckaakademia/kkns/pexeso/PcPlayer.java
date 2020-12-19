package sk.kosisckaakademia.kkns.pexeso;

import java.util.Random;

public class PcPlayer extends Player {

    public PcPlayer(String name){
        super(name);
    }

    //a method for generating indexes according to the fieldseen
    public String[] generateIndexes(FieldSeen fieldSeen){
        String[] indexes = new String[2];
        int a, b;
        while(true){
            a = new Random().nextInt(56);
            if(checkIfTheCardIsStillAvailable(fieldSeen.getField(), a)){ indexes[0]=String.valueOf(a); break; }
        }

        while(true){
            b = new Random().nextInt(56);
            if(b!=a && checkIfTheCardIsStillAvailable(fieldSeen.getField(), b)){ indexes[1]=String.valueOf(b); break; }
        }
        return indexes;
    }

}
