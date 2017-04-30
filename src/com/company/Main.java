package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    String url = "http://javadevblog.com/sitemap.xml";
        System.out.println(url);
        try {
            Download.downloadUsingStream(url, "/Users/os_mac/IdeaProjects/JavaExam/map.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
