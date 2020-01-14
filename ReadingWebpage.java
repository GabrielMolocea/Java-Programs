package com.beginner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

class ReadingWebpage{
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://github.com/");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null){
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            System.out.println(sb);
        }
    }
}