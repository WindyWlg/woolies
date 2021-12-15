package com.weather.au.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSingleRes {
    private int moonrise_ts;
    private String wind_cdir;
    private int rh;
    private double pres;
    private double high_temp;
    private int sunset_ts;
    private double ozone;
    private double moon_phase;
    private double wind_gust_spd;
    private int snow_depth;
    private int clouds;
    private int ts;
    private int sunrise_ts;
    private double app_min_temp;
    private double wind_spd;
    private int pop;
    private String wind_cdir_full;
    private double slp;
    private double moon_phase_lunation;
    private String valid_date;
    private double app_max_temp;
    private double vis;
    private double dewpt;
    private int snow;
    private int uv;
    private Weather weather;
    private int wind_dir;
    private Object max_dhi;
    private int clouds_hi;
    private int precip;
    private double low_temp;
    private double max_temp;
    private int moonset_ts;
    private String datetime;
    private double temp;
    private double min_temp;
    private int clouds_mid;
    private int clouds_low;
}
