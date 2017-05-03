package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//	      String url1 = "http://javadevblog.com/sitemap.xml";

        // Создаём список для заполнения его ссылками из файла
        List<String> list = new ArrayList<>();

        // Построчно считываем файл и заполняем ими list
        try {
            File file = new File("/Users/os_mac/IdeaProjects/JavaExam/textFile.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null){
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        String[] strings = new String[3];
//        strings[0] = "http://www.licey86.ru/content/galleryBig/file204.jpg first.jpg";
//        strings[1] = "http://www.licey86.ru/content/galleryBig/file34.jpg second.jpg";
//        strings[2] = "http://www.licey86.ru/content/galleryBig/file19.jpg third.jpg";
//        strings[0].split(" ");

//        for (int i = 0; i < strings.length; i++){

        // Каждую строку делим по пробелу, первую часть - URL-ссылку передаём первым параметром, вторую - имя выходного файла - вторым параметром и стартуем всё в разных потоках
        for (int i = 0; i < list.size(); i++){
            String[] str = list.get(i).split(" ");
            Download download = new Download(str[0], "/Users/os_mac/IdeaProjects/JavaExam/" + str[1]);
            download.start();
            try {
                download.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Download.downloadUsingStream(strings[i], "/Users/os_mac/IdeaProjects/JavaExam/" + "lic" + (i + 1) + ".jpg");
        }
    }

}
