package com.company;


/**
 * Created by os_mac on 14.05.17.
 * Класс, хранящий информацию о объёме скачанных файлов
 */
public class FileSize {

    private static double sizeAll = 0;

    /**
     * Получаем объём скачанных файлов
     * @return объём в байтах
     */
    public double getSizeAll() {
        return sizeAll;
    }

    /**
     * При каждом скачивании значение суммарного объёма увеличивается
     * @param size - объём скачанного файла
     */
    public static void setSizeAll(double size) {
        sizeAll += size;
    }

}
