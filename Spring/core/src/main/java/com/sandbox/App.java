package com.sandbox;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Main program that shows Singleton and Prototype beans.
 *
 */
public class App 
{
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args )
    {
        System.out.println( "Begin Program" );
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring-beans.xml"});

        // Create a bean which is declared as a Singleton and associate
        // a value to its member field, the same value can be viewed in
        // any bean that is created at later stage.
        System.out.println("Creating a singleton \"jobBean\"");
        Job job = (Job) context.getBean("jobBean");

        // set a value which can be printed later
        job.setMessage("SingletonDemo");

        System.out.println("jobBean message=" + job.getMessage());
        log.info("Calling job.getJobType().getName()");
        System.out.println(job.getJobType().getName());

        System.out.println("Creating another singleton \"jobBean\" ");
        Job jobSingleton = (Job) context.getBean("jobBean");
        System.out.println("Printing jobSingletonBean message=" +
                jobSingleton.getMessage());
    }
}
