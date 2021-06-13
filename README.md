![LOGO](https://user-images.githubusercontent.com/67759414/120201068-4e68c680-c225-11eb-87f9-9216754dc110.png)


  
## Basic Overview

 Simple program in java to simulate and manage real library resources for workers. Using this app you can hire/fire employees, view stats about rented books, show info about customers and more! 
 ### Initial interface
![window](https://user-images.githubusercontent.com/67759414/120695303-8bde8580-c4ab-11eb-81f0-c6f3866ac1f8.png)



## Rules and regulations :page_with_curl:
- User can rent an item for a month.
- User can rent 5 items at the time.
- If a user exceeds 100.00 penalty they are added to the black list.
- User can get out of  the black list by paying a penalty.
- For every day of delay penalty is 1.00.

## Project Structure
![diagram](assets/diagram.png)

## VM Options

There are few VM options required to make application running possible

- Main application

```
--add-opens=java.base/java.lang.reflect=com.jfoenix
--add-opens
org.example/org.example.controller.subclasses.worker=ALL-UNNAMED
--add-opens
org.example/org.example.db=ALL-UNNAMED
--add-opens
org.example/org.example.model.item=ALL-UNNAMED
--add-opens
org.example/org.example.model.action=ALL-UNNAMED
--add-opens
org.example/org.example.model.user=ALL-UNNAMED
--add-opens
org.example/org.example.model.user=javafx.base
--add-exports
org.example/org.example.controller.subclasses.manager=ALL-UNNAMED
--add-opens
org.example/org.example.controller.subclasses.manager=ALL-UNNAMED
```


- Tests
```
-ea
--add-exports
javafx.graphics/com.sun.javafx.application=ALL-UNNAMED
--add-modules
javafx.base,javafx.controls,javafx.fxml,javafx.graphics
--add-opens
java.base/java.lang.reflect=com.jfoenix
```

## Contributors :handshake:
    
    
   :whale: Jakub Frączek [machnikovsky](https://github.com/machnikovsky) <br />
   :ringed_planet: Jakub Wojtaś [CodeByJacob](https://github.com/CodeByJacob) <br />
  ✨ Weronika Kłeczek [weronikakleczek](https://github.com/weronikakleczek) <br />
  :turtle: Wojciech Jacoszek [Diluted128](https://github.com/Diluted128)
  



