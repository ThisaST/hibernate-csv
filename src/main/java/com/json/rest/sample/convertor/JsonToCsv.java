package com.json.rest.sample.convertor;

import com.github.opendevl.JFlat;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Praneeth
 */
public class JsonToCsv {

    public static void main(String args[]) {
        // Generate csv file
        try {
            String str = new String(Files.readAllBytes(Paths.get("G:/UserData.json")));
            JFlat flatMe = new JFlat(str);
            List<Object[]> json2csv = flatMe.json2Sheet().getJsonAsSheet();
            flatMe.write2csv("G:/UserData.csv");

            final String[][] row = {null};
            String csvFilename = "G:/json-pilot/UserData.csv";

            try (CSVReader csvReader = new CSVReader(new FileReader(csvFilename))) {
                List content = csvReader.readAll();
                System.out.println("content list size" + content.size());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
