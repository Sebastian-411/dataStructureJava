package ui;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();
        controller.addNodes();
        System.out.println(controller.printNodes());
        controller.deleteNode(sc.nextLine());
        System.out.println(controller.printNodes());
        controller.editNode(sc.nextLine(), sc.nextLine());
        System.out.println(controller.printNodes());
    }
}