package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by os_mac on 09.05.17.
 */
public class Parser {

    // Создаём список для заполнения его ссылками из файла
    List<String> list = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

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

    public void mapping(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(" ");
            if (!map.containsKey(str[0])){
                map.put(str[0], new ArrayList<String>());
            }
                map.get(str[0]).add(str[1]);

        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println("URL =  " + entry.getKey() + " file = " + entry.getValue());
        }
    }

}
