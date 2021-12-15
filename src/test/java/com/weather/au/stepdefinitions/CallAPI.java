package com.weather.au.stepdefinitions;

import com.weather.au.helpers.CommonRestMethods;
import com.weather.au.helpers.ExcelUtil;
import com.weather.au.helpers.Util;
import com.weather.au.models.GetSingleResWrapper;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.text.ParseException;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CallAPI {

    CommonRestMethods commonRestMethods = new CommonRestMethods();
    Response getRes;

    @Step("User getting citys long-lat and write to excel")
    public void userSearchingforlonglat(String postcode) {
        try {
            //ExcelUtil.setExcelFileSheet("City");
            commonRestMethods.getRequest("?postal_code=" + postcode + "&country=AU&days=16");
            GetSingleResWrapper obj = lastResponse().getBody().as(GetSingleResWrapper.class);
            String lon = String.valueOf(obj.getLon());
            String lat = String.valueOf(obj.getLat());

            for (int j = 0; j < obj.getGetSingleRes().size(); j++) {
                String date = obj.getGetSingleRes().get(j).getDatetime();
                String day = Util.checkDay(date);
                if (day.contains("Monday") || day.contains("Friday")) {
                    String mon = date;
                    String max_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMax_temp());
                    String min_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMin_temp());
                    String wind_mon = String.valueOf(obj.getGetSingleRes().get(j).getWind_spd());
                    String uv_mon = String.valueOf(obj.getGetSingleRes().get(j).getUv());
                    System.out.println("Postcode - " + postcode);
                    System.out.println("Day - " + day);
                    System.out.println("Date - " + date);
                    System.out.println("Lon - " + lon);
                    System.out.println("Lat - " + lat);
                    System.out.println("Max-Temp - " + max_temp_mon);
                    System.out.println("Min-Temp - " + min_temp_mon);
                    System.out.println("Wind - " + wind_mon);
                    System.out.println("UV - " + uv_mon);

                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Step("User getting citys 16 days forecast and write to excel")
    public void usercheckingforecast() {
        try {
            ExcelUtil.setExcelFileSheet("City");
            int getrowCount = ExcelUtil.getRowCount("City");
            for (int i = 1; i <= getrowCount; i++) {
                String postcode = ExcelUtil.getCellData(i, 0);
                commonRestMethods.getRequest("?postal_code=" + postcode + "&country=AU&days=16");
                System.out.println("res" + lastResponse().prettyPrint());
                GetSingleResWrapper obj = lastResponse().getBody().as(GetSingleResWrapper.class);
                for (int j = 1; j <= obj.getGetSingleRes().size(); j++) {
                    String date = obj.getGetSingleRes().get(j).getDatetime();
                    String day = Util.checkDay(date);
                    System.out.println("day-" + day);
                    if (day.contains("Monday")) {
                        ExcelUtil.setExcelFileSheet("City");
                        String mon = date;
                        String max_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMax_temp());
                        String min_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMin_temp());
                        String wind_mon = String.valueOf(obj.getGetSingleRes().get(j).getWind_spd());
                        String uv_mon = String.valueOf(obj.getGetSingleRes().get(j).getUv());
                        System.out.println("forecast - " + date + Util.checkDay(date) + postcode + min_temp_mon + max_temp_mon + wind_mon + uv_mon);

                       /* ExcelUtil.setCellData(date, j, 4);
                        ExcelUtil.setCellData(day, j, 5);
                        //ExcelUtil.setCellData(postcode, j, 0);
                        ExcelUtil.setCellData(min_temp_mon, j, 6);
                        ExcelUtil.setCellData(max_temp_mon, j, 7);
                        ExcelUtil.setCellData(wind_mon, j, 8);
                        ExcelUtil.setCellData(uv_mon, j, 9);*/
                    } else if (day.contains("Friday")) {
                        /*ExcelUtil.setExcelFileSheet("City");
                        String mon = date;
                        String max_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMax_temp());
                        String min_temp_mon = String.valueOf(obj.getGetSingleRes().get(j).getMin_temp());
                        String wind_mon = String.valueOf(obj.getGetSingleRes().get(j).getWind_spd());
                        String uv_mon = String.valueOf(obj.getGetSingleRes().get(j).getUv());
                        System.out.println("forecast - " + date + Util.checkDay(date) + postcode + min_temp_mon + max_temp_mon + wind_mon + uv_mon);
                        ExcelUtil.setCellData(date, j, 4);
                        ExcelUtil.setCellData(day, j, 5);
                        //ExcelUtil.setCellData(postcode, j, 0);
                        ExcelUtil.setCellData(min_temp_mon, j, 6);
                        ExcelUtil.setCellData(max_temp_mon, j, 7);
                        ExcelUtil.setCellData(wind_mon, j, 8);
                        ExcelUtil.setCellData(uv_mon, j, 9);*/
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
