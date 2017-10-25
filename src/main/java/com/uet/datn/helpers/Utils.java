package com.uet.datn.helpers;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Utils {

    public boolean writeFile(String fileName, List<String> content) throws IOException {
        File file = new File("upload-dir/" + fileName);

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (String str:content){
            bw.write(content + "\n");
        }
        bw.close();

        return true;
    }

    public boolean writeFile(String fileName, String content) throws IOException {
        File file = new File("upload-dir/" + fileName);

        if (!file.exists()){
            file.createNewFile();
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(content);
        bw.close();

        return true;
    }

    public List<String> readFile(String fileName) throws IOException {
        List<String> strs = new ArrayList<String>();

        File file = new File("upload-dir/" + fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String inLine = "";
        while ((inLine = br.readLine()) != null){
            strs.add(inLine);
        }
        br.close();

        return strs;
    }

    public List<String> replace(List<String> stringList, int index, String value){
        List<String> newStringList = new ArrayList<>();

        for (int i = 0; i < stringList.size(); i++){
            if (i == index){
                newStringList.add(value);
            }else {
                newStringList.add(stringList.get(i));
            }
        }

        return newStringList;
    }
}
