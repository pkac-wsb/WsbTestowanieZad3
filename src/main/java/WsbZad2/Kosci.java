package WsbZad2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Kosci {

    Random rand = new Random();
    public int playerPoints = 0;
    public int computerPoints = 0;
    public int[] rzutComputer = rzucWszystkie();
    public int[] rzutPlayer = rzucWszystkie();

    public void gra() {
        System.out.println("Twoj rzut: ");
        czytajRzut(rzutPlayer);
        finalnePunktyComputer();
        System.out.println("Chcesz poprawic rzut?");
        System.out.println("0 - nie     1 tak");
        if(input1or0() == 0){
            finalnePunktyGracza();
            System.out.println("rzut komputera: ");
            czytajRzut(rzutComputer);
            System.out.println("Twoje punkty: " + playerPoints + " Punkty Komputera: " + computerPoints);
            System.out.println("Wygrywa " + winner());
        }

    }

    public void finalnePunktyGracza() {
        playerPoints = podliczPunkty(rzutPlayer);
    }

    public void finalnePunktyComputer() {
        computerPoints = podliczPunkty(rzutComputer);
    }

    public String winner() {
        if(playerPoints > computerPoints) {
            return "gracz";
        } else {
            return "komputer";
        }
    }

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

    public int podliczPunkty(int[] rzut) {
        if(allEquals(rzut)) {
            return 50;
        } else if(allDifferent(rzut)) {
            return 5;
        } else {
            int x = 0;
            for(int i = 0; i < rzut.length; i++) {
                x = x + rzut[i];
            }
            return x;
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
                }
            }
        }
        return allD;
    }

    public int input() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x < 0 && x > 6) {
            System.out.println("sproboj ponownie");
            input();
        }
        return x;
    }

        public int input1or0() {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if(x != 1 && x != 0) {
                System.out.println("sproboj ponownie");
                input();
            }
            return x;
    }

}
