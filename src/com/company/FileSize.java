package com.company;

import java.io.File;

/**
 * Created by os_mac on 14.05.17.
 */
public class FileSize {

    private static double sizeAll = 0;

    public double getSizeAll() {
        return sizeAll;
    }

    public static void setSizeAll(double size) {
        sizeAll += size;
    }

}
