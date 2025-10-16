package com.kiboro.kiboro_back.api.ressources;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kiboro.kiboro_back.api.dtos.Responses.UsersResponse;
import com.kiboro.kiboro_back.api.dtos.requests.users.CreateUsersRequest;
import com.kiboro.kiboro_back.api.mapper.UsersMapper;
import com.kiboro.kiboro_back.domain.UsersService;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;
    private final UsersMapper usersMapper;


    @PostMapping("/user")
    public UsersResponse CreateUser(@RequestBody CreateUsersRequest createUsersRequest)
    {
        try {
        
            return usersMapper.toResponse(usersService.createUser(createUsersRequest));

            
        } catch (Exception e) {
            
            return null;
        }
    }



    @PutMapping("/user/{id}")
    @ResponseBody
    public String hi(@PathVariable String id)
    {
        return "hi " + id.toString();
    }
    
    @GetMapping("/user/{id}")
    @ResponseBody
    public UsersResponse getUser(@PathVariable String id)
    {
        try {

            return usersMapper.toResponse(usersService.getOne(Long.valueOf(id)));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable String id)
    {
        return "Deleted user " + id.toString();
    }



}
