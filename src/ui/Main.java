package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static ArrayList<Integer> firstBar;
    private  static ArrayList<Integer> secondBar;
    private static ArrayList<Integer> thirdBar;
    private static Scanner sc;


    public Main(){
        firstBar = new ArrayList<>();
        secondBar = new ArrayList<>();
        thirdBar = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public static void main(String [] args){
        Main main = new Main();

        //Save cases
        int cases = sc.nextInt();
        ArrayList<Integer> sizes = new ArrayList<>();
        int size = 0;
        while(cases > 0){
            size = sc.nextInt();
            sizes.add(size);
            cases--;
        }


        for(int i = 0; i < sizes.size(); i++){
            main.fillFirstBar(sizes.get(i));
            Collections.reverse(firstBar);
            solve(sizes.get(i), firstBar, thirdBar, secondBar);
            System.out.println();
            firstBar.clear();
            secondBar.clear();
            thirdBar.clear();
        }

    }

    public void fillFirstBar(int maxNum){
        for(int i = 0; i < maxNum; i++){
            firstBar.add(i);
        }
    }

    public static void solve(int numOfDisks, ArrayList<Integer> from, ArrayList<Integer> to, ArrayList<Integer> aux){
        if(numOfDisks == 0){
            System.out.println(firstBar.size()+" "+ secondBar.size()+" "+thirdBar.size());
            return;
        }
        if(numOfDisks == 1){
            System.out.println(firstBar.size()+" "+ secondBar.size()+" "+thirdBar.size());
            move(from, to);
            System.out.println(firstBar.size()+" "+ secondBar.size()+" "+thirdBar.size());
        }else{
            solve(numOfDisks-1 ,from, aux, to);
            move(from, to);
            solve(numOfDisks-1, aux, to, from);
        }
    }
    public static void move(ArrayList<Integer> from, ArrayList<Integer> to){
        to.add(from.get(from.size()-1));
        from.remove(from.size()-1);
    }
}
