package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by os_mac on 09.05.17.
 */
public class Parser {

    // Создаём список для заполнения его ссылками из файла
    List<String> list = new ArrayList<>();

    // Построчно считываем файл и заполняем ими list
    public List<String> parse(String textFile){
        try {
            File file = new File(textFile);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null){
                list.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
