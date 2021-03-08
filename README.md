# TPKanbanBoard

# TP SIR 2-4,5 

### Topic
The objective of this project is to continue the development of a kanban board type application. 


### This work  includes :

    > Annoted Class with JPA
    > A REST part (GET method)
    > A Servlet part (POST and GET methods)

### Before launching the project:

    > Clone the project on github.
    > Modify the file called "persistence.xml" to adapt needed informations for your local database.
    
### Connection to a mysql database

Edit the persistence.xml file to connect to a MySQL database of the istic.

To do this, connect to http://anteros.istic.univ-rennes1.fr (need the vpn https://istic.univ-rennes1.fr/intranet/services#section-4) to create your database. 

Then using the following example http://snipplr.com/view/4450/ modify your persistence.xml file to connect to your database.

It is also necessary to add the jdbc driver to mysql. To do this add the dependency in the pom.xml file

## If you connect to ISTIC (anteros)
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.49</version>
        </dependency>
        
## If you connect to your mysql installed on your machine
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.22</version>
        </dependency>

### To import your project into Eclipse
File -> import -> maven -> existing maven project.
Your project is configured !

 ### Launch application
 
    > Launch HSQLDB server in maven terminal with the command: ./run-hsqldb-server.sh
    > Run JpaTest.java in Jpa package to add pre-fill Database
    > Now, show the firstly data added on Database with the command:  ./show -hsqldb.sh




Done by Issa Sanogo, Ezechiel Zamble and Stephane Kanga.
