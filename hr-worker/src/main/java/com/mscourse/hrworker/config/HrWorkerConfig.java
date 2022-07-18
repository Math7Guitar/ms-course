package com.mscourse.hrworker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(value = "hr-worker")
public class HrWorkerConfig {
    
    private String greeting, defaultValue;
    
    //Constructors
    public HrWorkerConfig(String greeting, String defaultValue) {
        setGreeting(greeting);
        setDefaultValue(defaultValue);
    }

    public HrWorkerConfig() {}


    //Getters
    public String getGreeting() { return greeting; }
    public String getDefaultValue() { return defaultValue; }

    
    //Setters
    public void setGreeting(String greeting) { this.greeting = greeting; }
    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }
}
