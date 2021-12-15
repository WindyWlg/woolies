package com.weather.au.stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Locale;

public class StepDefinitions {

    @Steps
    CallAPI callAPISteps;

    Faker fakeData = new Faker(new Locale("en-NZ"));

    @Given("I like to surf in any of top beaches {string} of Sydney")
    public void iLikeToSurfInAnyOfTopBeachesPostcodesOfSydney(String postcodes) {
        callAPISteps.userSearchingforlonglat(postcodes);
        //callAPISteps.usercheckingforecast();
    }

    @And("I only like to surf on <Monday & Friday> in next {int} days")
    public void iOnlyLikeToSurfOnMondayFridayInNextDays(int arg0) {
    }

    @When("I look up the the weather forecast for the next {int} days with postcodes")
    public void iLookUpTheTheWeatherForecastForTheNextDaysWithPostcodes(int arg0) {
        //callAPISteps.usercheckingforecast()
    }

    @Then("I check to if see the temperature is between {int}°C and {int}°C")
    public void iCheckToIfSeeTheTemperatureIsBetweenCAndC(int arg0, int arg1) {
    }

    @And("I check wind speed to be between {int} and {int}")
    public void iCheckWindSpeedToBeBetweenAnd(int arg0, int arg1) {
    }

    @And("I check to see if UV index is <= {int}")
    public void iCheckToSeeIfUVIndexIs(int arg0) {
    }

    @And("I Pick best suitable spot out of top two spots, based upon suitable weather forecast for the day")
    public void iPickBestSuitableSpotOutOfTopTwoSpotsBasedUponSuitableWeatherForecastForTheDay() {
    }

    @Then("the result should include {string} with statusCode {string}")
    public void the_result_should_include_with_status_code(String expectedResult, String statusCode) {
        // restAssuredThat(lastResponse -> lastResponse.statusCode(Integer.parseInt(statusCode)));
    }
}
