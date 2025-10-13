package com.kiboro.kiboro_back.api.ressources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class UserController {


    @PostMapping("/user")
    @ResponseBody
    public String user()
    {
        return "user";
    }



    @PutMapping("/user/{id}")
    @ResponseBody
    public String hi(@PathVariable String id)
    {
        return "hi " + id.toString();
    }
    
    @GetMapping("/user/{id}")
    @ResponseBody
    public String helloGFG(@PathVariable String id)
    {
        return "Hello GeeksForGeeks " + id.toString();
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable String id)
    {
        return "Deleted user " + id.toString();
    }



}
