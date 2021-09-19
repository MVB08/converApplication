package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {


    Map<String, List<String>> map = new HashMap<>();

    public List<String> parse(String textFile){
        List<String> list = new ArrayList<>();
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
        for (String s : list) {
            String[] str = s.split(" ");
            if (!map.containsKey(str[0])) {
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(str[1]);
        }

        map.forEach((key, value) -> {
            System.out.println(key + " == " + value);
        });
    }

}
