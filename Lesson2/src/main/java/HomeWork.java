public class HomeWork {
    public static void main(String[] args) {
        printLiterals();
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(calculateHypotenuse(3, 2));
    }

    private static void printLiterals() {
        boolean lit1 = true;
        String lit2 = "Hello";
        char lit3 = 'V';
        int lit4 = 0b1111;
        int lit5 = 0124;
        int lit6 = 235;
        int lit7 = 0x141D2;
        float lit8 = 2.32F;
        double lit9 = 150.45;
        System.out.println(lit1);
        System.out.println(lit2);
        System.out.println(lit3);
        System.out.println(lit4);
        System.out.println(lit5);
        System.out.println(lit6);
        System.out.println(lit7);
        System.out.println(lit8);
        System.out.println(lit9);
    }

    public static int sum(int a, int b) {
        long c = (long) a + (long) b;
        if (c > Integer.MAX_VALUE) {
            return -1;
        } else {
            return (int) c;
        }
    }

    public static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static double calculateHypotenuse(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}
