package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Scanner scn = new Scanner(System.in);
//        int potoki =  scn.nextInt();

        Parser parser = new Parser();
        List<String> list = parser.parse("/Users/os_mac/IdeaProjects/JavaExam/FilesFromURL/textFile.txt");

        parser.mapping(list);
        Map<String, List<String>> mapURL = parser.map;

        // Перебираем mapURL, передаём ключ со значением в конструктор и запускаем потоки
        mapURL.forEach((key, value) -> {
            Download download = new Download(key, value);
            download.start();
            try {
                download.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

}
