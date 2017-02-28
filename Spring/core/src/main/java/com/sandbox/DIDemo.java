package com.sandbox;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * Main program that shows Dependency Injection using different objects.
 *
 */
public class DIDemo
{
    static Logger log = Logger.getLogger(DIDemo.class.getName());

    public static void main( String[] args )
    {
        System.out.println( "Begin Program" );
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring-beans.xml"});

        log.info("Creating a cities Bean");
        CitiesList citiesList = (CitiesList) context.getBean("citiesBean");

        log.info("Printing cities:");
        for (String city : citiesList.getCities()) {
            log.info("City: " + city);
        }
    }
}
