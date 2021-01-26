# Takeaway-GameOfThree
Game of Three coding challenge for Takeaway

1. There are 2 Spring boot based microservice in this project Player1 and Player2, built using **Java 8**, **Spring boot 2.4.2** and **Gradle**
2. Build project on local using command (for MAC only) - **./gradlew clean build** from the respective Micro service parent directory, for eg. `cd ~\rupeshsharma\exchangerateservice`
3. Run using command **./gradlew bootRun** (alternatively, use docker build and docker run commands to run with docker)
4. Swagger UI for Player1 - http://localhost:8080/swagger-ui.html#
5. Swagger UI for Player2 - http://localhost:8081/swagger-ui.html#
6. Check status of Player1 application using - http://localhost:8080/actuator/health
7. Check status of Player2 application using - http://localhost:8081/actuator/health
8. Verify the result using application logs, you should see "Player1 Wins!!" or Player2 Wins!! in the respective application logs

### API

1. Player 1 - Play : <br>
a. With manual input - <br><br>
Sample Request - <br>
   `http://localhost:8080/1.0/player1/play?number=56` <br><br>
   Sample Response - <br>
   ``{
   "status": "SUCCESS",
   "errors": []
   }``<br><br>

   b. Without manual input - <br><br>
      Sample Request - <br>
      `http://localhost:8080/1.0/player1/play` <br><br>
      Sample Response - <br>
      ``{
      "status": "SUCCESS",
      "errors": []
      }``<br><br>

2. Player 2 - Play :<br>
   a. With manual input - <br><br>
   Sample Request - <br>
   `http://localhost:8081/1.0/player2/play?number=56` <br><br>
   Sample Response - <br>
   ``{
   "status": "SUCCESS",
   "errors": []
   }``<br><br>

   b. Play (without manual input) - <br><br>
   Sample Request - <br>
   `http://localhost:8081/1.0/player2/play` <br><br>
   Sample Response - <br>
   ``{
   "status": "SUCCESS",
   "errors": []
   }``<br><br>


##### Notes:
1. Spring WebFlux has been used to enable event based communication between the 2 microservices. Same can be achieved via queues or message brokers like Kafka, RabbitMQ etc.
2. Microservices are not hosted on AWS, they use localhost to communicate with each other
3. Service discovery is not present to discover the microservices, Eureka or any other service discovery framework can be used for that.
4. No security framework is present to secure Microservcies
5. Minimal test cases are present
6. For log tracing, Sleuth/Zipkin can be used in Micro services
7. Exception handling is done as required, not at all places
8. Logging is minimal as needed
9. Configuration is done via application properties file, same can be achieved using spring cloud config for externalization.


#### Task
###### Game of Three - Coding Challenge
Goal<br>
The Goal is to implement a game with two independent units – the players –
communicating with each other using an API.
Description
When a player starts, it incepts a random (whole) number and sends it to the second
player as an approach of starting the game. The receiving player can now always choose
between adding one of {1, 0, 1} to get to a number that is divisible by 3. Divide it by three. The
resulting whole number is then sent back to the original sender.
The same rules are applied until one player reaches the number 1(after the division).
See example below.

For each "move", a sufficient output should get generated (mandatory: the added, and
the resulting number). Both players should be able to play automatically without user input. The
type of input (manual, automatic) should be optionally adjustable by the player.
