package com.sandbox;

import org.springframework.stereotype.Component;

/**
 * Created by ravikir on 2/27/2017.
 */
@Component("jobType")
public class JobType {
    String name;

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name;
    }

}
