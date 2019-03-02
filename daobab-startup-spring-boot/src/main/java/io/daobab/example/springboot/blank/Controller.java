package io.daobab.example.springboot.blank;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class Controller /* implement generated *Tables interface */ {

    //Inject here your DataBaseTarget generated by Daobab
//    private @Autowired
//    PizzaDataBase db;



    @GetMapping("/t01")
    public String t01(){ return "test 01"; }

    @GetMapping("/t02")
    public String t02(){ return "test 02"; }

    @GetMapping("/t03")
    public String t03(){ return "test 03"; }

    @GetMapping("/t04")
    public String t04(){ return "test 04"; }

    @GetMapping("/t05")
    public String t05(){  return "test 05"; }
}