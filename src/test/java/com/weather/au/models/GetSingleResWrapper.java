package com.weather.au.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetSingleResWrapper {
    @JsonProperty("data")
    private List<GetSingleRes> getSingleRes;
    private String city_name;
    private String lon;
    private String timezone;
    private String lat;
    private String country_code;
    private String state_code;
}
