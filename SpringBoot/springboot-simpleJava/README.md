# Basic SpringBoot application also shows Environment variables loaded from application.properties  

This example shows how to create a Spring Boot Project.

We need to have a pom.xml at the root directory of our application.
This file specifies this project is based of *spring-boot-starter-parent*

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

Now, we add a dependency *spring-boot-starter* to pull in a boot project so that we can run a simple application.

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
    
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
    
Install the application using

    mvn install

Run the application using the command

    mvn spring-boot:run 

We can see output like
 
	INFO 8526 --- [           main] com.example.demo.DemoApplication         : Input: Hello, World
	INFO 8526 --- [           main] com.example.demo.DemoApplication         : Output: dlroW ,olleH

To clean project

	mvn spring-boot:run clean
	[INFO] Deleting /pathtoproject/springboot-simpleJava/target
	

## Load properties 
Spring Boot is flexible to allow users to load custom properties from application.properties
It acts like a dictionary of key value pairs

	color=red
	
To show the values loaded, use the following snippet to print. It uses the Environment class 
which makes the values available to the program. 

	@Bean
    	ApplicationRunner applicationRunner(Environment environment) {
		 return args -> {
			 log.info("message from application.properties " + environment.getProperty("color"));
		 };
	 }
	 
When program is executed, we see output

	INFO 17067 --- [           main] com.example.demo.DemoApplication         : message from application.properties red

## Multiple properties files
When we need to specify different values in dev and prod for example, we can separate those
into different files 

resources/application-prod.properties

resources/application.properties

Each property file can now contain different value for that variable.

for example:

application.properties 

color=red

Whereas the prod version can contain different values for same variable "color"

application-prod.properties 

color=blue-prod

	$ mvn install # build changes and deploy to create new jar file and copy the properties files.

This will pick up the environment variable from application.properties.

	$ java  -jar target/demo-0.0.1-SNAPSHOT.jar "This is a very large string"

This will pick up the environment variable from application.properties.

	$ java -Dspring.profiles.active=prod -jar target/demo-0.0.1-SNAPSHOT.jar "This is a very large string"
	
To run using mvn spring-boot command line

This will pick up environment variables from application-prod.properties

	$ mvn spring-boot:run -Drun.profiles=prod  

This will pick up environment variables from application.properties

	$ mvn spring-boot:run 

