package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    //    Exercise 1: Create a GetMapping that returns a basic "string" as a response
   //  1 - Create a new endpoint "/hello" using the @GetMapping annotation.
   //   2 - In the method, return a simple string such as "Hello World!".
    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }


  //    Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
  //  1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
  //  2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
  //  3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".

    @GetMapping("/greeting")
    public ResponseEntity<String> index2() {

//		così per ristornare a mano lo stato della get!
//		return ResponseEntity.status(200).body("Good Afternoon!");

        //così non c'è bisogno di specificare lo status!!
        return ResponseEntity.ok("Good Afternoon!");
    }


}
