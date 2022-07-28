package com.mscourse.hrworker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("hr-worker")
public class GreetingConfig {
    
    //Atributes
    private String greeting;
    private String defaultValue;

    //Constructors
    public GreetingConfig(String greeting, String defaultValue) {
        setGreeting(greeting);
        setDefaultValue(defaultValue);
    }

    public GreetingConfig() {}


    //Getters
    public String getGreeting() { return greeting; }
    public String getDefaultValue() { return defaultValue; }


    //Setters
    public void setGreeting(String greeting) { this.greeting = greeting; }
    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }


}
