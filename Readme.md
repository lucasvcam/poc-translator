# Problem

The company needs to manage its translators, so it needs a system that performs this management (CRUD) displaying all information belonging to the translators name, email, source language, target language.

# Required Technologies:

1) For the backend:
* Spring Boot - https://spring.io/projects/spring-boot
* Spring Data JPA - https://spring.io/projects/spring-data-jpa
* Gradle - https://gradle.com/
* PostgreSQL - https://www.postgresql.org/

2) For the frontend, choose one of the alternatives below:
* Vue - https://vuejs.org/
* AngularJS - https://angularjs.org/

#Solution

A translator management application has been developed where it is possible to manage translators (CRUD). Was used AngularJs on the front end and the technologies needed for the back end.

Because of the possibility of a large mass of data in the bank, a pagination and search were included.
Search works by filtering the records visible on the current page. To optimize the search, we can increase the number of records to be displayed and thus filtered.

Was chose to pre-enter languages ??in the base, via Flyway, so they can be used following the i18n internationalization standard.

The database was created in Heroku.

#Instructions

You must perform configuration of the Java environment.
Must be using at least Java version 8.
Here is a link to setup on Windows:

```shell
https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html
```

You must download the application repository and import it into your favorite IDE.

In eclipse, for example, we will import the gradle project and resolve any compilation errors that may appear, usually the errors are resolved by updating or downloading dependencies in the gradle again.

With all errors corrected, we can run the application.
In the PocTranslatorApplication class, we run the application:

```shell
Right-click the class> Run As> Java Application.
```

We hope Spring makes all the necessary configurations, we hope Flyway makes the first creations and inserts.
When it's all over, we open the browser and access the link: 

```shell
http://localhost:8080
```

Now we can view the entire application and manage the translators.

Thanks, all the questions I am available.
