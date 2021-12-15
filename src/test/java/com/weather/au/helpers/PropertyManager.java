package com.weather.au.helpers;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String baseUrl, key;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);

        //Get properties from configuration.properties

        baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("baseurl");
        key = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("key");
        //Global test data excel file
    }

    public String getKey() {
        return key;
    }

    public String getbaseUrl() {
        return baseUrl;
    }

}

