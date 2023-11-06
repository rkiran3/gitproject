# Getting Started

## This project will show how to display configuration properties

The main program will autowire an AppInfo class which will have an annotation

@ConfigurationProperties(prefix = "app")
@Component

	@Component           // will enable component scanning 
	@ConfigurationProperties ## specify the prefix which will be specified in 

resources\application.properties will have 
	
	app.name=Default Name

AppInfo.java

	@Component
	@ConfigurationProperties
	public class AppInfo {
		public String name;
		public String description;
	}

## Project to use H2 database and JPA 

We can setup project initially with JPA or enhance on an existing project to support JPA. To do so, add the starter-data-jpa in pom.xml
 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

This will allow us to focus on application and leave all the database details to JPA.

## Tomcat

Project will load Tomcat and show in logs like for example:
Starting Servlet engine: [Apache Tomcat/9.0.52] and serve pages with specified port 8101

**resources/application.properties**
	
	server.port=8102

## H2 dependency
Project is setup to run on H2 database and we can see dependency in pom.xml

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		spring.datasource.url=jdbc:h2:mem:testdb
		spring.datasource.driverClassName=org.h2.Driver
		spring.datasource.username=sa
		spring.datasource.password=password
		spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

## Thyme dependency
Now, let us add a front end support using Thymeleaf for which we need below section in pom.xml

		<dependency> 
    			<groupId>org.springframework.boot</groupId> 
    			<artifactId>spring-boot-starter-thymeleaf</artifactId> 
		</dependency>

This allows us to use Thymeleaf tags in html pages that are served. Start by configuring properties required in **application.properties**
