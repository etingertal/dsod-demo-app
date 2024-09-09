## Installation

*	Default active profile is **`h2db`**. When the application is running, **Flyway** will create the necessary tables and system data along with sample data. In this profile, the application uses **H2** database (data in memory).

* 	Other profil **`mysql`** is available. Change the **spring.profiles.active** property in the **application.properties** file to any of the profiles to use it.

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `io.github.anantharajuc.sbmwa` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
	* File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
	* Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/AnanthaRajuC/Spring-Boot-Minimal-Web-App.git
$ cd Spring-Boot-Minimal-Web-App
$ mvn spring-boot:run
```

#### Building and running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command.

##### Building the jar

```shell
$ git clone https://github.com/AnanthaRajuC/Spring-Boot-Minimal-Web-App.git
$ cd Spring-Boot-Minimal-Web-App
$ mvn package -Dmaven.test.skip=true
```

Now you should expect output like this:

```JavaScript
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ spring-boot-minimal-web-app ---
[INFO] Building jar: \Spring-Boot-Minimal-Web-App\target\spring-boot-minimal-web-app-latest.jar
[INFO]
[INFO] --- spring-boot-maven-plugin:2.5.2:repackage (repackage) @ spring-boot-minimal-web-app ---
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 47.299 s
[INFO] Finished at: 2021-07-22T19:00:54+05:30
[INFO] ------------------------------------------------------------------------
```

##### Running the jar

Now it's the time to run the jar, and it's straightforward, just hit the following commands:

```shell
$ java -jar target/spring-boot-minimal-web-app-latest.jar
```

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command

##### Accessing Data in H2 Database

###### H2 Console

URL to access H2 console: **http://localhost:8080/h2-console/login.jsp**

Fill the login form as follows and click on Connect:

* 	Saved Settings: **Generic H2 (Embedded)**
* 	Setting Name: **Generic H2 (Embedded)**
* 	Driver class: **org.h2.Driver**
* 	JDBC URL: **jdbc:h2:mem:sbmwa;MODE=MySQL**
* 	User Name: **sa**
* 	Password:

<img src="images\h2db\h2-console-login.PNG"/>

<img src="images\h2db\h2-console-main-view.PNG"/>

#### Running the application via docker container

* 	Refer to [DOCKER.md](./DOCKER.md) for details.