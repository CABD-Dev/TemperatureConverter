# Temperature
This project is for temperature 

Spring Boot Application - [Temperature]
This project is a Spring Boot application for [converting celsius to fahrenheit and fahrenheit to celcius].

# Prerequisites
Java Development Kit (JDK): Ensure you have a compatible JDK version installed. Refer to the Spring Boot documentation for specific requirements (https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html).
Maven: Maven is a build automation tool used to build and manage the project's dependencies. Download and install from the official Maven website (https://maven.apache.org/download.cgi).

# Running Unit Tests
Navigate to the project directory: Use your terminal to navigate to the root directory of your Spring Boot application.

Execute Maven command: Run the following command to execute all unit tests:


Bash
mvn test


Use code with caution.
This command will compile your code, run all unit tests using the default test runner (usually JUnit), and report the results.

# Running the Application
There are two primary ways to run your Spring Boot application:

1. Using Maven:

Navigate to the project directory: As before, navigate to the root directory of your Spring Boot application.

Execute Maven command: Run the following command to start the application:


Bash
mvn spring-boot:run


Use code with caution.
This command will compile your code, package the application into an executable JAR file, and start the application server embedded within Spring Boot.

2 . Using a dedicated IDE: Many IDEs like IntelliJ IDEA and Spring Tool Suite provide built-in functionality to run Spring Boot applications directly. Refer to your IDE's documentation for specific instructions.

# Testing the Application

1. You can test the application by hitting the exposed API using the postman collection provided in point 5.

2. There is a simple interface feature after you execute mvn spring-boot:run, simply follow the instruction written on the console and you can convert temperatures even without hitting the API.

# Additional Notes

1. for the sample request/response you can download this postman collection (https://drive.google.com/file/d/15zHCpsWJCpZ56NodjY14T9abYZ4LVaFj/view?usp=drive_link)
