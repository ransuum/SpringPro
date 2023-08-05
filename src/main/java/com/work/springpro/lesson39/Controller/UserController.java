package com.work.springpro.lesson39.Controller;

import com.work.springpro.lesson39.Controller.UserDto.IntegerDto;
import com.work.springpro.lesson39.Controller.UserDto.UserDto;
import com.work.springpro.lesson39.Controller.UserMapper.UserMapper;
import com.work.springpro.lesson39.Entity.User;
import com.work.springpro.lesson39.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll().stream()
                .map(userMapper::UserToDto).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Integer id){
        return userService.getById(id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userMapper.UserToDto(userService.save(userMapper.toEntity(userDto))),
                HttpStatus.CREATED);
    }
    @PutMapping
    public UserDto update(@RequestBody UserDto userDto){
        return userMapper.UserToDto(userService.update(userMapper.toEntity(userDto)));
    }
    @GetMapping("/{email}/{phone}")
    public UserDto getUserByEmailAndPhone(
            @PathVariable String email,
            @PathVariable String phone){
        return userMapper.UserToDto(userService.getUserByEmailAndPhone(email, phone));
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable int id){
        return userService.delete(id);
    }
    @GetMapping("/filter")
    public UserDto find(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam String email){
        return userMapper.UserToDto(userService.findByNameAndSurnameAndEmail(name, surname, email));
    }
    @PutMapping("/{id}/{name}")
    public IntegerDto updateById(
            @PathVariable String name,
            @PathVariable Integer id){
        return new IntegerDto(userService.UpdateById(name, id));
    }
}
