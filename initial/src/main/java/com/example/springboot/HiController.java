package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

//	Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity a
//  1 - Annotate a new class with the @RestController annotation.
//  2 - Create a new endpoint "/info" using the @GetMapping annotation.
//  3 - In the method, return a ResponseEntity with 200 OK


    @GetMapping("/info")
    public ResponseEntity<String> index3() {
        return ResponseEntity.status(200).body("\n    OK");
    }
}
