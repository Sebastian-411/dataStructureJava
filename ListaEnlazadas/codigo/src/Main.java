public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(
                new Node("Pedrito")
        );
        list.addNode(
                new Node("Miguel")
        );
        list.addNode(
                new Node("Samuel")
        );
        list.print();

        list.addNode(
                new Node("Ricardo")
        );
        list.addHead(
                new Node( "Juan")
        );

        System.out.println(list.print());
        list.delete("Ricardo");
        System.out.println(list.print());
    }
}