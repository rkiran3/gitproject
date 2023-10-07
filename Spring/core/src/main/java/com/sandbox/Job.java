package com.sandbox;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component("job")
public class Job {

    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    JobType jobType;

    static Logger log = Logger.getLogger(Job.class.getName());

    public JobType getJobType() {
        return jobType;
    }

    public Job(JobType jobType) {
        this.jobType = jobType;
        log.info("In Job Constructor, calling jobType.setName() ");
        //jobType.setName("Default ");
    }
}
