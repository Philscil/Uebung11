package h1;

public class H1_main {
    public static void main (String[] args) {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        System.out.println("Distance: " + distance(a, d));
    }

    public static int distance(Node x, Node y) {
        if (x == y) {
            return 0;
        }
        
        return distance(x.getNext(), y) + 1;
    }
}
