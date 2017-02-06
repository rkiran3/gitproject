package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        String message = "Hello, World";

        if (args.length > 0) {
            log.info("Program has arguments: " + args[0]);
            message = args[0];
        }
        char[] charArray = message.toCharArray();

        int msglength = message.length() - 1;
        int begin = 0;
        while (begin < msglength) {
            char temp = charArray[begin];
            charArray[begin] = charArray[msglength];
            charArray[msglength] = temp;
            begin++;
            msglength--;
        }
        log.info("Input: " + message);
        log.info("Output: " + new String(charArray));
	}
}
