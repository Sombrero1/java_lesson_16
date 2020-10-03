package ru.mirea;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    static ArrayList<Integer> cards1=new ArrayList<>();
    static ArrayList<Integer> cards2=new ArrayList<>();
    static int motion=0;
    public static void start(){
        Scanner scan = new Scanner(System.in);


        System.out.println("Введите карты первого игрока:");
        String t=scan.nextLine();
        String [] spl=t.split(" ");
        for (int i = 0; i <spl.length ; i++) {
            int a= Integer.parseInt(spl[i]);
            cards1.add(a);
        }
         System.out.println("Введите карты второго игрока:");
        t=scan.nextLine();
        spl=t.split(" ");
        for (int i = 0; i <spl.length; i++) {
            int a= Integer.parseInt(spl[i]);
            cards2.add(a);
        }

        System.out.println("===Начинаем игру===");
        while(cards1.size()!=0 && cards2.size()!=0){
            if(motion==106){
                System.out.println("botva");
                end();
                return;
            }
            motion++;
            round();
        }

        end();

    }
    public static void round(){

        System.out.println("---------------------------");
        System.out.println("Ход номер: " + motion);
        System.out.println("\t Первый игрок:" + cards1.get(0) + "\t Второй игрок: "+ cards2.get(0));
        if(compare(cards1.get(0),cards2.get(0))){
            System.out.println("Карты забирает первый игрок");
            cards1.add(cards1.get(0));//помещаем первую карту в конец
            cards1.remove(0);

            cards1.add(cards2.get(0)); //забираем карту проигравшего игрока
            cards2.remove(0);

        }
        else{
            System.out.println("Карты забирает второй игрок");
            cards2.add(cards2.get(0));//помещаем первую карту в конец
            cards2.remove(0);

            cards2.add(cards1.get(0));
            cards1.remove(0);
        }



        System.out.println("---------------------------");
    }

    public static boolean compare(int a, int b){//True - первый игрок, иначе второй
        if((a==0 && b==9) || a>b) return true; //младшая карта бьёт старшую
        return false;
    }

    public static void end(){
        System.out.println("===Итоги===");
        System.out.print("Первый игрок: ");
        for (int a:cards1
             ) {
            System.out.print(a+" ");

        }
        System.out.println();
        System.out.print("Второй игрок: ");
        for (int a:cards2
        ) {
            System.out.print(a+" ");

        }
        if(cards1.size()==0)
            System.out.println("\n!!!Победитель: второй игрок!!!");
        if(cards2.size()==0)
            System.out.println("\n!!!Победитель: второй игрок!!!");

    }
}
