package com.company;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
        try {
            URL urlConnect = new URL(url);

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
            System.out.println(Thread.currentThread().getName() + " is done!");

            if (outFiles.size() != 0 || outFiles.size() != 1) {
                for (int i = 1; i < outFiles.size(); i++){
                    File source = new File(pack + outFiles.get(0));
                    File dest = new File(pack + outFiles.get(i));
                    Files.copy(source.toPath(), dest.toPath());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
