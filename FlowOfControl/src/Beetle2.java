
/*
 * Initialization
 * 1. Static
 * 2. Instance Variable
 * 3. Constructor
 */
class Insect2 {
    int i = 9;
    int j;

    Insect2() {
        prt("i = " + i + ", j = " + j);
        j = 39;
    }

    static int x1 = prt("static Insect.x1 initialized");

    static int prt(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle2 {
    int k = prt2("Beetle.k initialized");

    static int prt2(String s) {
        System.out.println(s);
        return 42;
    }

    Beetle2() {
        prt2("k = " + k);
        // prt("j = " + j);
    }

    static int x2 = prt2("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Started program");
        Beetle2 b = new Beetle2();
    }
}
