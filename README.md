Coverage: 83.1%
# IMS PROJECT

This project takes an systemized approach to inventory management where it uses database (GCP MYSQL Instance) to store customers, items and orders. The program interacts with the database through JDBC and acceses it by passing the username and password. The program interacts with user through scanner whereby it takes user input.

## Getting Started

- JIRA Board Link - https://team-1606236407721.atlassian.net/jira/software/projects/IMS/boards/5

### Prerequisites

What things you need to install the software and how to install them
Git Bash --> https://gitforwindows.org/
Java jdk-14.0.1 --> https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
Maven --> https://maven.apache.org/download.cgi

### Installing

A step by step series of examples that tell you how to get a development env running

1. Open git Bash.

2. cd to the directory where your file is stored, in my case its in Desktop and go into the documentation folder.

```
$ cd "   your file directory    "/IMS-Starter/Documentation
```

3. Using the command below run ims-0.0.1-jar-with-dependencies.jar file

```
$ java -jar ims-0.0.1-jar-with-dependencies.jar
```

4. Follow the steps, when it asks for the username & password, type in root and press enter.

```
What is your username
root
What is your password
root
```

5. You are in the environment now, here is an example of how to read customers. Good Luck. 

## Running the tests

To run tests please use git bash and use the following file directory structure to cd too. Make sure in the IMS-Starter folder there should be a pom file like below. To see the contents of a folder please use the command ls.

```
$ cd "   your file directory    "/IMS-Starter
```

### Unit Tests 
Unit testing tests each invdiual method of the program. 

Run all the unit test classes.

```
$ mvn test
```

Run a single unit test classe.

```
$ mvn -Dtest= "Test name" test
```

Run a set of unit test classes.

```
$ mvn -Dtest= "Test name", "Test name" test
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
