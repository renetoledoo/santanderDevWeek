package org.api.rt.DevWeek.controller;

import java.net.URI;

import org.api.rt.DevWeek.model.User;
import org.api.rt.DevWeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)  {
       User usuario =  userService.findById(id);
       return ResponseEntity.ok(usuario);
    }

    @PostMapping() 
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {
        
        var userCreated = userService.create(userToCreate);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                       .path(("/{id}"))
                       .buildAndExpand(userCreated.getId()).toUri();
        return ResponseEntity.created(location).body(userCreated);
        
    }
    
}
