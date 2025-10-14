package com.kiboro.kiboro_back.api.ressources;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @PostMapping("/book")
    @ResponseBody
    public String createBook()
    {
        return "Book created";
    }



    @PutMapping("/book/{id}")
    @ResponseBody
    public String updateBook(@PathVariable String id)
    {
        return "Book updated " + id.toString();
    }
    
    @GetMapping("/book/{id}")
    @ResponseBody
    public String getBook(@PathVariable String id)
    {
        return "Hello books héhé " + id.toString();
    }

    @DeleteMapping("/book/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable String id)
    {
        return "Deleted booked " + id.toString();
    }


}
