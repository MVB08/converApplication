package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//	      String url1 = "http://javadevblog.com/sitemap.xml";
//        String url2 = "http://www.licey86.ru/content/galleryBig/file34.jpg";
//        String url3 = "http://www.licey86.ru/content/galleryBig/file19.jpg";
        String[] strings = new String[3];
        strings[0] = "http://www.licey86.ru/content/galleryBig/file204.jpg";
        strings[1] = "http://www.licey86.ru/content/galleryBig/file34.jpg";
        strings[2] = "http://www.licey86.ru/content/galleryBig/file19.jpg";
        try {
            for (int i = 0; i < strings.length; i++){
                Download.downloadUsingStream(strings[i], "/Users/os_mac/IdeaProjects/JavaExam/" + "lic" + (i + 1) + ".jpg");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
