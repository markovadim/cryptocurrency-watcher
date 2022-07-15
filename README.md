# Cryptocurrency Watcher  
***This is REST-service of crypto-price difference monitoring***
_______
  
###### ***Used technology:***
<sub>-Spring Boot 2.7.1  
-Spring Data JPA  
-MySQL database</sub>
_______
#### CoinRestController
###### Show coins list:
    [GET]localhost:8080/cryptocurrency/api/coins
###### Show coin by id:
    [GET]localhost:8080/cryptocurrency/api/coins/id/{id}
###### Show coin by symbol:
    [GET]localhost:8080/cryptocurrency/api/coins/name/{symbol}
_______
#### UserRestController
###### User registration:
    [POST]localhost:8080/cryptocurrency/users?username={username}&symbol={symbol}
