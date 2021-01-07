Coverage: 83.1%
# IMS PROJECT

This project takes an systemized approach to inventory management where it uses database (GCP MYSQL Instance) to store customers, items and orders. The program interacts with the database through JDBC and acceses it by passing the username and password. The program interacts with user through scanner whereby it takes user input.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
Git Bash --> https://gitforwindows.org/
Java jdk-14.0.1 --> https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html

### Installing

A step by step series of examples that tell you how to get a development env running

1. Open git Bash.

```
$ PCNAME@LAPTOP-AU150LFG MINGW64 /
```

2. cd to the directory where your file is stored, in my case its in Desktop and go into the documnetation folder.
   command: $ cd "   your file directory    "/IMS-Starter/Documentation

```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter/documentation (master)
$
```

3. Using the command below run ims-0.0.1-jar-with-dependencies.jar file
command: $ java -jar ims-0.0.1-jar-with-dependencies.jar

```
PCNAME@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter/documentation (master)
$ java -jar ims-0.0.1-jar-with-dependencies.jar
What is your username
```
4. Follow the steps, when it asks for the username & password, type in root and press enter.
```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter/documentation (master)
$ java -jar ims-0.0.1-jar-with-dependencies.jar
What is your username
root
What is your password
root
```
5. You are in the environment now, here is an example of how to read customers. Good Luck. 
```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter/documentation (master)
$ java -jar ims-0.0.1-jar-with-dependencies.jar
What is your username
root
What is your password
root
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
STOP: To close the application
customer
What would you like to do with customer:
CREATE: To save a new entity into the database
READ: To read an entity from the database
UPDATE: To change an entity already in the database
DELETE: To remove an entity from the database
RETURN: To return to domain selection
read
id: 1 first name: jordan surname: harrison
id: 2 first name: chetan surname: pardeep
id: 3 first name: prince surname: masih
id: 4 first name: soham surname: pardeep
```

## Running the tests

To run tests please use git bash and use the following file directory structure to cd too. Make sure in the IMS-Starter folder there should be a pom file like below. To see the contents of a folder please use the command ls.
command: $ cd "   your file directory    "/IMS-Starter
```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter (master)
$ ls
Documentation/  LICENSE.md  README.md  bin/  errors.log  pom.xml  src/  target/
```

### Unit Tests 
Unit testing tests each invdiual method of the program. 
Run all the unit test classes.
Use: $ mvn test

```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter (master)
$ mvn test
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------------< com.qa.ims:ims >---------------------------
[INFO] Building ims 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (default) @ ims ---
[INFO] argLine set to -javaagent:C:\\Users\\cheta\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.5\\org.jacoco.agent-0.8.5-runtime.jar=destfile=C:\\Users\\cheta\\Desktop\\IMS-Starter\\target\\jacoco.exec
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ ims ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 4 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ ims ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 25 source files to C:\Users\cheta\Desktop\IMS-Starter\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ ims ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ ims ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ ims ---
[INFO] Surefire report directory: C:\Users\cheta\Desktop\IMS-Starter\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------

Results :

Tests run: 38, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- jacoco-maven-plugin:0.8.5:report (report) @ ims ---
[INFO] Loading execution data file C:\Users\cheta\Desktop\IMS-Starter\target\jacoco.exec
[INFO] Analyzed bundle 'ims' with 17 classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  44.299 s
[INFO] Finished at: 2021-01-07T20:21:23Z
[INFO] ------------------------------------------------------------------------

```


### Integration Tests 
Integration testing will test the units which make the program. 
To Run Integration test:
Use: $ mvn verify -Psurefire

```
cheta@LAPTOP-AU150LFG MINGW64 ~/Desktop/IMS-Starter (master)
$ mvn verify -Psurefire
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------------< com.qa.ims:ims >---------------------------
[INFO] Building ims 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.5:prepare-agent (default) @ ims ---
[INFO] argLine set to -javaagent:C:\\Users\\cheta\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.5\\org.jacoco.agent-0.8.5-runtime.jar=destfile=C:\\Users\\cheta\\Desktop\\IMS-Starter\\target\\jacoco.exec
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ ims ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 4 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ ims ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[INFO] Compiling 25 source files to C:\Users\cheta\Desktop\IMS-Starter\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ ims ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ ims ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ ims ---
[INFO] Surefire report directory: C:\Users\cheta\Desktop\IMS-Starter\target\surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Results :

Tests run: 38, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  51.751 s
[INFO] Finished at: 2021-01-07T20:31:28Z
[INFO] ------------------------------------------------------------------------

```

### And coding style tests
This generates a report on the code style of the program the developer has chosen to use.
To Run Code Style test:
Use: $ mvn checkstyle:checkstyle
```
[INFO]
[INFO] ---------------------------< com.qa.ims:ims >---------------------------
[INFO] Building ims 0.0.1
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-checkstyle-plugin:3.1.1:checkstyle (default-cli) @ ims ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.966 s
[INFO] Finished at: 2021-01-07T20:41:38Z
[INFO] -----
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Chetan Pardeep** - *Rest of the work* - [chetanpardeep](https://github.com/QAcpardeep)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
