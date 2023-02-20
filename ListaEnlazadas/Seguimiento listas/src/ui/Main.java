package ui;
import model.*;

import java.util.Scanner;

public class Main {

    public static Controller controller = new Controller();
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("Por favor, ingresa tu nombre:");
        m.createPlayer(sc.nextLine());
        System.out.println("Por favor, ingresa los niveles que desea");
        m.createLevels(Integer.parseInt(sc.nextLine()));
        System.out.println("Niveles creados!");
        m.play();
        System.out.println(controller.statistics());

    }

    public void createPlayer(String name){
        controller.createPlayer(name);
    }

    public void createLevels(int n){
        controller.createLevels(n, 1);
    }

    public void play(){
        while(controller.canStillPlay()){
            System.out.println(controller.print());
            System.out.println(controller.getQuestion());
            System.out.println(" Answer: ");
            String answer = sc.nextLine();
            if(answer.equals("PASO")){
                controller.pass();
                System.out.println("Pasaste:///");
            }
            else {
                if ( controller.answer(Integer.parseInt(answer)) ){
                    System.out.println("Correcto!");
                } else {
                    System.out.println("Fallaste:(");
                }
            }
        }

    }






}