package com.mscourse.hrworker.model.classes;

public class Greeting {
    
    private final long id;
    private final String content;

    //Constructor
    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    //Getters
    public long getId() { return id; }
    public String getContent() { return content; }
}
