## HELLO THERE GENERAL KENOBI!

First things first. This is web application. Indeed it is. It's suppose to be some kind of registry app to manage 
students, courses and group. How it should works: at the beginning create Course, because Group ain't allow to exist
without Course, Students don't exist outta Group as well. Next create Group, map it with existing Course by using its id.
Finally do the same things with Student.

To run this you will be needed:

- Java 1.8
- Maven
- MySQL

Technologies stack i used in this project:
- Spring boot
- Spring IoC\DI
- JPA
- Hibernate
- Swagger
- REST API
- Maven
- MySQL

Main class: rest-core/src/main/java/com/rest/core/App

Main page: http://localhost:15000/swagger-ui.html#/



##Patch-note
 0.1 

        Students and Groups are not usable, please wait for updates.(added ManyToOne mapping but still did not realize it's method)
        Client(rest-front) still in progress. I was planning of finish rest-core\api module first.
    
0.2 
        
        (!)Client was deleted from project, following the architecture rules. Added methods for GROUP and STUDENT services.
        
        
        