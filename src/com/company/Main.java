package com.company;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int nThreads =  scn.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        Parser parser = new Parser();

        List<String> list = parser.parse("src/links.txt");

        parser.mapping(list);
        Map<String, List<String>> mapURL = parser.map;

        System.out.println("The HashMap has " + mapURL.size() + " element(s).");
        System.out.println(Runtime.getRuntime().availableProcessors());

        long start = System.currentTimeMillis();
        // Перебираем mapURL, передаём ключ со значением в конструктор и запускаем потоки
        mapURL.forEach((key, value) -> {
                executor.submit(new Download(key, value));
        });

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        SimpleDateFormat sdf = new SimpleDateFormat("mm' минуты 'ss");

        System.out.println();
        FileSize fs = new FileSize();
        System.out.println("Завершено: 100%");
        System.out.printf("Загружено: " + mapURL.size() + " файлов, %.1f MB\n", (fs.getSizeAll() / 1024));
        System.out.println("Время: " + sdf.format(time) + " секунд");
        System.out.printf("Средняя скорость: %.1f kB/s\n", ((fs.getSizeAll() * 1024) / time));

    }

}
