package com.accenture.boot.camp.evercraft.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class coreGame {

    @GetMapping("/")
    public String getGreet()
    {

        return "Hello Real World";
    }
  @GetMapping("/person")
  public String getName(@RequestParam(required = false) String name)
  {
      if(name ==null||name.isEmpty())
      {
          return "Hello, World";
      }
      else {
          return "Hello"+name;
      }
  }

}
