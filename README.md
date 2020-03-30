Event management system - This can manage generic events defined by user and communicate this with subscribers

---

Please refer [Wiki](https://github.com/pranavagiligar/velocity/wiki) or [GithubIO](https://pranavagiligar.github.io/velocity/) for better readablity

---

**Setup**
1. Install free [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/#section=mac) and opt for Kotlin in it 
2. [Clone](https://github.com/pranavagiligar/demospring.git) this repository
3. Setup MongoDB server. Easy one is to get free MongoDB database in a hosted server from [HERE](https://account.mongodb.com/account/login)
   - Get setup of cloud MongoDB(Atlas) [HERE](docs/CLOUD_MONGODB_SETUP.md)   
4. Building the project
    1. For Windows: Open the Command prompt in the project directory
        * run the command `gradlew.bat clean bootRun`
    2. For Linux or Mac: Open the Terminal emulator in the project directory
        * run command `./gradlew clean bootRun`
        
             Note: In case you just want to generate JAR file, replace `bootRun` with `bootJar` or `build`
        
    3. Running the jar can be done using command `java -jar build/libs/velocity_{version}_{yyMMddHHmm}/server-{version}.jar`
       - example: 

        ```
        pranava@ubuntu:~/velocity$ pwd
        /home/pranava/velocity
        
        pranava@ubuntu:~/velocity$ ./gradlew clean build
        > Task :compileKotlin
        BUILD SUCCESSFUL in 3s
        5 actionable tasks: 5 executed
        
        pranava@ubuntu:~/velocity$ java -jar build/libs/velocity_0.0.1-SNAPSHOT_2003102238/server-0.0.1-SNAPSHOT.jar
          Spring Boot         (v2.2.4.RELEASE)
      
        embedded.tomcat.TomcatWebServer    : Tomcat started on port: 80 (http) with context path '/api'
        com.velocity.VelocityApplicationKt : Started VelocityApplicationKt in 4.256 seconds
       ```
       
       If you are seeing _Tomcat Started_ and _Started VelocityApplicationKt_, means project successfully built and running on _**port 80**_
   
 5. Running the project: Open a web browser and open `http://localhost/api/server/info` which will show a welcome page
 
    ##### Note: This Project needs Java 8/11
 
---

**Configurations**
1. The _`application.properties`_ file contains the line
`spring.data.mongodb.uri=${MONGO_URL_CON}`
in which `MONGO_URL_CON` is the MongoDB database URL of the MongoDB server which is the system environment variable

   #####  Find the steps to set `MONGO_URL_CON` as system environment variable in [HERE](docs/ENV_CONFIG.md)

2. The port number of the server can be configured in _`application.properties`_ file. Default port number is port `80`

---

**Learning resources**
+ [Quickstart](https://spring.io/quickstart)
+ [Quides](https://spring.io/guides)
+ [Kotlin documentation](https://kotlinlang.org/docs/reference/)
+ [SpringBoot using Kotlin Example-1](https://spring.io/guides/tutorials/spring-boot-kotlin/)
+ [SpringBoot using Kotlin Example-2](https://developer.okta.com/blog/2019/09/17/build-a-spring-boot-kotlin-app)
+ [SpringBoot with MongoDB CRUDs](https://www.devglan.com/spring-boot/spring-boot-mongodb-crud)
+ [SpringBoot demo project using MongoDB](https://github.com/spring-guides/tut-spring-boot-kotlin)
+ [Access MongoDB data](https://spring.io/guides/gs/accessing-data-mongodb/)
+ [SpringBoot with Spring-Security, MongoDB and JWT authentication and authorization](https://bezkoder.com/spring-boot-jwt-auth-mongodb/)
+ [SpringBoot with JWT Authentication using Spring Security](https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/)

---

**Keywords**
+ Spring Boot 2.2.4
+ Spring Security
+ Kotlin
+ Java 8/11
+ MongoDB
+ JWT
+ Gradle 
+ REST API

---

Project Velocity -
[Copyright (c) 2020 Pranava Giligar](https://github.com/pranavagiligar/velocity/blob/master/LICENSE)
