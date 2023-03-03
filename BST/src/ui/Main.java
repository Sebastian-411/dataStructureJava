package ui;
import model.*;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Controller controller = new Controller();
    public static void main(String[] args) {
        Main m = new Main();
        while(true) {
            System.out.println("MENU:\n" +
                    "\t\t1. Agregar array\n" +
                    "\t\t2. Imprimir arbol en inverso\n" +
                    "\t\t3. Ver profundidad\n" +
                    "\t\t4. Salir");
            switch (Integer.parseInt(sc.nextLine())){
                case 1:
                    m.addNode();
                    break;
                case 2:
                    System.out.println(controller.print());
                case 3:
                    System.out.println("La profundidad es de " + controller.deep());
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ingresa un valor valido");
            }
        }
    }
    private void addNode(){
        System.out.println("Ingresa los nombres");
        String name = sc.nextLine();
        if(controller.addNode(name)){
            System.out.println("Los usuarios han sido creados con exito");
        } else {
            System.out.println("Ha ocurrido un error");
        }
    }
}