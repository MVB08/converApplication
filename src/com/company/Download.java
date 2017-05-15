package com.company;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by os_mac on 30.04.17.
 */
public class Download extends Thread {

    String url;
    List<String> outFiles;
    String pack = "/Users/os_mac/IdeaProjects/JavaExam/FilesFromURL/";

    public Download(String url, List<String> outFiles){
        this.url = url;
        this.outFiles = outFiles;
    }
    public void run(){
        System.out.println("Starting: " + Thread.currentThread().getId());
        System.out.println("Загружается файл: " + outFiles.get(0));

        long startFile = System.currentTimeMillis();

        try {

            //!!!!!!!!!!!!!!!!!!!!!!
            for (double progressPercentage = 0.0; progressPercentage < 1.0; progressPercentage += 0.01) {
                Progress.updateProgress(progressPercentage);
            }


            URL urlConnect = new URL(url);

            URLConnection connection = urlConnect.openConnection();
            int size = connection.getContentLength();
            System.out.println("File from web " + size / 1024 + " kB");

            byte[] buffer = new byte[1024];
            int count = 0;

            // Каждая ссылка запускается 1 раз, а если файлов несколько, то скачанный файл записывается во все

            BufferedInputStream bis = new BufferedInputStream(urlConnect.openStream());
            FileOutputStream fos = new FileOutputStream(pack + outFiles.get(0));
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                 fos.write(buffer, 0, count);
            }
            fos.close();
            bis.close();

            if (outFiles.size() != 0 || outFiles.size() != 1) {
                for (int i = 1; i < outFiles.size(); i++){
                    File source = new File(pack + outFiles.get(0));
                    File dest = new File(pack + outFiles.get(i));
                    Files.copy(source.toPath(), dest.toPath());
                }
            }


            Thread.sleep(5000);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: " + Thread.currentThread().getId());
        long timeFile = System.currentTimeMillis() - startFile;
        SimpleDateFormat sdfFile = new SimpleDateFormat("mm");

        double size = 0;
        File file = new File(pack + outFiles.get(0));
        if (file.exists()){
            size = (double) ((file.length() / 1024) * outFiles.size());
            System.out.println("Размер файла в kB: " + size);
            System.out.println("Файл " + outFiles.get(0) + " загружен: " + size + " kB" + " за " + sdfFile.format(timeFile) + " минуту");
            FileSize.setSizeAll(size);
        }
        System.out.println();
    }

}
