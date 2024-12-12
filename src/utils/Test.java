package utils;

public class Test {
    public static void test() {
        int row = 0;
        int x = 5;
        row |= (1<<x);
        int y;
        y = (int)(Math.log(row) / Math.log(2));
        System.out.println(y);
        System.out.println(row);
    }
}
