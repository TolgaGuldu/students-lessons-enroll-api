
# student-lesson-enroll-api

####  Student Lesson enroll api used to add, delete and register students and lessons

## Getting Started

Please follow the below steps to setup and run student-lesson-enroll-api

### Prerequisites

- This project requires Java 8 need to be installed.
- Install any Java IDE (Eclipse, STS, Intellij etc..) and ensure you are able to launch
-  Clone/Checkout the project from version control system (git) and follow below steps

```
$ cd student-lesson-enroll-api
$ mvn clean install 
$ mvn spring-boot:run -e
$ Open web browser & hit the swagger url: http://localhost:8080/student-lesson/swagger-ui.html
```
## Development Setup

- Clone student-lesson-enroll-api project. (git clone <repo url>)
- Open eclipse and import this project under (Existing Maven project)

## Tech stack

* [Java Development Kit 8 or higher](#java), Open JDK or Oracle JDK
* [Maven](#maven)
* [Git](#git)
- Spring Boot: 2.1.7.RELEASE
- [Lombok For Building POJO](https://projectlombok.org/)
- H2 In-Memory DB
- Swagger2 - For API Local Testing

## Running the Unit tests
```
$ Open Terminal or commandLine window
$ cd <path/to/student-lesson-enroll-api>
$ mvn test -e
```

### Java 

To check if you have a compatible version of Java installed, use the following command:

    java -version
    
If you don't have a compatible version, you can download either [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [OpenJDK](https://openjdk.java.net/install/)    

### Maven
To check if you have Maven installed, use the following command:

    mvn --version
    
To install Maven, you can follow the instructions [here](https://maven.apache.org/install.html).      

### Git

Install the [latest version of Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).

## Download Code

In order to work on code, create a fork from GitHub page. 
Use Git for cloning the code to your local or below line for Ubuntu:

	git clone <your-fork-git-link>

A directory called WordNet will be created. Or you can use below link for exploring the code:

	git clone https://github.com/TolgaGuldu/students-lessons-enroll-api.git

## Open project with IntelliJ IDEA

Steps for opening the cloned project:

* Start IDE
* Select **File | Open** from main menu
* Choose `student-lesson-enroll-api/pom.xml` file
* Select open as project option
* Couple of seconds, dependencies with Maven will be downloaded. 



## Testing API
- Open http://localhost:8080/student-lesson/swagger-ui.html
- Click on addStudent or any one of the endPoint.
- Click on Try it out and fill the input payload as per the contract.
- Finally Click on Excetue and ensure to see the 200 response with response message.
- Also Open http://localhost:8080/student-lesson/h2/ from web browser and click on Connect without password to view the data persisted by this api.

## Developer(s)

*  Tolga Güldütuna

## Acknowledgments

* [Enable Swagger UI api-docs](https://www.vojtechruzicka.com/documenting-spring-boot-rest-api-swagger-springfox/)
* [Spring Boot Rest API](https://spring.io/guides/gs/rest-service/)
