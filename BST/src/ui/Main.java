package ui;
import model.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();
    public static void main(String[] args) {
        Main m = new Main();
        controller.addssss();
        while(true) {
            System.out.println("MENU:\n" +
                    "\t\t1. Agregar registro\n" +
                    "\t\t2. Buscar registro por puntaje\n" +
                    "\t\t3. Jugadores por orden alfabético\n" +
                    "\t\t4. delete\n" +
                    "\t\t5. Salir");
            switch (Integer.parseInt(sc.nextLine())){
                case 1:
                    m.addNode();
                    break;
                case 2:
                    System.out.println(controller.printScores());
                    break;
                case 3:
                    System.out.println(controller.printNames());
                    break;
                case 4:
                    controller.delete(sc.nextLine());
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
            }
        }
    }
    private void addNode(){
        System.out.println("Ingresa el nombre");
        String name = sc.nextLine();
        System.out.println("Ingresa el puntaje");
        int score = Integer.parseInt(sc.nextLine());
        if(controller.addNode(name, score)){
            System.out.println("Los usuarios han sido creados con exito");
        } else {
            System.out.println("Ha ocurrido un error");
        }
    }
}