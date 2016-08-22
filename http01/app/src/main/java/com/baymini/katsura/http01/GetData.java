package com.baymini.katsura.http01;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Katsura on 2016-04-04.
 */
public class GetData {
    public static byte[] getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");

        if(conn.getResponseCode() != 200){
            throw new RuntimeException("请求URL失败");

        }

        InputStream inStream = conn.getInputStream();
        byte[] bt =StreamTool.read(inStream);
        inStream.close();
        return bt;
    }

    public static String getHtml(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");

        if(conn.getResponseCode() != 200){
            InputStream in = conn.getInputStream();
            byte[] data = StreamTool.read(in);
            String html = new String(data, "UTF-8");
            return html;
        }

        return null;
    }
}
