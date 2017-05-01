package com.company;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by os_mac on 30.04.17.
 */
public class Download extends Thread {
    String url;
    String outFile;
    public Download(String url, String outFile){
        this.url = url;
        this.outFile = outFile;
    }
    public void run(){
        try {
            URL urlcon = new URL(url);
            BufferedInputStream bis = new BufferedInputStream(urlcon.openStream());
            FileOutputStream fis = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int count=0;
            while((count = bis.read(buffer,0,1024)) != -1)
            {
                fis.write(buffer, 0, count);
            }
            fis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //public static void downloadUsingStream(String urlStr, String file) throws IOException {

    //}
}
