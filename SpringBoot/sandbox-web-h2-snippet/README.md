# Getting Started

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
	
	server.port=8101

## Get all Snippets

	$ curl -s localhost:8101/snippets | jq

	[
	  {
	    "id": 1,
	    "title": "Optional ",
	    "content": "Check Optional using isExists",
	    "category": "Java"
	  },
	  {
	    "id": 2,
	    "title": "Optional Hello ",
	    "content": "Check Optional using isExists",
	    "category": "Java"
	  },
	  {
	    "id": 3,
	    "title": "Configuration Bean annotation",
	    "content": "use the @Bean Annotation in the @Configuration class to preload entities",
	    "category": "SpringBoot"
	  }
	]
		 

## Get individual Snippet
	
	$ curl -s localhost:8101/snippets/1
	
	{"id":1,"title":"Optional ","content":"Check Optional using isExists","category":"Java"}

## Add new Snippet

 	$ curl -X POST localhost:8101/snippets -H 'Content-type:application/json' -d '{"category": "Python", "title":"Print Statement" , "content" : "print (1)"}'
	
	{"id":4,"title":"Print Statement","content":"print (1)","category":"Python"}

	$ curl -s localhost:8101/snippets | jq
	[
	  {
	    "id": 1,
	    "title": "Optional ",
	    "content": "Check Optional using isExists",
	    "category": "Java"
	  },
	  {
	    "id": 2,
	    "title": "Optional Hello ",
	    "content": "Check Optional using isExists",
	    "category": "Java"
	  },
	  {
	    "id": 3,
	    "title": "Configuration Bean annotation",
	    "content": "use the @Bean Annotation in the @Configuration class to preload entities",
	    "category": "SpringBoot"
	  },
	  {
	    "id": 4,
	    "title": "Print Statement",
	    "content": "print (1)",
	    "category": "Python"
	  }
	]

## Replace existing Snippet

	curl -X PUT localhost:8101/snippets/1 -H 'Content-type:application/json' -d '{ "category": "Emacs" , "title": "demo", "content": "Hello"}'

## Delete existing Snippet

	$ curl -X DELETE localhost:8101/snippets/3

	$ curl -s localhost:8101/snippets | jq
	[
	  {
	    "id": 1,
	    "title": "demo",
	    "content": "Hello",
	    "category": "Emacs"
	  },
	  {
	    "id": 2,
	    "title": "Optional Hello ",
	    "content": "Check Optional using isExists",
	    "category": "Java"
	  }
	]


## H2 dependency
Project is setup to run on H2 database and we can see dependency in pom.xml

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

## Thyme dependency
Now, let us add a front end support using Thymeleaf for which we need below section in pom.xml

		<dependency> 
    			<groupId>org.springframework.boot</groupId> 
    			<artifactId>spring-boot-starter-thymeleaf</artifactId> 
		</dependency>

This allows us to use Thymeleaf tags in html pages that are served. Start by configuring properties required in **application.properties**

There are examples that show how to invoke the Controller that has a function that returns back a thymeleaf template.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#production-ready)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.5.4/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

