package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



//        Scanner scn = new Scanner(System.in);
//        int potoki =  scn.nextInt();


        Parser parser = new Parser();
        List<String> list = parser.parse("/Users/os_mac/IdeaProjects/JavaExam/textFile.txt");

        parser.mapping(list);

        // Каждую строку делим по пробелу, первую часть - URL-ссылку передаём первым параметром, вторую - имя выходного файла - вторым параметром и стартуем всё в разных потоках
        for (int i = 0; i < list.size(); i++){
            String[] str = list.get(i).split(" ");
            Download download = new Download(str[0], "/Users/os_mac/IdeaProjects/JavaExam/" + str[1]);
            download.start();
            System.out.println("File #" + i + " is downloaded!");
            try {
                download.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Download.downloadUsingStream(strings[i], "/Users/os_mac/IdeaProjects/JavaExam/" + "lic" + (i + 1) + ".jpg");
        }
    }

}
