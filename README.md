# FPL_Backend Engineer Assignment
As we discussed I had to develop an API on JAVA where we can add some numbers to a remote database and get the groups of the converted numbers. 

So I have developed the following api's for the same. We can use these commands in the terminal. Just clone the repo and open the project in Intellij IDEA and run the following command in terminal to build the project:

```
mvn spring-boot:run
```
To add numbers in the database we can make a POST request using the following command: 

```
curl -X POST "http://localhost:8080/api/addNumber?number={number}"
```
Too get the groups we make a get request using the following command:
```
curl -X GET "http://localhost:8080/api/getNumbers"
```
