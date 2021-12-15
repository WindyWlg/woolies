package com.weather.au.helpers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class CommonRestMethods {

    String baseUrl, key = "";
    private Response response;
    List<String> innerArrayValueOfJSONObject = new ArrayList<String>();
    public String token;

    public RequestSpecification blogReqSpec() {
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);

        baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("baseurl");
        key = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("key");

        return new RequestSpecBuilder().setBaseUri(baseUrl)
                .setContentType("application/json")
                .addQueryParam("key", key)
                .build();
    }

    public CommonRestMethods() {
    }

    public Response getRespose(String url) {
        try {
            return response = SerenityRest.given().spec(blogReqSpec())
                    .when()
                    .get(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public int validateStatusCode() {
        try {
            int status = response.getStatusCode();
            if (response.getStatusCode() == 200 || response.getStatusCode() == 201 || response.getStatusCode() == 202) {
                return response.getStatusCode();
            } else {
                System.out.println("Failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }

    public String getValueFromResponseWithJsonObject(int count, String jsonObject) {
        try {
            JSONArray arr = new JSONArray(response.asString());
            JSONObject obj = arr.getJSONObject(count);
            return obj.getString(jsonObject);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonObject;
    }

    public List getValueFromResponseWithJsonObjectAndObjectArray(int count, String jsonObjectArrayValue) {
        try {
            JSONArray arr = new JSONArray(response.asString());
            JSONObject obj = arr.getJSONObject(count);
            JSONArray jsonObjectArray = obj.getJSONArray(jsonObjectArrayValue);
            for (int i = 0; i <= jsonObjectArray.length() - 1; i++) {
                innerArrayValueOfJSONObject.add(jsonObjectArray.getString(i));
            }
            return innerArrayValueOfJSONObject;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return innerArrayValueOfJSONObject;
    }

    public String getValueFromJsonObjectForStringValue(String object) throws JSONException {
        JSONObject json = new JSONObject(response.asString());
        return json.getString(object);
    }

    public Boolean getValueFromJsonObjectForBooleanValue(String object) throws JSONException {
        JSONObject json = new JSONObject(response.asString());
        return json.getBoolean(object);
    }

    public void getRequest(String path) {
        response = SerenityRest.given().spec(blogReqSpec()).get(path);
    }

    public void checkStatusCodeResponse(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    public void checkBodyLength(Integer expectedValue) {
        response.then().assertThat().body("size()", is(expectedValue));
    }

    public void checkBodyUsingJsonPath(String jsonPath, String expectedValue) {
        response.then().body(jsonPath, equalTo(expectedValue));
    }

    public String getValueFromResponse(String attribute) {
        return response.then().extract().path(attribute).toString();
    }
}
