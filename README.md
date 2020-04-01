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
        
    3. Running the jar can be done using command `java -jar -Ddebug=true build/libs/velocity_{version}_{yyMMddHHmm}/server-{version}.jar`
       - example: 

        ```
        pranava@ubuntu:~/velocity$ pwd
        /home/pranava/velocity
        
        pranava@ubuntu:~/velocity$ ./gradlew clean build
        > Task :compileKotlin
        BUILD SUCCESSFUL in 3s
        5 actionable tasks: 5 executed
        
        pranava@ubuntu:~/velocity$ java -jar -Ddebug=true build/libs/velocity_0.0.1-SNAPSHOT_2003102238/server-0.0.1-SNAPSHOT.jar
          Spring Boot         (v2.2.4.RELEASE)
      
        embedded.tomcat.TomcatWebServer    : Tomcat started on port: 80 (http) with context path '/api'
        com.velocity.VelocityApplicationKt : Started VelocityApplicationKt in 4.256 seconds
       ```
       
       If you are seeing _Tomcat Started_ and _Started VelocityApplicationKt_, means project successfully built and running on _**port 80**_
       Note: `-Ddebug=true` switch is temporary. Future commits would include Custom Run configuration file. 
  
 5. Insert roles into `roles` collection in MongoDB.
 
    ```
    db.roles.insertMany([
       { name: "ROLE_USER" },
       { name: "ROLE_MODERATOR" },
       { name: "ROLE_ADMIN" },
    ])
    ```
    Note: Currently this is manual step. In future this might be done through an API 
   
 6. Running the project: Open a web browser and open `http://localhost/api/server/info` which will show a welcome page
 
    ##### Note: This Project needs Java 8/11
 
---

**Configurations**
1. The _`application.properties`_ file contains the line
`spring.data.mongodb.uri=${MONGO_URL_CON}`
in which `MONGO_URL_CON` is the MongoDB database URL of the MongoDB server which is the system environment variable

   #####  Find the steps to set `MONGO_URL_CON` as system environment variable in [HERE](docs/ENV_CONFIG.md)
   
2. Like `MONGO_URL_CON` environment variable setup, `JWT_SECRET_KEY` also need to be set as environment variable. The key is any string which represent as encryption password

3. The `application.properties` has a key called `com.velocity.jwtExpirationMs` which represents JWT expiration time in milliseconds. Default is 1-Day(86400000 ms)

4. The port number of the server can be configured in _`application.properties`_ file. Default port number is port `80`

5. Postman collection 2.1 can be found in `velocity/docs/velocity.postman_collection.json`

---

**Project structure**

The current project structure is just a draft. After getting comfortable with Spring, package refactor will be done.

    ```
    pranava@ubuntu:~/velocity/src/main$ pwd
    /user/pranava/velocity/src/main
    pranava@ubuntu:~/velocity/src/main$ tree
    
    .
    ├── java                                        # Java files
    ├── kotlin                                      # Kotlin files
    │   └── com                                     
    │       └── velocity                                        
    │           ├── VelocityApplication.kt          # Main class                      
    │           ├── config                          # DB configs. (Temporary)        
    │           │   └── MongoConfig.kt                                 
    │           ├── controller                      # Entry point of API (Apart from filters)              
    │           │   ├── AuthController.kt                                  
    │           │   └── UserController.kt                                   
    │           ├── dao                             # Access point for all repository (DB and network calls)    
    │           ├── db                              # Datebase     
    │           │   ├── doc                         # Collection models        
    │           │   └── repo                        # Base Reposiotries to access collections            
    │           ├── model                                   
    │           │   ├── ERole.kt                    # Static predefined roles               
    │           │   └── payload                     # Request/Response models            
    │           │       ├── request                 # Request models                 
    │           │       └── response                # Response models                     
    │           ├── security                        # Spring security related modules            
    │           │   ├── WebSecurityConfig.kt        # Route - authentication/authorization configs                            
    │           │   ├── jwt                         # JWT related classes         
    │           │   └── service                     # Secuirty support services (UserDetailsService implementations)           
    │           └── service                         # Application business logics       
    └── resources                                   # All the Spring configuration files
        └── application.properties                  # Application properties (Like MongoDB connection URL, JWT secret key)
        
    ```

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
+ [JWT](https://jwt.io/introduction/)

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
