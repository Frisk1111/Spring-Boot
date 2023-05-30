package com.example.springboot;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HiController2 {

//    Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean

//1 - Annotate a new class with the @RestController annotation.
// 2 - Create a new endpoint "/random" using the @GetMapping annotation.
// 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
    @GetMapping("/random")
    public ResponseEntity<String> index(){
        if( new Random().nextBoolean()){
            return
            ResponseEntity.ok().body(" 200 OK");
        } else {
            return ResponseEntity.badRequest().body(" NOT OK !");
        }
    }




}
