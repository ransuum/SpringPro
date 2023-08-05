package com.work.springpro.lesson39.Controller.UserDto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int age;
}
