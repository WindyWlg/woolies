package com.weather.au.helpers;

import au.com.bytecode.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public static String checkDay(String date) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }

    public static void writetocsv(List<String> forecast) throws IOException {
         final String currentDir = System.getProperty("user.dir");
         String testDataExcelPath = null;

        testDataExcelPath = currentDir + "//src//test//resources//";

        File dir = new File(testDataExcelPath+"output.csv");
        FileWriter outputfile = new FileWriter(dir);

        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);

        // create a List which contains String array
        List<String> data = new ArrayList<>();
/*
        FileWriter fstream = new FileWriter(dir, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("Postcode,Lon,Lat,Day,Date,MaxTemp,MinTemp,Wind,UV");
        out.newLine();
        out.write(forecast);

        //close buffer writer
        out.close();*/
    }
}
