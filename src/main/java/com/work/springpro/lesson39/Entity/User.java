package com.work.springpro.lesson39.Entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@Table(name = "users")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private int age;
}
