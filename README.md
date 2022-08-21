# Cryptocurrency Watcher  
***This is REST-service of crypto-price difference monitoring***
_______
  
###### ***Used technology:***
<sub>-Spring Boot 2.7.1  
-Spring Data JPA  
-MySQL database  
-Mapstruct  
-FeignClient  
-Spring Cloud Config  
-Docker compose</sub>
-------
#### Docker Image App:
    docker pull 200605030904/cryptowatcher-app:0.1
_______
#### CoinRestController
###### Show coins list:
    [GET]localhost:8080/cryptocurrency/api/coins
###### Show coin by id:
    [GET]localhost:8080/cryptocurrency/api/coin/id/{id}
###### Show coin by symbol:
    [GET]localhost:8080/cryptocurrency/api/coin/name/{symbol}
_______
#### UserRestController
###### User registration:
    [POST]localhost:8080/cryptocurrency/users?username={username}&symbol={symbol}
