package WsbZad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Kosci {

    Random rand = new Random();
    int playerPoints = 0;
    int computerPoints = 0;
    int[] rzutComputer = rzucWszystkie();
    int[] rzutPlayer = rzucWszystkie();


    public int[] rzucWszystkie(){
        int[] rzut1 = new int[5];
        for(int i = 0; i < rzut1.length; i++) {
            rzut1[i] = rand.nextInt(7);
        }
        return rzut1;
    }

    public void czytajRzut(int[] rzut) {
        for(int i = 0; i < rzut.length; i++) {
            System.out.println("Kość " + i + ": " + rzut[i]);
        }
    }




    public ArrayList<Integer> tabToArray(int[] rzut) {
        ArrayList<Integer> comb = new ArrayList<>();
        for(int x : rzut) {
            comb.add(x);
        }
        return comb;
    }

    public boolean allEquals(int[] rzut) {
        for(int x : rzut) {
            if(x != rzut[0]) {
                return false;
            }
        }
        return true;
    }

    public boolean allDifferent(int[] rzut) {
        boolean allD = true;
        for(int i = 0; i < rzut.length; i++) {
            for(int j = i+1; j < rzut.length; j++) {
                if(rzut[i] == rzut[j]) {
                    allD = false;
                } else {
                    allD = true;
                }
            }
        }
        return allD;
    }

}
