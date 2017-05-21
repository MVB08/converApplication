package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by os_mac on 09.05.17.
 * Парсер для файла
 * Из списка строчек, содержащих через пробел http-ссылку и имя файла,
 * в который надо сохранить скачанный файл
 */
public class Parser {

    // Создаём список для заполнения его ссылками из файла

    Map<String, List<String>> map = new HashMap<>();

    /**
     * Построчно считываем файл и заполняем ими list
     * @param textFile - файл со строками типа: http-ссылка_пробел_имя файла, под которым его надо сохранить
     * @return ArrayList строк из фала
     */
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



    /**
     * Передаём в метод список, делим его на 2 части и складываем в map, где ключ - URL,
     * а значение - список с названиями выходных файлов
     * @param list - список строк из файла
     */
    public void mapping(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(" ");
            if (!map.containsKey(str[0])){
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(str[1]);
        }

        map.forEach((key, value) -> {
            System.out.println(key + " == " + value);
        });
    }

}
