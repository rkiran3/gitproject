# Uses SQL Server Adventureworks

This example shows how to create a Spring Boot Project.

We need to have a pom.xml at the root directory of our application.
This file specifies this project is based of *spring-boot-starter-parent*

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.6.RELEASE</version>
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

    mvn spring-boot:run abcd

We can see output like 

    INFO 10868 --- [           main] com.example.demo.DemoApplication         : Program has arguments: abcd
    INFO 10868 --- [           main] com.example.demo.DemoApplication         : Input: abcd
    INFO 10868 --- [           main] com.example.demo.DemoApplication         : Output: dcba




