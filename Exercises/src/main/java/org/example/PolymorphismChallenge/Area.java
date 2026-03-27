package org.example.PolymorphismChallenge;

public class Area {
    public static int calculateArea(int width) {
        return width * width;
    }
    public static int calculateArea(int width, int height) {
        return width * height;
    }
    public static double calculateArea(double width) {
        return width * width;
    }
    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static void Test() {
        System.out.println(Area.calculateArea(5));
        System.out.println(Area.calculateArea(5, 10));
        System.out.println(Area.calculateArea(2.5f));
        System.out.println(Area.calculateArea(2.5f, 10.1f));
    }
}
