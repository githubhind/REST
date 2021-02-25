package com.test.rest.rest.controler;

import com.test.rest.rest.controler.exception.UserNotFoundException;
import com.test.rest.rest.domain.User;
import com.test.rest.rest.service.UserService;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserControler {

    private UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("users/{id}")
    public EntityModel<User> getById(@PathVariable("id") Long id){
        User user = userService.getById(id).orElseThrow(() -> new UserNotFoundException(id));
        return EntityModel.of(user,
                linkTo(methodOn(UserControler.class).getById(id)).withSelfRel(),
                linkTo(methodOn(UserControler.class).getAll()).withRel("users")
        );
    }

    @PostMapping("users")
    public User create(@RequestBody User user){
        user.setId(null);
        return userService.save(user);
    }

    @PutMapping("users/{id}")
    public User update(@RequestBody User newUser, @PathVariable Long id){
        return userService.getById(id)
                .map(u -> {
                    u.setName(newUser.getName());
                    u.setRole(newUser.getRole());
                    return userService.save(u);
                })
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("users/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.deleteById(id);
    }
}
