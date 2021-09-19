package com.company;


public class FileSize {

    private static double sizeAll = 0;

    public double getSizeAll() {
        return sizeAll;
    }

    public static void setSizeAll(double size) {
        sizeAll += size;
    }

}
